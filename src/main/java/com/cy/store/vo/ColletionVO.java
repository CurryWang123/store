package com.cy.store.vo;

import com.cy.store.entity.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ColletionVO extends BaseEntity implements Serializable {
    private Integer collectId;
    private Integer uid;
    private Integer pid;
    private Integer price;
    private Integer collectionNum;
    private String title;
    private String image;
}
