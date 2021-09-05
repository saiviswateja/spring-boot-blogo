package com.viswa.Blogo.model;

import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer articlePK;

    private String story;

    public Article(String story, Integer likeCount, Integer dislikeCount) {
        this.story = story;
        this.likeCount = likeCount!=null ? likeCount : 0;
        this.dislikeCount = dislikeCount!=null ? dislikeCount : 0;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Integer getDislikeCount() {
        return dislikeCount;
    }

    public Article() {
    }

    public void setDislikeCount(Integer dislikeCount) {
        this.dislikeCount = dislikeCount;
    }

    private Integer likeCount;

    private Integer dislikeCount;
}
