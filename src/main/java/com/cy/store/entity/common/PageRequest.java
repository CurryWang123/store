package com.cy.store.entity.common;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

/**
 * 分页
 * @author xuxn
 * @since 2021/3/2 10:00
 */
@Data
public class PageRequest<T>{
    Page<T> page;
    T params;
}
