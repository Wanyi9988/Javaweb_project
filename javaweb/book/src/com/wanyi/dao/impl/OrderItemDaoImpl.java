package com.wanyi.dao.impl;

import com.wanyi.dao.OrderItemDao;
import com.wanyi.pojo.OrderItem;

public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item(`id`,`name`,`count`,`price`,`total_price`,`order_id`) values(?,?,?,?,?,?)";
        return update(sql, orderItem.getId(), orderItem.getName(), orderItem.getCount(), orderItem.getPrice(), orderItem.getTotalPrice(), orderItem.getOrderId());
    }
}
