package com.amos.mall.wallet.infrastructure.database.model;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 交易记录DO
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/12/11
 */
@Getter
@Setter
public class WalletTransferDO {

    /**
     * ID
     */
    private Long id;

    /**
     * 交易金额
     */
    private BigDecimal amount;

    /**
     * 交易类型
     */
    private Integer transferType;

    /**
     * 出账钱包
     */
    private Long fromWallet;

    /**
     * 入账钱包
     */
    private Long toWallet;

    /**
     * 创建时间
     */
    private LocalDateTime gmtCreate;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
