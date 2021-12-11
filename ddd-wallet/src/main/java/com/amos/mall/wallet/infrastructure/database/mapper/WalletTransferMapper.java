package com.amos.mall.wallet.infrastructure.database.mapper;

import com.amos.mall.wallet.infrastructure.database.model.WalletTransferDO;

/**
 * Wallet Transfer Mapper
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/12/11
 */
public interface WalletTransferMapper {

    /**
     * 保存转账流水
     *
     * @param walletTransferDO 转账流水信息
     * @return 数据库变更行数
     */
    int insert(WalletTransferDO walletTransferDO);

}
