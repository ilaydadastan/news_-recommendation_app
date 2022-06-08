package com.ilaydadastan.projeb.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "news")
public class News {
    @Id
    private Long id;
    private String title;
    private String publishDate;
    private String content;
    private String category;
    @ElementCollection
    private List<String> labels;
    private Integer viewCount;
    private String mainImage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public void incrementViewCount() {
        if (this.getViewCount() == null) {
            this.setViewCount(1);
        } else {
            this.setViewCount(this.getViewCount() + 1);
        }
    }
}
