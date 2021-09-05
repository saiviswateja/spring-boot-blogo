package com.viswa.Blogo.controller;

import com.viswa.Blogo.model.Article;
import com.viswa.Blogo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping("/article")
    public Article insertArticle(@RequestBody Article article) {
        return articleService.insertArticle(article);
    }

    @GetMapping("/article")
    public List<Article> getArticles() {
        return articleService.getArticles();
    }

    @PostMapping("/article/like")
    public ResponseEntity<String> likeArticle(@RequestParam Integer id) {
        articleService.likeArticle(id);
        return new ResponseEntity<>("Successfully liked the post", HttpStatus.OK);
    }

    @PostMapping("/article/dislike")
    public ResponseEntity<String> dislikeArticle(@RequestParam Integer id) {
        articleService.dislikeArticle(id);
        return new ResponseEntity<>("Successfully Disliked the count", HttpStatus.OK);
    }
}
