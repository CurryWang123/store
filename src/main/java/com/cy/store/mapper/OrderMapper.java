package com.cy.store.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cy.store.entity.Order;
import com.cy.store.entity.OrderItem;
import com.cy.store.vo.OrderResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/** 处理订单及订单商品数据的持久层接口 */
public interface OrderMapper extends BaseMapper<Order> {
    /**
     * 插入订单数据
     * @param order 订单数据
     * @return 受影响的行数
     */
    Integer insertOrder(Order order);

    /**
     * 插入订单商品数据
     * @param orderItem 订单商品数据
     * @return 受影响的行数
     */
    Integer insertOrderItem(OrderItem orderItem);

    /**
     * 分页查询订单及其商品列表
     */
    Page<OrderResponse> pageOrderListItem(Page<OrderResponse> page,@Param("orderResponse") OrderResponse orderResponse);

    /**
     * 更新订单状态
     */
    Integer updateOrderStatus(@Param("status") Integer status,@Param("oid") Integer oid);

    /**
     * 查询指定订单及其商品列表
     */
    OrderResponse getOrderListItem(@Param("orderResponse") OrderResponse orderResponse);
}
