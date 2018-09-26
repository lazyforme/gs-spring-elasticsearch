package com.wcy.hello.service.elasticsearch;

import com.wcy.hello.model.elasticsearch.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface EsNewsService {
    News save(News news);

    void deleteById(String id);

    News findOne(String id);

    Iterable<News> findAll();

    Page<News> findByTitle(String title, PageRequest pageRequest);

    List<News> findByDesc(String desc);
}
