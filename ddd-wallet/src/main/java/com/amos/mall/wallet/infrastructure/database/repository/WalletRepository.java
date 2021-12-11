package com.amos.mall.wallet.infrastructure.database.repository;

import com.amos.mall.wallet.domain.model.WalletEntity;
import com.amos.mall.wallet.domain.model.WalletTransferEntity;
import com.amos.mall.wallet.infrastructure.convertor.WalletConvertor;
import com.amos.mall.wallet.infrastructure.database.mapper.WalletMapper;
import com.amos.mall.wallet.infrastructure.database.mapper.WalletTransferMapper;
import com.amos.mall.wallet.infrastructure.database.model.WalletDO;
import com.amos.mall.wallet.infrastructure.database.model.WalletTransferDO;
import com.amos.mall.wallet.infrastructure.exception.BizException;
import com.amos.mall.wallet.infrastructure.exception.DatabaseException;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * 钱包资源库
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/12/11
 */
@Repository
public class WalletRepository {

    @Resource
    private WalletMapper walletMapper;
    @Resource
    private WalletTransferMapper walletTransferMapper;

    public WalletEntity queryWallet(Long walletId) {
        WalletDO walletDO = walletMapper.selectById(walletId);
        if (Objects.isNull(walletDO)) {
            throw new BizException("钱包不存在!");
        }
        return WalletConvertor.toEntity(walletDO);
    }

    public void saveWallet(WalletEntity walletEntity) {
        WalletDO walletDO = WalletConvertor.toDo(walletEntity);
        if (Objects.isNull(walletDO.getWalletId())) {
            int lines = walletMapper.insert(walletDO);
            checkModifyLine(lines, "保存钱包失败");
            return;
        }

        int lines = walletMapper.updateById(walletDO);
        checkModifyLine(lines, "更新钱包失败");
    }

    public void saveWalletTransfer(WalletTransferEntity walletTransferEntity) {
        WalletTransferDO walletTransferDO = WalletConvertor.toDo(walletTransferEntity);
        int lines = walletTransferMapper.insert(walletTransferDO);
        checkModifyLine(lines, "保存钱包流水失败");
    }

    public void checkModifyLine(int lines, String message) {
        if (lines < 1) {
            throw new DatabaseException(message);
        }
    }

}
