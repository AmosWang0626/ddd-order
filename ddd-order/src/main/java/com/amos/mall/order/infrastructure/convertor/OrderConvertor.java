package com.amos.mall.order.infrastructure.convertor;

import com.amos.mall.order.domain.model.OrderEntity;
import com.amos.mall.order.domain.model.OrderId;
import com.amos.mall.order.domain.model.OrderItem;
import com.amos.mall.order.infrastructure.database.model.OrderDO;
import com.amos.mall.order.infrastructure.database.model.OrderItemDO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 订单对象转换
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/12/2
 */
public class OrderConvertor {

    public static OrderDO toDO(OrderEntity entity) {
        OrderDO orderDO = new OrderDO();
        if (Objects.isNull(entity.getOrderId())) {
            orderDO.setGmtCreate(LocalDateTime.now());
        }
        orderDO.setStatus(entity.getStatus());
        orderDO.setGmtModify(LocalDateTime.now());
        return orderDO;
    }

    public static List<OrderItemDO> toItemDO(Long orderId, List<OrderItem> orderItemList) {
        return orderItemList.stream()
                .map(item -> toDO(orderId, item))
                .collect(Collectors.toList());
    }

    public static OrderItemDO toDO(Long orderId, OrderItem orderItem) {
        OrderItemDO orderItemDO = new OrderItemDO();
        orderItemDO.setOrderId(orderId);
        orderItemDO.setGoodsSkuId(orderItem.getGoodsSkuId());
        orderItemDO.setPurchaseCount(orderItem.getPurchaseCount());
        return orderItemDO;
    }

    public static OrderEntity toEntity(OrderDO orderDO) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderId(new OrderId().setId(orderDO.getId()));
        orderEntity.setStatus(orderDO.getStatus());
        return orderEntity;
    }

    public static OrderEntity toEntity(OrderDO orderDO, List<OrderItemDO> orderItemList) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderId(new OrderId().setId(orderDO.getId()));
        orderEntity.setStatus(orderDO.getStatus());

        List<OrderItem> orderItems = orderItemList.stream().map(OrderConvertor::toEntity).collect(Collectors.toList());
        orderEntity.setOrderItems(orderItems);

        return orderEntity;
    }

    public static OrderItem toEntity(OrderItemDO orderItemDO) {
        OrderItem orderItem = new OrderItem();
        orderItem.setGoodsSkuId(orderItemDO.getGoodsSkuId());
        orderItem.setPurchaseCount(orderItemDO.getPurchaseCount());
        return orderItem;
    }

}
