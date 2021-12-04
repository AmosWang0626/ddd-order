package com.amos.mall.order.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 订单ID
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/12/1
 */
@Getter
@Setter
@Accessors(chain = true)
public class OrderId {

    private Long id;

}
