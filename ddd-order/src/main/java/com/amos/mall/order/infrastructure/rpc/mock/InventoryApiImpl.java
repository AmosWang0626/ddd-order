package com.amos.mall.order.infrastructure.rpc.mock;

import com.amos.mall.inventory.api.InventoryApi;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Mock 库存服务
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/12/3
 */
@Component
public class InventoryApiImpl implements InventoryApi {

    private static final Random RANDOM = new Random();

    @Override
    public boolean stockEnough(Long goodsSkuId, Integer count) {
        return RANDOM.nextBoolean();
    }

    @Override
    public boolean lockStock(Long goodsSkuId, Integer count) {
        return RANDOM.nextBoolean();
    }

    @Override
    public boolean unlockStock(Long goodsSkuId, Integer count) {
        // need retry
        return true;
    }

    @Override
    public boolean deductStock(Long goodsSkuId, Integer count) {
        return RANDOM.nextBoolean();
    }

    @Override
    public boolean addStock(Long goodsSkuId, Integer count) {
        // need retry
        return true;
    }
}
