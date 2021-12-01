package com.amos.order.service.impl;

import com.amos.order.model.Order;
import com.amos.order.service.OrderService;
import org.springframework.stereotype.Service;

/**
 * Order Service Impl
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/11/21
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public int create(String name) {

        throw new RuntimeException("Order Create Error");
    }

    @Override
    public int checkOrder(Order order) {
        return 0;
    }
}
