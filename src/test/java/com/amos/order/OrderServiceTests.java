package com.amos.order;

import com.amos.order.model.Order;
import com.amos.order.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * 订单Service测试
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
        System.out.println(orderService.checkOrder(new Order()));
        System.out.println(orderService.checkOrder(null));
    }

}
