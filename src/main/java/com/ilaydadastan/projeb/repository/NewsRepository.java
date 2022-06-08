package com.ilaydadastan.projeb.repository;

import com.ilaydadastan.projeb.model.News;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewsRepository extends JpaRepository<News, Long> {
    @Override
    List<News> findAll();

    public List<News> findByCategory(String category);
}
