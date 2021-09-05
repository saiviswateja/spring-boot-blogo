package com.viswa.Blogo.repository;

import com.viswa.Blogo.model.Article;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;

@RepositoryDefinition(domainClass = Article.class, idClass = Integer.class)
public interface ArticleRepo {
    <S extends Article> S save(S var1);

    Iterable<Article> findAll();

    @Modifying
    @Query(value = "update Article u set u.like_count = u.like_count + 1 where articlepk = :id", nativeQuery = true)
    void incrementLike(@Param("id") int articleId);

    @Modifying
    @Query(value = "update Article u set u.like_count = u.like_count - 1 where articlepk = :id and u.like_count > 0", nativeQuery = true)
    void decrementLike(@Param("id") int articleId);
}
