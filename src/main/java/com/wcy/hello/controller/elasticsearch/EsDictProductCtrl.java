package com.wcy.hello.controller.elasticsearch;

import com.wcy.hello.model.elasticsearch.Dict_Product;
import com.wcy.hello.scheme.ListResult;
import com.wcy.hello.service.elasticsearch.EsDictProductService;
import com.wcy.hello.utils.RegistryValidator;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EsDictProductCtrl {

    @Autowired
    private EsDictProductService esDictProductService;

//    获取标准商品库列表
    @GetMapping("/api/v1.0/std_prod/list")
    public ListResult getDictProductList(@RequestParam(value="page",required = true, defaultValue = "0") int page,
                                         @RequestParam(value="size",required = true, defaultValue = "10") int size,
                                         @RequestParam(value="keywords",required = true) String keywords) {
        Pageable pageable = PageRequest.of(page,size);
        //QueryBuilder queryBuilder = QueryBuilders.matchQuery("keywords", keywords);
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
        queryBuilder.must(QueryBuilders.matchQuery("archived", false));
        queryBuilder.must(QueryBuilders.matchQuery("keywords", keywords));
        ListResult result = esDictProductService.search(queryBuilder, pageable);
        return result;
    }

//    根据登记证号获取标准库商品
    @GetMapping("/api/v1.0/std_prod/registry")
    public Dict_Product getDictProductByRegistry(@RequestParam(value="page",required = true, defaultValue = "0") int page,
                                                 @RequestParam(value="size",required = true, defaultValue = "10") int size,
                                                 @RequestParam(value="registry",required = true) String registry) {
        Pageable pageable = PageRequest.of(page,size);
        //QueryBuilder queryBuilder = QueryBuilders.matchQuery("keywords", keywords);
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
        queryBuilder.must(QueryBuilders.matchQuery("archived", false));
        queryBuilder.must(QueryBuilders.matchQuery("keywords", registry));
        Dict_Product result = esDictProductService.searchRegistry(queryBuilder, pageable);
        return result;
    }

    //    扫码根据登记证号获取标准库商品,e.g:http://cha.ttyun.com/10921231145911174788787148557579
    @GetMapping("/api/v1.0/std_prod/detail")
    public Dict_Product getDictProductByQRCode(@RequestParam(value="page",required = true, defaultValue = "0") int page,
                                                 @RequestParam(value="size",required = true, defaultValue = "10") int size,
                                                 @RequestParam(value="registry",required = true) String registry) {
        Pageable pageable = PageRequest.of(page,size);
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
        queryBuilder.must(QueryBuilders.matchQuery("archived", false));
        RegistryValidator validator = new RegistryValidator();
        queryBuilder.must(QueryBuilders.matchQuery("keywords", (validator.getPIDByQRCode(registry)).getResult()));
        Dict_Product result = esDictProductService.searchRegistry(queryBuilder, pageable);
        return result;
    }
}
