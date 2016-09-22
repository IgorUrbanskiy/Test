package com.igor.test.model.api;

import com.igor.test.model.data.Article;
import com.igor.test.model.data.ArticlesList;
import com.igor.test.model.data.Categories;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

public interface ApiCategoryInterface {

    @GET("article/categories")
    Observable<List<Categories>> getCategories();

    @GET("article/header/{id}")
    Observable<List<List<ArticlesList>>> getArticlesList(@Path("id") String id);

    @GET("article/{id}")
    Observable<Article> getArticle(@Path("id") String id);

}
