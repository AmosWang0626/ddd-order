package com.amos.mall.inventory.api;

/**
 * 库存系统对外API
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/12/1
 */
public interface InventoryApi {

    /**
     * 校验商品库存是否充足
     *
     * @param goodsSkuId 商品ID
     * @param count      购买数量
     * @return true-充足 false-库存不足
     */
    boolean stockEnough(Long goodsSkuId, Integer count);

    /**
     * 锁定商品库存
     *
     * @param goodsSkuId 商品ID
     * @param count      购买数量
     * @return true-锁定成功 false-锁定失败
     */
    boolean lockStock(Long goodsSkuId, Integer count);

    /**
     * 释放锁定的商品库存(Need Retry)
     *
     * @param goodsSkuId 商品ID
     * @param count      购买数量
     * @return true-释放成功 false-释放失败
     */
    boolean unlockStock(Long goodsSkuId, Integer count);

    /**
     * 扣减商品库存
     *
     * @param goodsSkuId 商品ID
     * @param count      购买数量
     * @return true-扣减成功 false-扣减失败
     */
    boolean deductStock(Long goodsSkuId, Integer count);

    /**
     * 增加商品库存
     *
     * @param goodsSkuId 商品ID
     * @param count      购买数量
     * @return true-增加成功 false-增加失败
     */
    boolean addStock(Long goodsSkuId, Integer count);

}
