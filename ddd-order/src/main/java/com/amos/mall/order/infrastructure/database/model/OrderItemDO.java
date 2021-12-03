package com.amos.mall.order.infrastructure.database.model;

import lombok.Getter;
import lombok.Setter;

/**
 * 订单条目DO
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/12/2
 */
@Getter
@Setter
public class OrderItemDO {

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 订单编号
     */
    private Long orderId;

    /**
     * 商品SKU ID
     */
    private Long goodsSkuId;

    /**
     * 购买数量
     */
    private Integer purchaseCount;

}
