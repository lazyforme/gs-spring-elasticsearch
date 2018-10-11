package com.wcy.hello.repository.elasticsearch;

import com.wcy.hello.model.elasticsearch.Dict_Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EsDictProductRepo extends ElasticsearchRepository<Dict_Product, String> {
}
