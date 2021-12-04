package com.amos.mall.order.infrastructure.mq;

import lombok.extern.slf4j.Slf4j;

/**
 * 消费消息
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/12/4
 */
@Slf4j
public class RocketMQConsumer {

    private String topic;

    private MessageProcessor processor;

    public void subscribe(String topic) {
        this.topic = topic;
    }

    public void consume(MessageProcessor processor) {
        this.processor = processor;
    }

    public void process(String message) {
        log.info("消息来啦～ topic={}, message=[{}]", topic, message);
        processor.process(message);
    }

}
