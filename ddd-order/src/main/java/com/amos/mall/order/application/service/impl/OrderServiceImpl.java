package com.amos.mall.order.application.service.impl;

import com.amos.mall.order.api.model.CreateOrderParam;
import com.amos.mall.order.api.model.OrderStatus;
import com.amos.mall.order.application.assembler.OrderAssembler;
import com.amos.mall.order.application.service.OrderService;
import com.amos.mall.order.domain.event.OrderPaidEvent;
import com.amos.mall.order.domain.model.OrderEntity;
import com.amos.mall.order.domain.service.OrderDomainService;
import com.amos.mall.order.infrastructure.database.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * 订单应用服务
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/12/1
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDomainService orderDomainService;
    @Resource
    private OrderRepository orderRepository;

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public boolean create(CreateOrderParam co) {
        OrderEntity orderEntity = OrderAssembler.build(co);

        // 校验库存
        orderDomainService.checkStockEnough(orderEntity);

        // 保存订单
        orderRepository.save(orderEntity);

        // 锁定库存
        orderDomainService.lockStock(orderEntity);

        // 修改订单状态
        orderEntity.updateStatus(OrderStatus.PENDING_PAYMENT);
        orderRepository.updateStatus(orderEntity);

        return true;
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void paid(OrderPaidEvent orderPaidEvent) {
        // 根据ID查询订单
        OrderEntity orderEntity = orderRepository.findById(orderPaidEvent.getOrderId());
        if (Objects.isNull(orderEntity)) {
            return;
        }

        // 更新订单状态
        orderEntity.setStatus(OrderStatus.PROCESSING.name());
        orderRepository.updateStatus(orderEntity);

        // 扣减库存
        orderDomainService.reduceStock(orderEntity);
    }

    @Override
    public void autoCancel() {
        // 长时间未支付的订单自动取消
        List<OrderEntity> unpaidOrder = orderRepository.findUnpaidOrder();
        unpaidOrder.forEach(orderEntity -> {
            orderEntity.setStatus(OrderStatus.CANCELED.name());
            orderRepository.updateStatus(orderEntity);
        });
    }
}
