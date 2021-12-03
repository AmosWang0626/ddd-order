package com.amos.mall.order;

import com.amos.mall.order.application.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * 订单应用服务测试
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/11/27
 */
@SpringBootTest
public class OrderServiceTests {

    @Resource
    private OrderService orderService;

    @Test
    public void checkOrder() {
    }

}
