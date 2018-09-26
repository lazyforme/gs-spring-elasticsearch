package com.wcy.hello.service.elasticsearch;

import com.wcy.hello.model.elasticsearch.News;
import com.wcy.hello.repository.elasticsearch.EsNewsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EsNewsServiceImpl implements EsNewsService {

    private EsNewsRepo esNewsRepo;

    @Autowired
    public void setEsNewsRepo(EsNewsRepo esNewsRepo) {
        this.esNewsRepo = esNewsRepo;
    }

    @Override
    public News save(News news) {
        return esNewsRepo.save(news);
    }

    @Override
    public void deleteById(String id) {
        esNewsRepo.deleteById(id);
    }

    @Override
    public News findOne(String id) {
        if (esNewsRepo.findById(id).isPresent()) {
            return esNewsRepo.findById(id).get();
        }
        return null;
    }

    @Override
    public Iterable<News> findAll() {
        return esNewsRepo.findAll();
    }

    @Override
    public Page<News> findByTitle(String title, PageRequest pageRequest) {
        return esNewsRepo.findByTitle(title, pageRequest);
    }

    @Override
    public List<News> findByDesc(String desc) {
        return esNewsRepo.findByDesc(desc);
    }
}
