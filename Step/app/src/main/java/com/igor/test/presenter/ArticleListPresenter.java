package com.igor.test.presenter;

import android.util.Log;

import com.igor.test.model.Model;
import com.igor.test.model.ModelImpl;
import com.igor.test.model.data.ArticlesList;
import com.igor.test.view.interfaces.ArticleListView;

import java.util.List;

import rx.Observer;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

public class ArticleListPresenter implements Presenter {

    private Model model = new ModelImpl();

    private ArticleListView mArticleListView;
    private Subscription subscription = Subscriptions.empty();
    private String id;
    public ArticleListPresenter(ArticleListView articleListView, String id) {
        this.mArticleListView = articleListView;
        this.id = id;
    }

    @Override
    public void show() {
        mArticleListView.showProgress();

        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }

        subscription = model.getArticleList(id)
                .subscribe(new Observer<List<List<ArticlesList>>>() {
                    @Override
                    public void onCompleted() {
                        mArticleListView.hideProgress();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mArticleListView.hideProgress();
                        mArticleListView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(List<List<ArticlesList>> lists) {
                        mArticleListView.hideProgress();
                        mArticleListView.showData(lists.get(1));
                    }
                });
    }

    @Override
    public void onStop() {
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

    @Override
    public void onDestroy() {
        if (mArticleListView != null) {
            mArticleListView = null;
        }
    }
}
