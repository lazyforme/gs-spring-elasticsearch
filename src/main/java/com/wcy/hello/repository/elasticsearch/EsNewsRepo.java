package com.wcy.hello.repository.elasticsearch;

import com.wcy.hello.model.elasticsearch.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EsNewsRepo extends ElasticsearchRepository<News, String> {

    Page<News> findByTitle(String title, Pageable pageable);

    List<News> findByDesc(String desc);

}
