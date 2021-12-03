package com.amos.mall.order.domain.model;

import lombok.Getter;
import lombok.Setter;

/**
 * 订单条目
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/12/1
 */
@Getter
@Setter
public class OrderItem {

    /**
     * 商品SKU ID
     */
    private Long goodsSkuId;
    /**
     * 购买数量
     */
    private Integer purchaseCount;

}
