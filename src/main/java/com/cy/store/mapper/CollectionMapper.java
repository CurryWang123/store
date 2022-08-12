package com.cy.store.mapper;

import com.cy.store.entity.Collection;
import com.cy.store.vo.ColletionVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollectionMapper {
//    查询收藏夹列表by uid
    List<ColletionVO> selectColletions(@Param("uid") Integer uid);

//    删除收藏夹
    int deleteCollection(@Param("collectId") Integer collectId);

//    添加收藏夹
    int addCollection(Collection collection);
}
