package com.amos.mall.order.api.model;

/**
 * 订单状态
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/12/2
 */
public enum OrderStatus {

    /**
     * 待支付
     */
    PENDING_PAYMENT("待支付"),

    /**
     * 待发货
     */
    PROCESSING("待发货"),

    /**
     * 待收货
     */
    SHIPPED("待收货"),

    /**
     * 待评价
     */
    ARRIVED("待评价"),

    /**
     * 退款中
     */
    REFUNDED_PROCESSING("退款中"),

    /**
     * 已关闭
     */
    CLOSED("已关闭"),

    /**
     * 已取消
     */
    CANCELED("已取消");

    private final String desc;

    OrderStatus(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
