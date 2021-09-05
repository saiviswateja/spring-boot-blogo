package com.viswa.Blogo.service;

import com.viswa.Blogo.model.Article;
import com.viswa.Blogo.repository.ArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ArticleService {

    @Autowired
    public ArticleRepo articleRepo;

    public Article insertArticle(Article article) {
        return articleRepo.save(article);
    }

    public List<Article> getArticles() {
        return (List<Article>) articleRepo.findAll();
    }

    public void likeArticle(int id) {
        articleRepo.incrementLike(id);
    }

    public void dislikeArticle(int id) {
        articleRepo.decrementLike(id);
    }
}
