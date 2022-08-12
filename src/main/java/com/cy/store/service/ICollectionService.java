package com.cy.store.service;

import com.cy.store.entity.Collection;
import com.cy.store.vo.ColletionVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ICollectionService {
    List<ColletionVO> selectColletions(Integer uid);
    void deleteCollection(Integer collectId);
    void addCollection(Collection collection);
}
