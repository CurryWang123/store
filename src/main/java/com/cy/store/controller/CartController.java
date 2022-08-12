package com.cy.store.controller;

import com.cy.store.service.ICartService;
import com.cy.store.util.JsonResult;
import com.cy.store.vo.CartVO;
import com.cy.store.vo.Cartdto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("carts")
public class CartController extends BaseController {
    @Autowired
    private ICartService cartService;

    /**加入购物车*/
    @PostMapping("add_to_cart")
    public JsonResult<Void> addToCart(@RequestBody Cartdto cartdto) {
        Integer uid = cartdto.getUid();
        String username = cartdto.getUsername();
        Integer pid = cartdto.getPid();
        Integer amount = cartdto.getAmount();
        // 调用业务对象执行添加到购物车
        cartService.addToCart(uid, pid, amount, username);
        // 返回成功
        return new JsonResult<Void>(OK);
    }

    @GetMapping("getVOByUid")
    public JsonResult<List<CartVO>> getVOByUid(Integer uid) {
        // 调用业务对象执行查询数据
        List<CartVO> data = cartService.getVOByUid(uid);
        // 返回成功与数据
        return new JsonResult<List<CartVO>>(OK, data);
    }

    @RequestMapping("{cid}/num/add")
    public JsonResult<Integer> addNum(@PathVariable("cid") Integer cid, HttpSession session) {
        // 从Session中获取uid和username
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        // 调用业务对象执行增加数量
        Integer data = cartService.addNum(cid, uid, username);
        // 返回成功
        return new JsonResult<Integer>(OK, data);
    }

//    根据cids字符串查询购物车列表
    @GetMapping("getVOByCids")
    public JsonResult<List<CartVO>> getVOByCids(@RequestParam("cids") String cids) {
        // 调用业务对象执行查询数据
        List<CartVO> data = cartService.getVOByCids( cids);
        // 返回成功与数据
        return new JsonResult<>(OK, data);
    }

    /**
     * 更新购物车数量
     */
    @PostMapping("updateNumByCid")
    public JsonResult<Void> updateNumByCid(@RequestBody Cartdto cartdto){
        Integer cid = cartdto.getCid();
        Integer num = cartdto.getNum();
        String modifiedUser = cartdto.getModifiedUser();
        cartService.updateNumByCid(cid,num,modifiedUser);
        return new JsonResult<>(OK);
    }

    /**
     * 删除购物车
     */
    @PostMapping("deleteCart")
    public JsonResult<Void> deleteCart(@RequestBody Cartdto cartdto)
    {
        String[] cidList = cartdto.getCids().split(",");
        int[] array = Arrays.stream(cidList).mapToInt(Integer::parseInt).toArray();
        cartService.deleteCart(array);
        return new JsonResult<>(OK);
    }
}
