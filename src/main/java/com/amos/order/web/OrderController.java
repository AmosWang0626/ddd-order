package com.amos.order.web;

import com.amos.order.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Order Controller
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/11/21
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping
    public String create(String name) {
        return orderService.create(name) > 0 ? "成功" : "失败";
    }

}
