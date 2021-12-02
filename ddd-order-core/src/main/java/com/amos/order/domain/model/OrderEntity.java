package com.amos.order.domain.model;

import com.amos.order.api.model.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 订单实体(聚合根)
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/11/27
 */
@Getter
@Setter
public class OrderEntity {

    /**
     * 订单编号
     */
    private OrderId orderId;

    /**
     * 订单条目
     */
    private List<OrderItem> orderItems;

    /**
     * 订单状态
     *
     * @see com.amos.order.api.model.OrderStatus
     */
    private String status;

    /**
     * 更新订单状态
     *
     * @param orderStatus 订单状态
     * @return true-更新成功
     */
    public boolean updateStatus(OrderStatus orderStatus) {
        this.status = orderStatus.name();
        // TODO update to database
        return true;
    }

}
