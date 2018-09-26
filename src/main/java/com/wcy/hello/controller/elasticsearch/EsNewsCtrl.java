package com.wcy.hello.controller.elasticsearch;

import com.wcy.hello.model.elasticsearch.News;
import com.wcy.hello.service.elasticsearch.EsNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EsNewsCtrl {

    @Autowired
    private EsNewsService esNewsService;

    @GetMapping("/api/v1.0/es/news/all")
    public Iterable<News> findAll() {
        return esNewsService.findAll();
    }

    @GetMapping(value = "/api/v1.0/es/news/listByTitle")
    public Page<News> findNewsByTitle(@RequestParam String title, @RequestParam(value = "page", defaultValue = "0") Integer page,
                                      @RequestParam(value = "size", defaultValue = "10") Integer size) {
        Sort sort = new Sort(Sort.Direction.DESC, "publishedTime");
        PageRequest pageRequest = PageRequest.of(page,size,sort);
        return esNewsService.findByTitle(title, pageRequest);
    }

    @GetMapping("/api/v1.0/es/news/listByDesc")
    public List<News> findNewsByTitle(@RequestParam String desc) {
        return esNewsService.findByDesc(desc);
    }

    @GetMapping("/api/v1.0/es/news/detail")
    public News findNewsById(@RequestParam String id) {
        return esNewsService.findOne(id);
    }


    @DeleteMapping("/api/v1.0/es/news/detail")
    public String delete(@RequestParam String id) {
        esNewsService.deleteById(id);
        return "success";
    }
}
