package com.amos.mall.wallet.application.service.impl;

import com.amos.mall.wallet.api.model.WalletTransferParam;
import com.amos.mall.wallet.application.service.WalletService;
import com.amos.mall.wallet.domain.model.TransferType;
import com.amos.mall.wallet.domain.model.WalletEntity;
import com.amos.mall.wallet.domain.model.WalletTransferEntity;
import com.amos.mall.wallet.infrastructure.database.repository.WalletRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 订单应用服务
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/12/1
 */
@Service
public class WalletServiceImpl implements WalletService {

    @Resource
    private WalletRepository walletRepository;

    @Override
    public BigDecimal getBalance(Long walletId) {
        WalletEntity walletEntity = walletRepository.queryWallet(walletId);

        return walletEntity.getAvailableBalance();
    }

    @Override
    public void transfer(WalletTransferParam param) {
        BigDecimal amount = param.getAmount();

        // 出账
        debit(param.getFromWalletId(), amount);
        // 入账
        credit(param.getToWalletId(), amount);

        // 转账记录
        WalletTransferEntity walletTransferEntity = new WalletTransferEntity();
        walletTransferEntity.setAmount(amount);
        walletTransferEntity.setTransferType(TransferType.TRANSFER);
        walletTransferEntity.setFromWallet(param.getFromWalletId());
        walletTransferEntity.setToWallet(param.getToWalletId());
        walletTransferEntity.setGmtCreate(LocalDateTime.now());
        walletRepository.saveWalletTransfer(walletTransferEntity);
    }

    private void debit(Long walletId, BigDecimal amount) {
        WalletEntity walletEntity = walletRepository.queryWallet(walletId);
        walletEntity.debit(amount);
        walletEntity.setGmtModify(LocalDateTime.now());
        walletRepository.saveWallet(walletEntity);

        WalletTransferEntity walletTransferEntity = new WalletTransferEntity();
        walletTransferEntity.setAmount(amount);
        walletTransferEntity.setTransferType(TransferType.DEBIT);
        walletTransferEntity.setFromWallet(walletId);
        walletTransferEntity.setGmtCreate(LocalDateTime.now());
        walletRepository.saveWalletTransfer(walletTransferEntity);
    }

    private void credit(Long walletId, BigDecimal amount) {
        WalletEntity walletEntity = walletRepository.queryWallet(walletId);
        walletEntity.credit(amount);
        walletEntity.setGmtModify(LocalDateTime.now());
        walletRepository.saveWallet(walletEntity);

        WalletTransferEntity walletTransferEntity = new WalletTransferEntity();
        walletTransferEntity.setAmount(amount);
        walletTransferEntity.setTransferType(TransferType.CREDIT);
        walletTransferEntity.setFromWallet(walletId);
        walletTransferEntity.setGmtCreate(LocalDateTime.now());
        walletRepository.saveWalletTransfer(walletTransferEntity);
    }
}
