package com.cy.store.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Cartdto implements Serializable {
//    购物车id字符串
    String cids;
//    购物车id
    Integer cid;
//    购物车数量
    Integer num;
//    修改人
    String modifiedUser;
//    商品id
    Integer pid;
//    添加到购物车商品的数量
    Integer amount;
//    用户id
    Integer uid;
    //    用户名
    String username;
}
