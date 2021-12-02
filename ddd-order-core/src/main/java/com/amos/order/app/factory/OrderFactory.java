package com.amos.order.app.factory;

import com.amos.order.api.model.CreateOrderParam;
import com.amos.order.domain.model.OrderEntity;
import com.amos.order.domain.model.OrderItem;

import java.util.ArrayList;
import java.util.List;

/**
 * 订单工厂
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/12/2
 */
public class OrderFactory {

    public static OrderEntity build(CreateOrderParam orderParam) {
        List<OrderItem> orderItemList = new ArrayList<>();
        for (CreateOrderParam.OrderItemParam orderItemParam : orderParam.getOrderItemParamList()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setGoodsSkuId(orderItemParam.getGoodsSkuId());
            orderItem.setPurchaseCount(orderItemParam.getPurchaseCount());
            orderItemList.add(orderItem);
        }

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderItems(orderItemList);
        return orderEntity;
    }

}
