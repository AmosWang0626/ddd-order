package com.amos.mall.order.application.scheduler;

import com.amos.mall.order.application.service.OrderService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 自动扫描过期订单任务
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/12/4
 */
@Component
public class OrderAutoCancelScheduler {

    @Resource
    private OrderService orderService;

    @Scheduled(cron = "0 0/1 * * * ?")
    public void execute() {
        try {
            orderService.autoCancel();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
