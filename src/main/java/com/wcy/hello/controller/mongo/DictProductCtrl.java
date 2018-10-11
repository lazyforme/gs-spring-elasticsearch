package com.wcy.hello.controller.mongo;

import com.wcy.hello.model.mongo.Dict_Product;
import com.wcy.hello.repository.mongo.DictProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DictProductCtrl {
    @Autowired
    private DictProductRepo dictProductRepo;

    @GetMapping("/api/v1.0/dict/product/list")
    public Page<Dict_Product> getDictProductList(@RequestParam(value="page",required = true, defaultValue = "0") int page,
                                                 @RequestParam(value="size",required = true, defaultValue = "10") int size,
                                                 @RequestParam(value="keywords",required = true) String keywords) {
        Pageable pageable = PageRequest.of(page,size);
        Page<Dict_Product> result = dictProductRepo.findByKeywords(keywords, pageable);
        return result;
    }
}
