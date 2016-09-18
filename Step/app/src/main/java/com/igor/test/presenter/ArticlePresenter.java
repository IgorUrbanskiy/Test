package com.igor.test.presenter;

import android.util.Log;

import com.igor.test.model.Model;
import com.igor.test.model.ModelImpl;
import com.igor.test.model.data.Article;
import com.igor.test.view.ArticleView;

import rx.Observer;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

/**
 * Created by Igor on 17.09.2016.
 */
public class ArticlePresenter implements Presenter {
    private Model model = new ModelImpl();

    private ArticleView mArticleView;
    private Subscription subscription = Subscriptions.empty();
    private String id;

    public ArticlePresenter(ArticleView articleListView, String id) {
        this.mArticleView = articleListView;
        this.id = id;
    }

    @Override
    public void show() {

        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }

        subscription = model.getArticle(id)
                .subscribe(new Observer<Article>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mArticleView.showError(e.getMessage());
                        Log.d("MYLOG", "onError = " + e.getMessage());

                    }

                    @Override
                    public void onNext(Article data) {
                        if (data != null) {
                            mArticleView.showArticle(data);
                        }
                    }
                });
    }

    @Override
    public void onStop() {
        if (!subscription.isUnsubscribed()) {
            Log.d("MYLOG", "onStop ArticlePresenter = ");
            subscription.unsubscribe();
        }
    }
}
