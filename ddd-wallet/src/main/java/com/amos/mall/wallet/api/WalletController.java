package com.amos.mall.wallet.api;

import com.amos.mall.wallet.api.model.WalletTransferParam;
import com.amos.mall.wallet.application.service.WalletService;
import com.amos.mall.wallet.domain.model.WalletStatus;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 虚拟钱包
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/12/1
 */
@RestController
@RequestMapping("wallet")
public class WalletController {

    @Resource
    private WalletService walletService;

    /**
     * 获取钱包余额
     *
     * @param walletId 钱包ID
     * @return 余额
     */
    @GetMapping("getBalance")
    public BigDecimal getBalance(Long walletId) {
        return walletService.getBalance(walletId);
    }

    /**
     * 转账
     *
     * @param param 转账参数
     */
    @PostMapping("transfer")
    public String transfer(WalletTransferParam param) {

        walletService.transfer(param);

        return "success";
    }

    @GetMapping("status")
    public List<ImmutablePair<Integer, String>> status() {
        return Arrays.stream(WalletStatus.values())
                .map(status -> new ImmutablePair<>(status.getCode(), status.getMessage()))
                .collect(Collectors.toList());
    }

}
