package com.amos.mall.wallet.infrastructure.database.model;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 钱包
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/12/11
 */
@Getter
@Setter
public class WalletDO {

    /**
     * 钱包ID
     */
    private Long walletId;

    /**
     * 钱包余额
     */
    private BigDecimal balance;

    /**
     * 是否可透支使用
     */
    private Boolean allowOverDraft;

    /**
     * 可透支金额
     */
    private BigDecimal overdraftAmount;

    /**
     * 冻结金额
     */
    private BigDecimal frozenAmount;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 钱包创建时间
     */
    private LocalDateTime gmtCreate;

    /**
     * 钱包修改时间
     */
    private LocalDateTime gmtModify;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
