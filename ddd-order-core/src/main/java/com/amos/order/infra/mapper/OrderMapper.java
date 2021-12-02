package com.amos.order.infra.mapper;

import com.amos.order.infra.model.OrderDO;

/**
 * 订单存储入库 Mapper
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/12/2
 */
public interface OrderMapper {

    /**
     * insert 订单
     *
     * @param orderDO 订单
     * @return 数据库变更行数
     */
    int insert(OrderDO orderDO);

}
