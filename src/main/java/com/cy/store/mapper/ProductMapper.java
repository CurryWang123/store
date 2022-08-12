package com.cy.store.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cy.store.entity.Product;
import com.cy.store.vo.ProductCascader;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/** 处理商品数据的持久层接口 */
public interface ProductMapper extends BaseMapper<Product> {
    /**
     * 查询热销商品的前四名
     * @return 热销商品前四名的集合
     */
    List<Product> findHotList();

    /**
     * 根据商品id查询商品详情
     * @param id 商品id
     * @return 匹配的商品详情，如果没有匹配的数据则返回null
     */
    Product findById(Integer id);

    /**
     * 查询最新到货的商品
     */
    List<Product> findProductsNew();

    /**
     * 查询所有的商品类型
     */
    List<String> findAllItemType();

    /**
     * 获取商品级联列表
     */
    List<ProductCascader> getProductCascader(List<String> itemTypeList);

}
