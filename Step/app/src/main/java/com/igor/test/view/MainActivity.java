package com.igor.test.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.igor.test.R;
import com.igor.test.model.data.ArticlesList;
import com.igor.test.presenter.ArticleListPresenter;
import com.igor.test.presenter.Presenter;
import com.igor.test.view.adapters.RecyclerViewAdapter;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ArticleListView, RecyclerViewAdapter.OnArticleClickListener {

    public static final String INTENT_TAG_ARTICLE_LIST = "intent_article_list";
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    private RecyclerViewAdapter adapter;

    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        presenter = new ArticleListPresenter(this);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(this));

        adapter = new RecyclerViewAdapter().withClickListener(this);
        recyclerView.setAdapter(adapter);
        presenter.show();
    }

    @Override
    public void showData(List<ArticlesList> list) {
        adapter.setArticleList(list);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (presenter != null) {
            presenter.onStop();
        }
    }

    private void makeToast(String text) {
        Snackbar.make(toolbar, text, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showError(String error) {
        makeToast(error);
    }

    @Override
    public void onArticleClick(android.view.View v, int position, ArticlesList articlesList) {
        Intent intent = new Intent(MainActivity.this, ArticleActivity.class);
        intent.putExtra(INTENT_TAG_ARTICLE_LIST, articlesList);
        startActivity(intent);
    }
}
