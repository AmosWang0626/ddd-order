package com.amos.mall.order.application.service;

import com.amos.mall.order.api.model.CreateOrderParam;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * 订单应用服务
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/12/1
 */
@Validated
public interface OrderService {

    /**
     * 创建订单业务流程
     *
     * @param co 创建订单参数 Client Object
     * @return true-创建成功
     */
    boolean create(@Valid @NotNull CreateOrderParam co);

}
