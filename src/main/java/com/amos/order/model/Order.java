package com.amos.order.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 订单实体
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/11/27
 */
@Getter
@Setter
public class Order {

    private Long id;

    @NotBlank
    private String productSku;
    @NotBlank
    private String productName;
    @NotBlank
    private String price;

    private List<String> orderItems;

}
