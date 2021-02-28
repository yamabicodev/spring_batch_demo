package com.demo.batch.demobatch.domain;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@NoArgsConstructor
@Getter
@Accessors(fluent = true)
public class Article {
    int id;
    String title;
    List<Comment> comments;
}
