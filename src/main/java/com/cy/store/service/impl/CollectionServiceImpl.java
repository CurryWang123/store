package com.cy.store.service.impl;

import com.cy.store.entity.Collection;
import com.cy.store.mapper.CollectionMapper;
import com.cy.store.service.ICollectionService;
import com.cy.store.service.ex.DeleteException;
import com.cy.store.service.ex.InsertException;
import com.cy.store.vo.ColletionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CollectionServiceImpl implements ICollectionService {
    @Autowired
    private CollectionMapper collectionMapper;
    @Override
    public List<ColletionVO> selectColletions(Integer uid) {
        return collectionMapper.selectColletions(uid);
    }

    @Override
    public void deleteCollection(Integer collectId) {
        int i = collectionMapper.deleteCollection(collectId);
        if (i<1)
        {
            throw new DeleteException("未知异常请联系管理员");
        }
    }

    @Override
    public void addCollection(Collection collection) {
        collection.setCreatedTime(new Date());
        collection.setCreatedUser(collection.getUsername());
        int i = collectionMapper.addCollection(collection);
        if (i<1)
        {
            throw new InsertException("未知异常请联系管理员");
        }
    }
}
