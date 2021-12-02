package com.amos.order.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 创建订单参数
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/12/2
 */
@Getter
@Setter
public class CreateOrderParam {

    @NotEmpty(message = "订单条目不能为空")
    private List<OrderItemParam> orderItemParamList;


    /**
     * 订单条目
     */
    @Getter
    @Setter
    public static class OrderItemParam {

        /**
         * 商品SKU ID
         */
        @NotNull(message = "商品SKU编号不能为空")
        private Long goodsSkuId;
        /**
         * 购买数量
         */
        @NotNull(message = "购买数量不能为空")
        private Integer purchaseCount;

    }
}
