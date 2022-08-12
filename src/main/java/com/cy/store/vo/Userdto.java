package com.cy.store.vo;

import com.cy.store.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Userdto extends User {
    String oldPassword;
    String newPassword;
    Integer uid;
    String username;
}
