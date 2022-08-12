package com.cy.store.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cy.store.entity.Address;
import com.cy.store.entity.Order;
import com.cy.store.entity.OrderItem;
import com.cy.store.mapper.OrderMapper;
import com.cy.store.service.IAddressService;
import com.cy.store.service.ICartService;
import com.cy.store.service.IOrderService;
import com.cy.store.service.ex.InsertException;
import com.cy.store.vo.CartVO;
import com.cy.store.vo.OrderResponse;
import com.cy.store.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


/** 处理订单和订单数据的业务层实现类 */
@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Transactional
    @Override
    public Order create(OrderVO orderVO) {
        // 创建当前时间对象
        Date now = new Date();
        // 创建订单数据对象
        Order order = new Order();
        // 补全数据：uid
        order.setUid(orderVO.getUid());
        order.setRecvName(orderVO.getAddress().getName());
        order.setRecvPhone(orderVO.getAddress().getPhone());
        order.setRecvProvince(orderVO.getAddress().getProvinceName());
        order.setRecvCity(orderVO.getAddress().getCityName());
        order.setRecvArea(orderVO.getAddress().getAreaName());
        order.setRecvAddress(orderVO.getAddress().getAddress());
        // 补全数据：totalPrice
        order.setTotalPrice(orderVO.getTotalPrice());
        // 补全数据：status
        order.setStatus(0);
        // 补全数据：下单时间
        order.setOrderTime(now);
        // 补全数据：日志
        order.setCreatedUser(orderVO.getUsername());
        order.setCreatedTime(now);
        order.setModifiedUser(orderVO.getUsername());
        order.setModifiedTime(now);
        // 插入订单数据
        Integer rows1 = orderMapper.insertOrder(order);
        if (rows1 != 1) {
            throw new InsertException("插入订单数据时出现未知错误，请联系系统管理员");
        }

        // 遍历carts，循环插入订单商品数据
        for (CartVO cart : orderVO.getCartList()) {
            // 创建订单商品数据
            OrderItem item = new OrderItem();
            // 补全数据：setOid(order.getOid())
            item.setOid(order.getOid());
            // 补全数据：pid, title, image, price, num
            item.setPid(cart.getPid());
            item.setTitle(cart.getTitle());
            item.setImage(cart.getImage());
            item.setPrice(cart.getPrice());
            item.setNum(cart.getNum());
            // 补全数据：4项日志
            item.setCreatedUser(orderVO.getUsername());
            item.setCreatedTime(now);
            item.setModifiedUser(orderVO.getUsername());
            item.setModifiedTime(now);
            // 插入订单商品数据
            Integer rows2 = orderMapper.insertOrderItem(item);
            if (rows2 != 1) {
                throw new InsertException("插入订单商品数据时出现未知错误，请联系系统管理员");
            }
        }

        // 返回
        return order;
    }

    @Override
    public Page<Order> pageOrderList(Page<Order> page, Order order) {
        if (order.getUid() == null)
        {
            throw new RuntimeException("用户ID不能为空");
        }
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("uid",order.getUid());
        Page<Order> pageList = orderMapper.selectPage(page,wrapper);
        return pageList;
    }

    @Override
    public Page<OrderResponse> pageOrderListItem(Page<OrderResponse> page, OrderResponse response) {
        if (response.getUid() == null)
        {
            throw new RuntimeException("用户ID不能为空");
        }
        Page<OrderResponse> page1 = orderMapper.pageOrderListItem(page,response);
        return page1;
    }

    @Override
    public void updateOrderStatus(Integer status, Integer oid) {
        if (oid == null)
        {
            throw new RuntimeException("订单ID不能为空");
        }
        if (status == null)
        {
            throw new RuntimeException("状态不能为空");
        }
        orderMapper.updateOrderStatus(status,oid);
    }

    @Override
    public OrderResponse getOrderListItem(OrderResponse orderResponse) {
        if (orderResponse.getOid() == null)
        {
            throw new RuntimeException("订单ID不能为空");
        }
        if (orderResponse.getUid() == null)
        {
            throw new RuntimeException("用户ID不能为空");
        }
        return orderMapper.getOrderListItem(orderResponse);
    }
}
