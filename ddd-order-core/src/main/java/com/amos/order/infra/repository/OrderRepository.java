package com.amos.order.infra.repository;

import com.amos.order.domain.model.OrderEntity;
import com.amos.order.infra.convertor.OrderConvertor;
import com.amos.order.infra.mapper.OrderItemMapper;
import com.amos.order.infra.mapper.OrderMapper;
import com.amos.order.infra.model.OrderDO;
import com.amos.order.infra.model.OrderItemDO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * 订单资源库
 *
 * @author <a href="mailto:daoyuan0626@gmail.com">amos.wang</a>
 * @date 2021/12/2
 */
@Repository
public class OrderRepository {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private OrderItemMapper orderItemMapper;

    public void save(OrderEntity orderEntity) {
        OrderDO orderDO = OrderConvertor.toDO(orderEntity);
        orderMapper.insert(orderDO);

        List<OrderItemDO> orderItemDOList = OrderConvertor.toItemDO(orderDO.getId(), orderEntity.getOrderItems());
        orderItemDOList.forEach(orderItemMapper::insert);
    }

}
