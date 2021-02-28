package com.demo.batch.demobatch.domain;

import lombok.Value;
import lombok.experimental.Accessors;

@Value(staticConstructor = "of")
@Accessors(fluent = true)
public class ArticleSummary {
    int id;
    String title;
    int numberOfComments;
}
