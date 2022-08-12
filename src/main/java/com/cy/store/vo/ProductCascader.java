package com.cy.store.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class ProductCascader implements Serializable {
//    标签名
    private String label;
//    标签值
    private String value;
//    下一级列表
    private List<ProductCascaderChildren> children;
}
