package com.cy.store.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Collection extends BaseEntity implements Serializable {
    private Integer collectId;
    private Integer uid;
    private Integer pid;

}
