package com.amos.mall.order.domain.event;

import com.amos.mall.order.domain.model.OrderId;
import lombok.Getter;
import lombok.Setter;

/**
 * 订单支付事件
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/12/3
 */
@Getter
@Setter
public class OrderPaidEvent {

    private OrderId orderId;

}
