package com.igor.test.view.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.igor.test.R;
import com.igor.test.model.data.ArticlesList;
import com.igor.test.presenter.ArticleListPresenter;
import com.igor.test.presenter.Presenter;
import com.igor.test.view.activities.ArticleActivity;
import com.igor.test.view.adapters.RecyclerViewAdapter;
import com.igor.test.view.interfaces.ArticleListView;

import java.util.ArrayList;
import java.util.List;

import static com.igor.test.view.activities.MainActivity.INTENT_TAG_ARTICLE_LIST;

/**
 * Created by Igor on 19.09.2016.
 */
public class ArticleListFragment extends Fragment implements ArticleListView, RecyclerViewAdapter.OnArticleClickListener {
    private static final String ARG_ID = "id";
    private static final String ARG_LIST = "list";
    private RecyclerViewAdapter adapter;
    //    private FavoriteAdapter mFavoriteAdapter;
    private Presenter presenter;
    private String id;
    private ArrayList favoriteList = new ArrayList();
    private ProgressBar mBar;

    public ArticleListFragment() {
        // Required empty public constructor
    }

    public static ArticleListFragment newInstance(String id) {
        ArticleListFragment articleListFragment = new ArticleListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_ID, id);
        articleListFragment.setArguments(args);
        return articleListFragment;
    }

    public static ArticleListFragment newInstance(ArrayList list) {
        ArticleListFragment articleListFragment = new ArticleListFragment();
        Bundle args = new Bundle();
        args.putStringArrayList(ARG_LIST, list);
        articleListFragment.setArguments(args);
        return articleListFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.content_main, container, false);

        mBar = (ProgressBar) rootView.findViewById(R.id.progress);

        Log.d("MYLOG", "onCreateView = ");
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        adapter = new RecyclerViewAdapter().withClickListener(this);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(llm);
        final Bundle bundle = getArguments();
        if (bundle != null) {
            if (bundle.containsKey(ARG_ID)) {
                id = bundle.getString(ARG_ID);
                Log.d("MYLOG", "id = " + id);
                recyclerView.setAdapter(adapter);
                presenter = new ArticleListPresenter(this, id);
                presenter.show();
            }
            if (bundle.containsKey(ARG_LIST)) {
                favoriteList = bundle.getStringArrayList(ARG_LIST);
                Log.d("MYLOG", "favoriteList = " + favoriteList);
                recyclerView.setAdapter(adapter);
                adapter.setArticleList(favoriteList);
                recyclerView.setAdapter(adapter);
            }
        }

        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
        if (presenter != null) {
            presenter.onStop();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.onDestroy();
        }
    }

    @Override
    public void showData(List<ArticlesList> list) {
        adapter.setArticleList(list);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(getContext(), error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showProgress() {
        if (mBar != null) {
            mBar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void hideProgress() {
        if (mBar != null) {
            mBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void onArticleClick(View v, int position, ArticlesList articlesList) {
        Intent intent = new Intent(getActivity(), ArticleActivity.class);
        intent.putExtra(INTENT_TAG_ARTICLE_LIST, articlesList);
        startActivity(intent);
    }
}
