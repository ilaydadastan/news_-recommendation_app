package com.ilaydadastan.projeb.recommendation;

import com.ilaydadastan.projeb.model.News;
import com.ilaydadastan.projeb.repository.NewsRepository;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PopularNewsAlgorithm {
    private final NewsRepository newsRepository;

    public PopularNewsAlgorithm(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public List<News> getPopularNews(News news) {
        List<News> newsList = newsRepository.findByCategory(news.getCategory());
        return newsList.stream().filter(n -> n != null && n.getId() != news.getId() && n.getViewCount() != null).sorted(Comparator.comparing(News::getViewCount).reversed()).limit(5).collect(Collectors.toList());
    }

}
