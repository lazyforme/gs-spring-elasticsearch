package com.wcy.hello.repository.mongo;

import com.wcy.hello.model.mongo.News;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NewsRepo extends MongoRepository<News, String> {
}
