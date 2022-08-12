package com.cy.store.vo;

import com.cy.store.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderVO implements Serializable {
    private Address address;
    private List<CartVO> cartList;
    private Integer uid;
    private String username;
    private Long totalPrice;
}
