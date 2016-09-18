package com.igor.test.presenter;

import android.util.Log;

import com.igor.test.model.Model;
import com.igor.test.model.ModelImpl;
import com.igor.test.model.data.ArticlesList;
import com.igor.test.view.ArticleListView;

import java.util.List;

import rx.Observer;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

public class ArticleListPresenter implements Presenter {

    private Model model = new ModelImpl();

    private ArticleListView mArticleListView;
    private Subscription subscription = Subscriptions.empty();

    public ArticleListPresenter(ArticleListView articleListView) {
        this.mArticleListView = articleListView;
    }

    @Override
    public void show() {

        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }

        subscription = model.getArticleList()
                .subscribe(new Observer<List<List<ArticlesList>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mArticleListView.showError(e.getMessage());
                        Log.d("MYLOG", "error " + e.getMessage());
                    }

                    @Override
                    public void onNext(List<List<ArticlesList>> lists) {
                        mArticleListView.showData(lists.get(1));
                    }


                });
    }

    @Override
    public void onStop() {
        if (!subscription.isUnsubscribed()) {
            Log.d("MYLOG", "onStop ArticleListPresenter = ");
            subscription.unsubscribe();
        }
    }
}
