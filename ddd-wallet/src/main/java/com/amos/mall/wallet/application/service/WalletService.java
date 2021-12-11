package com.amos.mall.wallet.application.service;

import com.amos.mall.wallet.api.model.WalletTransferParam;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * 订单应用服务
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/12/1
 */
@Validated
public interface WalletService {

    /**
     * 获取钱包余额
     *
     * @param walletId 钱包ID
     * @return 余额
     */
    BigDecimal getBalance(@Valid @NotNull Long walletId);

    /**
     * 转账
     *
     * @param param 转账参数
     */
    void transfer(WalletTransferParam param);

}
