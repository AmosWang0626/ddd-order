package com.amos.mall.wallet.infrastructure.database.mapper;

import com.amos.mall.wallet.infrastructure.database.model.WalletDO;

/**
 * Wallet Mapper
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/12/11
 */
public interface WalletMapper {
    /**
     * insert 钱包
     *
     * @param walletDO 钱包
     * @return 数据库变更行数
     */
    int insert(WalletDO walletDO);

    /**
     * update 钱包
     *
     * @param walletDO 钱包
     * @return 数据库变更行数
     */
    int updateById(WalletDO walletDO);

    /**
     * 查询钱包信息
     *
     * @param id walletId
     * @return WalletDO
     */
    WalletDO selectById(Long id);
}
