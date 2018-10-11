package com.wcy.hello.repository.mongo;

import com.wcy.hello.model.mongo.Dict_Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface DictProductRepo extends MongoRepository<Dict_Product, String> {
    @Query("{'keywords': { $regex: ?0, $options: 'i'}}")
    public Page<Dict_Product> findByKeywords(String keywords, Pageable pageable);
}
