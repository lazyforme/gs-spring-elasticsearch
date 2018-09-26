package com.wcy.hello.controller.mongo;

import com.wcy.hello.model.mongo.News;
import com.wcy.hello.repository.mongo.NewsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsCtrl {
    @Autowired
    private NewsRepo newsRepo;

    @GetMapping("/api/v1.0/news/list")
    public Page<News> getNewsList(@RequestParam(value="page",required = true, defaultValue = "0") int page,
                                  @RequestParam(value="size",required = true, defaultValue = "10") int size) {
        Sort sort = new Sort(Sort.Direction.DESC, "publishedTime");
        Pageable pageable = PageRequest.of(page,size,sort);
        Page<News> result = newsRepo.findAll(pageable);
        return result;
    }

    @GetMapping("/api/v1.0/news/detail")
    public News getNewsDetail(@RequestParam(value="id",required = true) String id) {
        News result = newsRepo.findById(id).get();
        return result;
    }
}
