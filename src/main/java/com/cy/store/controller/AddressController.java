package com.cy.store.controller;

import com.cy.store.entity.Address;
import com.cy.store.service.IAddressService;
import com.cy.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("addresses")
public class AddressController extends BaseController {
    @Autowired
    private IAddressService addressService;

    @PostMapping("add_new_address")
    public JsonResult<Void> addNewAddress(@RequestBody Address address) {
        // 调用业务对象的方法执行业务
        addressService.addNewAddress(address);
        // 响应成功
        return new JsonResult<Void>(OK);
    }

    @GetMapping("getByUid")
    public JsonResult<List<Address>> getByUid(@RequestParam("uid") Integer uid) {
        List<Address> data = addressService.getByUid(uid);
        return new JsonResult<List<Address>>(OK, data);
    }

    /**设置默认地址*/
    @RequestMapping("set_default")
    public JsonResult<Void> setDefault(@RequestParam("aid") Integer aid, @RequestParam("uid") Integer uid,@RequestParam("username") String username) {
        addressService.setDefault(aid, uid, username);
        return new JsonResult<Void>(OK);
    }

    @RequestMapping("delete")
    public JsonResult<Void> delete(@RequestParam("aid") Integer aid, @RequestParam("uid") Integer uid,@RequestParam("username") String username) {
        addressService.delete(aid, uid, username);
        return new JsonResult<Void>(OK);
    }

    /**
     * 更新地址信息
     */
    @PostMapping("updateAddress")
    public JsonResult<Void> updateAddress(@RequestBody Address address)
    {
        addressService.updateAddress(address);
        return new JsonResult<Void>(OK);
    }

    /**
     * 根据aid获取详情
     */
    @GetMapping("findByAid")
    public JsonResult<Address> findByAid(@RequestParam("aid") Integer aid)
    {
        Address address = addressService.findByAid(aid);
        return new JsonResult<>(OK,address);
    }

}

