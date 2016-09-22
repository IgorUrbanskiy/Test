package com.igor.test.model;

import com.igor.test.model.data.Article;
import com.igor.test.model.data.ArticlesList;
import com.igor.test.model.data.Categories;

import java.util.List;

import rx.Observable;

public interface Model {

    Observable<List<Categories>> getCategories();

    Observable<List<List<ArticlesList>>> getArticleList(String id);

    Observable<Article> getArticle(String id);
}
