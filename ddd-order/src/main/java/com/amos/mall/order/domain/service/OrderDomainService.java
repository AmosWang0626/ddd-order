package com.amos.mall.order.domain.service;

import com.amos.mall.inventory.api.InventoryApi;
import com.amos.mall.order.domain.model.OrderEntity;
import com.amos.mall.order.domain.model.OrderItem;
import com.amos.mall.order.infrastructure.exception.BizException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Order 领域服务
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/12/2
 */
@Service
public class OrderDomainService {

    @Resource
    private InventoryApi inventoryApi;

    /**
     * 校验商品库存
     *
     * @param orderEntity 订单实体
     */
    public void checkStockEnough(OrderEntity orderEntity) {
        for (OrderItem orderItem : orderEntity.getOrderItems()) {
            boolean stockEnough = inventoryApi.stockEnough(orderItem.getGoodsSkuId(), orderItem.getPurchaseCount());
            if (!stockEnough) {
                throw new BizException("商品库存不足");
            }
        }
    }

    /**
     * 锁定商品库存
     *
     * @param orderEntity 订单实体
     */
    public void lockStock(OrderEntity orderEntity) {
        List<OrderItem> lockedOrderItem = new ArrayList<>();
        for (OrderItem orderItem : orderEntity.getOrderItems()) {
            boolean lockResult = inventoryApi.lockStock(orderItem.getGoodsSkuId(), orderItem.getPurchaseCount());
            if (lockResult) {
                lockedOrderItem.add(orderItem);
                continue;
            }
            for (OrderItem item : lockedOrderItem) {
                inventoryApi.unlockStock(item.getGoodsSkuId(), item.getPurchaseCount());
            }

            throw new BizException("锁定库存失败，请稍后重试吧～");
        }
    }

    /**
     * 扣减库存
     *
     * @param orderEntity 订单实体
     */
    public void reduceStock(OrderEntity orderEntity) {
        List<OrderItem> deductedOrderItem = new ArrayList<>();
        for (OrderItem orderItem : orderEntity.getOrderItems()) {
            boolean lockResult = inventoryApi.reduceStock(orderItem.getGoodsSkuId(), orderItem.getPurchaseCount());
            if (lockResult) {
                deductedOrderItem.add(orderItem);
                continue;
            }
            for (OrderItem item : deductedOrderItem) {
                inventoryApi.addStock(item.getGoodsSkuId(), item.getPurchaseCount());
            }

            throw new BizException("扣减库存失败，请稍后重试吧～");
        }
    }
}
