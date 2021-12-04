package com.amos.mall.order.domain.event;

import com.amos.mall.order.application.service.OrderService;
import com.amos.mall.order.domain.model.OrderId;
import com.amos.mall.order.infrastructure.mq.RocketMQConsumer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 订单支付事件监听
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/12/3
 */
@Component
public class OrderPaidEventListener {

    @Resource
    private OrderService orderService;

    public void start() {
        // 监听指定 topic，消费消息
        RocketMQConsumer consumer = new RocketMQConsumer();
        consumer.subscribe("order_paid_event_topic");
        consumer.consume(message -> {
            try {
                OrderPaidEvent paidEvent = new OrderPaidEvent();
                paidEvent.setOrderId(new OrderId().setId(Long.valueOf(message)));
                orderService.paid(paidEvent);
            } catch (Exception e) {
                e.printStackTrace();
                // 重试多次，多次还失败的话，人工介入处理和处理死信队列
            }
        });
    }

}
