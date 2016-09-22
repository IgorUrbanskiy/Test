package com.igor.test.view.interfaces;

import com.igor.test.model.data.Article;

/**
 * Created by Igor on 17.09.2016.
 */
public interface ArticleView {

    void showArticle(Article article);

    void showError(String error);


}
