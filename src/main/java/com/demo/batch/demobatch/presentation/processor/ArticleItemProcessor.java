package com.demo.batch.demobatch.presentation.processor;

import com.demo.batch.demobatch.domain.Article;
import com.demo.batch.demobatch.domain.ArticleSummary;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class ArticleItemProcessor implements ItemProcessor<Article, ArticleSummary> {
    @Override
    public ArticleSummary process(Article article) throws Exception {
        return ArticleSummary.of(article.id(), article.title(), article.comments().size());
    }
}
