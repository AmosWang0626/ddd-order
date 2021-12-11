package com.amos.mall.wallet.infrastructure.convertor;

import com.amos.mall.wallet.domain.model.TransferType;
import com.amos.mall.wallet.domain.model.WalletEntity;
import com.amos.mall.wallet.domain.model.WalletStatus;
import com.amos.mall.wallet.domain.model.WalletTransferEntity;
import com.amos.mall.wallet.infrastructure.database.model.WalletDO;
import com.amos.mall.wallet.infrastructure.database.model.WalletTransferDO;

/**
 * 钱包对象转换
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/12/2
 */
public class WalletConvertor {

    public static WalletDO toDo(WalletEntity entity) {
        WalletDO walletDO = new WalletDO();
        walletDO.setWalletId(entity.getWalletId());
        walletDO.setBalance(entity.getBalance());
        walletDO.setAllowOverDraft(entity.isAllowOverDraft());
        walletDO.setFrozenAmount(entity.getFrozenAmount());
        walletDO.setOverdraftAmount(entity.getOverdraftAmount());
        walletDO.setStatus(entity.getStatus().getCode());
        walletDO.setGmtCreate(entity.getGmtCreate());
        walletDO.setGmtModify(entity.getGmtModify());
        return walletDO;
    }

    public static WalletEntity toEntity(WalletDO walletDO) {
        WalletEntity walletEntity = new WalletEntity();
        walletEntity.setWalletId(walletDO.getWalletId());
        walletEntity.setBalance(walletDO.getBalance());
        walletEntity.setAllowOverDraft(walletDO.getAllowOverDraft());
        walletEntity.setFrozenAmount(walletDO.getFrozenAmount());
        walletEntity.setOverdraftAmount(walletDO.getOverdraftAmount());
        walletEntity.setStatus(WalletStatus.codeOf(walletDO.getStatus()));
        walletEntity.setGmtCreate(walletDO.getGmtCreate());
        walletEntity.setGmtModify(walletDO.getGmtModify());
        return walletEntity;
    }

    public static WalletTransferDO toDo(WalletTransferEntity entity) {
        WalletTransferDO walletTransferDO = new WalletTransferDO();
        walletTransferDO.setId(entity.getId());
        walletTransferDO.setAmount(entity.getAmount());
        walletTransferDO.setTransferType(entity.getTransferType().getCode());
        walletTransferDO.setFromWallet(entity.getFromWallet());
        walletTransferDO.setToWallet(entity.getToWallet());
        walletTransferDO.setGmtCreate(entity.getGmtCreate());
        return walletTransferDO;
    }

    public static WalletTransferEntity toEntity(WalletTransferDO entity) {
        WalletTransferEntity walletTransferEntity = new WalletTransferEntity();
        walletTransferEntity.setId(entity.getId());
        walletTransferEntity.setAmount(entity.getAmount());
        walletTransferEntity.setTransferType(TransferType.codeOf(entity.getTransferType()));
        walletTransferEntity.setFromWallet(entity.getFromWallet());
        walletTransferEntity.setToWallet(entity.getToWallet());
        walletTransferEntity.setGmtCreate(entity.getGmtCreate());
        return walletTransferEntity;
    }

}
