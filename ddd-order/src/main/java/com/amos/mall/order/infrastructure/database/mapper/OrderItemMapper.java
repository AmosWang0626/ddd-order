package com.amos.mall.order.infrastructure.database.mapper;

import com.amos.mall.order.infrastructure.database.model.OrderItemDO;

import java.util.List;

/**
 * 订单条目存储入库 Mapper
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/12/2
 */
public interface OrderItemMapper {

    /**
     * insert 订单条目
     *
     * @param orderItemDO 订单条目
     * @return 数据库变更行数
     */
    int insert(OrderItemDO orderItemDO);

    /**
     * 根据订单ID查询订单条目
     *
     * @param orderId 订单ID
     * @return 订单条目
     */
    List<OrderItemDO> findByOrderId(Long orderId);
}
