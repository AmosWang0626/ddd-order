package com.amos.order.infra.model;

import lombok.Getter;
import lombok.Setter;

/**
 * 订单DO
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/12/2
 */
@Getter
@Setter
public class OrderDO {

    /**
     * 订单ID
     */
    private Long id;

    /**
     * 订单状态
     */
    private String status;

}
