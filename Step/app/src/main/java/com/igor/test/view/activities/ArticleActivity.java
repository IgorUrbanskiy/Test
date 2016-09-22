package com.igor.test.view.activities;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.igor.test.DBHelper;
import com.igor.test.R;
import com.igor.test.model.data.Article;
import com.igor.test.model.data.ArticlesList;
import com.igor.test.presenter.ArticlePresenter;
import com.igor.test.view.interfaces.ArticleView;

import java.util.Calendar;
import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.igor.test.DBHelper.TABLE_ARTICLES;

public class ArticleActivity extends AppCompatActivity implements ArticleView {
    @Bind(R.id.tv_title)
    TextView title;
    @Bind(R.id.tv_author)
    TextView author;
    @Bind(R.id.tv_date)
    TextView date;
    @Bind(R.id.web_View)
    WebView mWebView;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    private ToggleButton favorite;
    private ArticlesList mArticlesList;
    private Context mContext;
    private ArticlePresenter articlePresenter;
    private DBHelper mDBHelper;
    private SQLiteDatabase database;
    private Article mArticle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        ButterKnife.bind(this);
        mContext = this;
        mDBHelper = new DBHelper(this);
        database = mDBHelper.getWritableDatabase();
        initView();
        Intent intent = getIntent();
        mArticlesList = (ArticlesList) intent.getSerializableExtra(MainActivity.INTENT_TAG_ARTICLE_LIST);
        articlePresenter = new ArticlePresenter(this, mArticlesList.getId());
        articlePresenter.show();

    }

    @Override
    protected void onStop() {
        super.onStop();
        if (articlePresenter != null) {
            articlePresenter.onStop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (articlePresenter != null) {
            articlePresenter.onDestroy();
        }
    }

    private void initView() {
        LayoutInflater mInflater = LayoutInflater.from(this);
        View mCustomView = mInflater.inflate(R.layout.layout_article_action_bar, null);
        toolbar.removeAllViews();
        toolbar.addView(mCustomView);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        favorite = (ToggleButton) findViewById(R.id.favorite);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;
        }
        return false;
    }

    private void checkFavorite() {
        favorite.setChecked(checkInDatabase());
        favorite.setContentDescription(checkInDatabase() ? mContext.getString(R.string.cd_add_favorite) : mContext.getString(R.string.cd_remove_favorite));
        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkInDatabase()) {
                    deleteFromDatabase();
                    setCheckedFavoriteIcon(checkInDatabase());
                } else {
                    addToDatabase();
                    setCheckedFavoriteIcon(checkInDatabase());
                }
            }
        });
    }

    private String getDate(long t) {
        Calendar cal = Calendar.getInstance(Locale.FRANCE);
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
        mArticle = article;
        checkFavorite();
        String link;
        link = mArticlesList.getThumb().getLink().replace("%dx%d", "300x300");

        title.setText(article.getTitle());
        author.setText(article.getAuthor());
        date.setText(getDate(article.getDate()));

        String image = "<img src=\"" + link + "\" \">";
        String subtitle = "<h2><b>" + article.getSubtitle() + "</b></h2>";
        String htmlText = image + subtitle + article.getContent();

        mWebView.loadDataWithBaseURL(null, htmlText, "text/html", "en_US", null);
    }

    private void addToDatabase() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.KEY_ID, mArticle.getId());
        contentValues.put(DBHelper.KEY_TITLE, mArticlesList.getTitle());
        contentValues.put(DBHelper.KEY_SUBTITLE, mArticlesList.getSubtitle());
        contentValues.put(DBHelper.KEY_LINK, mArticlesList.getThumb().getLink());
        database.insert(TABLE_ARTICLES, null, contentValues);
        makeToast(getString(R.string.cd_add_favorite));
    }

    private void deleteFromDatabase() {
        database.delete(DBHelper.TABLE_ARTICLES, DBHelper.KEY_ID + " = '" + mArticle.getId() + "'", null);
        makeToast(getString(R.string.cd_remove_favorite));
    }

    private boolean checkInDatabase() {
        Cursor cursor = database.rawQuery("Select " + DBHelper.KEY_ID + " FROM " + DBHelper.TABLE_ARTICLES + " WHERE " + DBHelper.KEY_ID + " = ?", new String[]{mArticle.getId()});
        if (!(cursor.moveToFirst()) || cursor.getCount() == 0) {
            cursor.close();
            return false;
        } else {
            cursor.close();
            return true;
        }
    }

    private void setCheckedFavoriteIcon(boolean checked) {
        if (favorite != null) {
            favorite.setChecked(checked);
        }
    }
}
