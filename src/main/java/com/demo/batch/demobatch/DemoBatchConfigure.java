package com.demo.batch.demobatch;

import com.demo.batch.demobatch.domain.Article;
import com.demo.batch.demobatch.domain.ArticleSummary;
import com.demo.batch.demobatch.infrastructure.datasource.ArticleMapper;
import com.demo.batch.demobatch.presentation.processor.ArticleItemProcessor;
import lombok.AllArgsConstructor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisBatchItemWriter;
import org.mybatis.spring.batch.MyBatisCursorItemReader;
import org.mybatis.spring.batch.builder.MyBatisBatchItemWriterBuilder;
import org.mybatis.spring.batch.builder.MyBatisCursorItemReaderBuilder;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
@AllArgsConstructor
public class DemoBatchConfigure {

    JobBuilderFactory jobs;
    StepBuilderFactory steps;
    SqlSessionFactory sqlSessionFactory;
    ArticleItemProcessor processor;

    @Bean
    public MyBatisCursorItemReader<Article> reader() {
        return new MyBatisCursorItemReaderBuilder<Article>()
                .sqlSessionFactory(sqlSessionFactory)
                .queryId(ArticleMapper.class.getName() + ".findAll")
                .build();
    }
    @Bean
    public MyBatisBatchItemWriter<ArticleSummary> writer() {
        return new MyBatisBatchItemWriterBuilder<ArticleSummary>()
                .sqlSessionFactory(sqlSessionFactory)
                .statementId(ArticleMapper.class.getName() + ".save")
                .build();
    }

    @Bean
    public Job job(Step step) {
        return jobs.get("job")
                .incrementer(new RunIdIncrementer())
                .flow(step)
                .end()
                .build();
    }

    @Bean
    public Step step(ItemReader<Article> reader, ItemWriter<ArticleSummary> writer) {
        return steps.get("step")
                .<Article, ArticleSummary>chunk(3)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }
}
