package com.igor.test.view.interfaces;

import com.igor.test.model.data.ArticlesList;

import java.util.List;

public interface ArticleListView {

    void showData(List<ArticlesList> list);

    void showError(String error);

    void showProgress();

    void hideProgress();


}
