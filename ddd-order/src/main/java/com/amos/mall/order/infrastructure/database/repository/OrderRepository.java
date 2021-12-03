package com.amos.mall.order.infrastructure.database.repository;

import com.amos.mall.order.domain.model.OrderEntity;
import com.amos.mall.order.infrastructure.convertor.OrderConvertor;
import com.amos.mall.order.infrastructure.exception.DatabaseException;
import com.amos.mall.order.infrastructure.database.mapper.OrderItemMapper;
import com.amos.mall.order.infrastructure.database.mapper.OrderMapper;
import com.amos.mall.order.infrastructure.database.model.OrderDO;
import com.amos.mall.order.infrastructure.database.model.OrderItemDO;
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
        int modifyLines = orderMapper.insert(orderDO);
        checkModifyLine(modifyLines, "保存订单失败!");

        List<OrderItemDO> orderItemDOList = OrderConvertor.toItemDO(orderDO.getId(), orderEntity.getOrderItems());
        orderItemDOList.forEach(item -> {
            int lines = orderItemMapper.insert(item);
            checkModifyLine(lines, "保存订单条目失败!");
        });
    }

    public void updateStatus(OrderEntity orderEntity) {
        OrderDO orderDO = OrderConvertor.toDO(orderEntity);

        int modifyLines = orderMapper.updateStatus(orderDO);
        checkModifyLine(modifyLines, "修改订单状态失败!");
    }

    public void checkModifyLine(int lines, String message) {
        if (lines < 1) {
            throw new DatabaseException(message);
        }
    }

}
