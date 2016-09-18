package com.igor.test.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.webkit.WebView;
import android.widget.TextView;

import com.igor.test.R;
import com.igor.test.model.data.Article;
import com.igor.test.model.data.ArticlesList;
import com.igor.test.presenter.ArticlePresenter;

import java.util.Calendar;
import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ArticleActivity extends AppCompatActivity implements ArticleView {
    @Bind(R.id.tv_title)
    TextView title;
    @Bind(R.id.tv_author)
    TextView author;
    @Bind(R.id.tv_date)
    TextView date;
    @Bind(R.id.web_View)
    WebView mWebView;
    private ArticlesList mArticlesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        mArticlesList = (ArticlesList) intent.getSerializableExtra(MainActivity.INTENT_TAG_ARTICLE_LIST);
        ArticlePresenter articlePresenter = new ArticlePresenter(this, mArticlesList.getId());
        articlePresenter.show();
    }

    private String getDate(long t) {
        Calendar cal = Calendar.getInstance(Locale.ENGLISH);
        cal.setTimeInMillis(t * 1000L);
        String date = DateFormat.format("dd-MM-yyyy hh:mm", cal).toString();
        return date;
    }

    private void makeToast(String text) {
        Snackbar.make(title, text, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showError(String error) {
        makeToast(error);
    }


    @Override
    public void showArticle(Article article) {
        String link;
        link = mArticlesList.getThumb().getLink().replace("%dx%d", "300x300");
        ;

        title.setText(article.getTitle());
        author.setText(article.getAuthor());
        date.setText(getDate(article.getDate()));

        String image = "<img src=\"" + link + "\" \">";
        String subtitle = "<h2><b>" + article.getSubtitle() + "</b></h2>";
        String htmlText = image + subtitle + article.getContent();

        mWebView.loadDataWithBaseURL(null, htmlText, "text/html", "en_US", null);
    }
}
