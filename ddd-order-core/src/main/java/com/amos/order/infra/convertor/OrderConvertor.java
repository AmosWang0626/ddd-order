package com.amos.order.infra.convertor;

import com.amos.order.domain.model.OrderEntity;
import com.amos.order.domain.model.OrderItem;
import com.amos.order.infra.model.OrderDO;
import com.amos.order.infra.model.OrderItemDO;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 订单对象转换
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/12/2
 */
public class OrderConvertor {

    public static OrderDO toDO(OrderEntity orderEntity) {
        OrderDO orderDO = new OrderDO();
        orderDO.setStatus(orderEntity.getStatus());
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

}
