package com.cy.store.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cy.store.entity.Order;
import com.cy.store.vo.OrderResponse;
import com.cy.store.vo.OrderVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/** 处理订单和订单数据的业务层接口 */
public interface IOrderService {
    /**
     * 创建订单
     * @return 成功创建的订单数据
     */
    Order create(OrderVO orderVO);

    /**
     * 分页查询订单
     */
    Page<Order> pageOrderList(Page<Order> page , Order order);

    /**
     * 分页查询订单及其商品列表
     */
    Page<OrderResponse> pageOrderListItem(Page<OrderResponse> page, OrderResponse response);

    /**
     * 更新订单状态
     */
    void updateOrderStatus(Integer status,Integer oid);

    /**
     * 查询指定订单及其商品列表
     */
    OrderResponse getOrderListItem(OrderResponse orderResponse);
}
