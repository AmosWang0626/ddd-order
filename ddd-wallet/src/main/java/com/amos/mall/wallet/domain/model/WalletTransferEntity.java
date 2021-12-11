package com.amos.mall.wallet.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 转账记录
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/12/11
 */
@Getter
@Setter
public class WalletTransferEntity {

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
    private TransferType transferType;

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

}
