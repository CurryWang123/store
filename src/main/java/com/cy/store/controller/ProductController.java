package com.cy.store.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cy.store.entity.Product;
import com.cy.store.entity.common.PageRequest;
import com.cy.store.service.IProductService;
import com.cy.store.util.JsonResult;
import com.cy.store.vo.ProductCascader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/products")
public class ProductController extends BaseController {
    @Autowired
    private IProductService productService;

    /**
     * 获取热销榜单前四名
     */
    @RequestMapping("/hot_list")
    public JsonResult<List<Product>> getHotList() {
        List<Product> data = productService.findHotList();
        return new JsonResult<List<Product>>(OK, data);
    }

    @GetMapping("/{id}/details")
    public JsonResult<Product> getProductById(@PathVariable("id") Integer id) {
        // 调用业务对象执行获取数据
        Product data = productService.findById(id);
        // 返回成功和数据
        return new JsonResult<Product>(OK, data);
    }

    /**
     * 查询最新到货的商品
     */
    @GetMapping("/findProductsNew")
    public JsonResult<List<Product>> findProductsNew()
    {
        List<Product> productList = productService.findProductsNew();
        return new JsonResult<List<Product>>(OK,productList);
    }

    /**
     * 获取商品级联列表
     */
    @GetMapping("/getProductCascader")
    public JsonResult<List<ProductCascader>> getProductCascader()
    {
        List<ProductCascader> productCascaderList = productService.getProductCascader();
        return new JsonResult<List<ProductCascader>>(OK,productCascaderList);
    }

    /**
     * 分页查询商品列表
     */
    @PostMapping("/pageProductList")
    public JsonResult<Page<Product>> pageProductList(@RequestBody PageRequest<Product> request)
    {
        Page<Product> page = request.getPage();
        Product product = request.getParams();
        Page<Product> listPage = productService.pageProductList(page,product);
        return new JsonResult<Page<Product>>(OK,listPage);
    }

    /**
     * 查询所有的商品类型
     */
    @GetMapping("findAllItemType")
    public JsonResult<List<String>> findAllItemType()
    {
        List<String> items = productService.findAllItemType();
        return new JsonResult<>(OK,items);
    }
}
