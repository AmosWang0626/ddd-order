package com.amos.mall.order.infrastructure.database.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

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

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 修改时间
     */
    private LocalDateTime gmtModify;

}
