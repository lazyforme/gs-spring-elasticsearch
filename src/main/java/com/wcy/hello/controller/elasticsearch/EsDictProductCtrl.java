package com.wcy.hello.controller.elasticsearch;

import com.wcy.hello.model.elasticsearch.Dict_Product;
import com.wcy.hello.repository.elasticsearch.EsDictProductRepo;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EsDictProductCtrl {

    @Autowired
    private EsDictProductRepo esDictProductRepo;

    @GetMapping("/api/v1.0/es/dict/product/list")
    public Page<Dict_Product> getDictProductList(@RequestParam(value="page",required = true, defaultValue = "0") int page,
                                                 @RequestParam(value="size",required = true, defaultValue = "10") int size,
                                                 @RequestParam(value="keywords",required = true) String keywords) {
        Pageable pageable = PageRequest.of(page,size);
        QueryBuilder queryBuilder = QueryBuilders.matchQuery("keywords", keywords);
        Page<Dict_Product> result = esDictProductRepo.search(queryBuilder, pageable);
        return result;
    }
}
