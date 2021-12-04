package com.amos.mall.order.infrastructure.mq;

/**
 * 消息处理器
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/12/4
 */
public interface MessageProcessor {

    /**
     * 消息处理
     *
     * @param message 消息内容
     */
    void process(String message);

}
