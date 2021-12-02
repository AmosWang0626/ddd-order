package com.amos.order.api;

import com.amos.order.api.model.CreateOrderParam;
import com.amos.order.app.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户界面（对外提供的API接口）
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/12/1
 */
@RestController
@RequestMapping("com/amos/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    @PostMapping("create")
    public String create(CreateOrderParam co) {

        orderService.create(co);

        return "success";
    }

}
