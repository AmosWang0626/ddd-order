package com.amos.mall.wallet.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * 钱包交易参数
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/12/11
 */
@Getter
@Setter
public class WalletTransferParam {

    /**
     * 出账钱包ID
     */
    @NotNull(message = "出账钱包ID不能为空")
    private Long fromWalletId;

    /**
     * 入账钱包ID
     */
    @NotNull(message = "入账钱包ID不能为空")
    private Long toWalletId;

    /**
     * 交易金额
     */
    @NotNull(message = "交易金额不能为空")
    @DecimalMin(value = "0", message = "交易金额不能小于0元")
    private BigDecimal amount;

}
