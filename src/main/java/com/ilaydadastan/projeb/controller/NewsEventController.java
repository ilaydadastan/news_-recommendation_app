package com.ilaydadastan.projeb.controller;

import com.ilaydadastan.projeb.model.News;
import com.ilaydadastan.projeb.recommendation.PopularNewsAlgorithm;
import com.ilaydadastan.projeb.repository.NewsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class NewsEventController {
    private final NewsRepository newsRepository;
    private final PopularNewsAlgorithm popularNewsAlgorithm;

    public NewsEventController(NewsRepository newsRepository, PopularNewsAlgorithm popularNewsAlgorithm) {
        this.newsRepository = newsRepository;
        this.popularNewsAlgorithm = popularNewsAlgorithm;
    }

    @PostMapping(value = "/news")
    public List<News> recommend(@RequestBody News news) {
        if (news.getId() != null) {
            Optional<News> oNews = newsRepository.findById(news.getId());
            if (oNews.isPresent()) {
                news = oNews.get();
            }
        }
        news.incrementViewCount();
        newsRepository.save(news);
        return popularNewsAlgorithm.getPopularNews(news);
    }

    @GetMapping (value = "/news")
    public List<News> getAll() {
        return newsRepository.findAll();
    }

    @GetMapping (value = "/deleteAll")
    public List<News> removeAll() {
        newsRepository.deleteAll();
        return newsRepository.findAll();
    }

}
