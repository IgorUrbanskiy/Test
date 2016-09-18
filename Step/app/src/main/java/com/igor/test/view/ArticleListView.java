package com.igor.test.view;

import com.igor.test.model.data.ArticlesList;

import java.util.List;

public interface ArticleListView {

    void showData(List<ArticlesList> list);

    void showError(String error);


}
