package com.igor.test.model;

import com.igor.test.model.api.ApiCategoryInterface;
import com.igor.test.model.api.ApiCategoryModule;
import com.igor.test.model.data.Article;
import com.igor.test.model.data.ArticlesList;
import com.igor.test.model.data.Categories;

import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ModelImpl implements Model {

    ApiCategoryInterface mApiCategoryInterface = ApiCategoryModule.getApiInterface();

    @Override
    public Observable<List<Categories>> getCategories() {
        return mApiCategoryInterface.getCategories()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<List<List<ArticlesList>>> getArticleList() {
        return mApiCategoryInterface.getArticlesList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<Article> getArticle(String id) {
        return mApiCategoryInterface.getArticle(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
