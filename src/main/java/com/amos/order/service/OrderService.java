package com.amos.order.service;

import com.amos.order.model.Order;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Order Service
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/11/21
 */
@Validated
public interface OrderService {

    int create(String name);

    int checkOrder(@Valid @NotNull Order order);
}
