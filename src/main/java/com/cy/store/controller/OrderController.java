package com.cy.store.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cy.store.entity.Order;
import com.cy.store.entity.common.PageRequest;
import com.cy.store.service.IOrderService;
import com.cy.store.util.JsonResult;
import com.cy.store.vo.OrderResponse;
import com.cy.store.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("orders")
public class OrderController extends BaseController {
    @Autowired
    private IOrderService orderService;
    /**创建订单*/
    @PostMapping("create")
    public JsonResult<Order> create(@RequestBody OrderVO orderVO) {
        // 调用业务对象执行业务
        Order data = orderService.create(orderVO);
        // 返回成功与数据
        return new JsonResult<>(OK, data);
    }

    /**
     * 分页查询订单
     */
    @PostMapping("pageOrderList")
    public JsonResult<Page<Order>> pageOrderList(@RequestBody PageRequest<Order> request)
    {
        Page<Order> page = request.getPage();
        Order order = request.getParams();
        Page<Order> pageList = orderService.pageOrderList(page,order);
        return new JsonResult<>(OK, pageList);
    }

    /**
     * 分页查询订单及其商品列表
     */
    @PostMapping("pageOrderListItem")
    public JsonResult<Page<OrderResponse>> pageOrderListItem(@RequestBody PageRequest<OrderResponse> request)
    {
        Page<OrderResponse> page = request.getPage();
        OrderResponse orderResponse = request.getParams();
        Page<OrderResponse> responsePage = orderService.pageOrderListItem(page,orderResponse);
        return new JsonResult<>(OK, responsePage);
    }

    /**
     * 查询指定订单及其商品列表
     */
    @PostMapping("getOrderListItem")
    public JsonResult<OrderResponse> getOrderListItem(@RequestBody OrderResponse orderResponse)
    {
        OrderResponse response = orderService.getOrderListItem(orderResponse);
        return new JsonResult<>(OK,response);
    }

    /**
     * 更新订单状态
     */
    @PostMapping("updateOrderStatus")
    public JsonResult<Void> updateOrderStatus(@RequestBody Order order)
    {
        Integer oid = order.getOid();
        Integer status = order.getStatus();
        orderService.updateOrderStatus(status,oid);
        return new JsonResult<>(OK);
    }
}
