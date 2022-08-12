package com.cy.store.vo;

import com.cy.store.entity.Order;
import com.cy.store.entity.OrderItem;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class OrderResponse implements Serializable {
    private Integer oid;
    private Integer uid;
    private String recvName;
    private String recvPhone;
    private String recvProvince;
    private String recvCity;
    private String recvArea;
    private String recvAddress;
    private Long totalPrice;
    private Integer status;
    private Date orderTime;
    private Date payTime;
    private String createdUser;
    private Date createdTime;
    private String modifiedUser;
    private Date modifiedTime;
    List<OrderItem> orderItemList;
}
