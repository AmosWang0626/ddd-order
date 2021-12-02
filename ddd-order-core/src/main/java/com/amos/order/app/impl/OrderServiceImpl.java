package com.amos.order.app.impl;

import com.amos.inventory.api.InventoryApi;
import com.amos.order.api.model.CreateOrderParam;
import com.amos.order.api.model.OrderStatus;
import com.amos.order.app.OrderService;
import com.amos.order.app.factory.OrderFactory;
import com.amos.order.domain.model.OrderEntity;
import com.amos.order.domain.model.OrderItem;
import com.amos.order.infra.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 订单应用服务
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/12/1
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private InventoryApi inventoryApi;
    @Resource
    private OrderRepository orderRepository;

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public boolean create(CreateOrderParam co) {
        // 调用库存上下文/子域/系统的接口，校验库存是否充足
        // 使用订单聚合的资源库，把订单存储到DB中
        // 调用订单的行为，更新订单状态为待付款
        // 请求库存系统，冻结库存，如果冻结失败，则回滚当前事务
        OrderEntity orderEntity = OrderFactory.build(co);

        // 校验库存
        for (OrderItem orderItem : orderEntity.getOrderItems()) {
            boolean stockEnough = inventoryApi.stockEnough(orderItem.getGoodsSkuId(), orderItem.getPurchaseCount());
            if (!stockEnough) {
                return false;
            }
        }

        orderRepository.save(orderEntity);

        List<OrderItem> lockedOrderItem = new ArrayList<>();
        for (OrderItem orderItem : orderEntity.getOrderItems()) {
            boolean lockResult = inventoryApi.lockStock(orderItem.getGoodsSkuId(), orderItem.getPurchaseCount());
            if (lockResult) {
                lockedOrderItem.add(orderItem);
                continue;
            }
            for (OrderItem item : lockedOrderItem) {
                boolean unlockResult = inventoryApi.unlockStock(item.getGoodsSkuId(), item.getPurchaseCount());
                if (unlockResult) {
                    // TODO retry unlock
                }
            }

            throw new RuntimeException("锁定库存失败，请稍后重试吧～");
        }

        orderEntity.updateStatus(OrderStatus.PENDING_PAYMENT);

        return true;
    }

}
