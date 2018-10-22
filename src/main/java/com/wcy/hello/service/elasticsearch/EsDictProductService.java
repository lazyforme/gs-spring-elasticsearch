package com.wcy.hello.service.elasticsearch;

import com.wcy.hello.model.elasticsearch.Dict_Product;
import com.wcy.hello.scheme.ListResult;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.domain.Pageable;

public interface EsDictProductService {
    ListResult search(QueryBuilder queryBuilder, Pageable pageable);
    Dict_Product searchRegistry(QueryBuilder queryBuilder, Pageable pageable);
}
