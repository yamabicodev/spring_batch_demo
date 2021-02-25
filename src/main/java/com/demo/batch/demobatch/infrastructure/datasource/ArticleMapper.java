package com.demo.batch.demobatch.infrastructure.datasource;

import com.demo.batch.demobatch.domain.Article;
import com.demo.batch.demobatch.domain.ArticleSummary;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper {
     public Article findAll();
     void save(ArticleSummary articleSummary);
}
