package com.cy.store.controller;

import com.cy.store.entity.Collection;
import com.cy.store.service.ICollectionService;
import com.cy.store.util.JsonResult;
import com.cy.store.vo.ColletionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/collection")
public class CollectionController extends BaseController {
    @Autowired
    private ICollectionService collectionService;

    @GetMapping("/selectColletions")
    public JsonResult<List<ColletionVO>> selectColletions(@RequestParam("uid") Integer uid)
    {
        List<ColletionVO> collectionList = collectionService.selectColletions(uid);
        return new JsonResult<List<ColletionVO>>(OK,collectionList);
    }

    @GetMapping("/deleteCollection")
    public JsonResult<Void> deleteCollection(@RequestParam("collectId") Integer collectId)
    {
        collectionService.deleteCollection(collectId);
        return new JsonResult<Void>(OK);
    }

    @PostMapping("/addCollection")
    public JsonResult<Void> addCollection(@RequestBody Collection collection)
    {
        collectionService.addCollection(collection);
        return new JsonResult<Void>(OK);
    }
}
