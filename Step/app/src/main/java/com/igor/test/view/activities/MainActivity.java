package com.igor.test.view.activities;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.igor.test.DBHelper;
import com.igor.test.R;
import com.igor.test.model.data.ArticlesList;
import com.igor.test.view.fragments.ArticleListFragment;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.igor.test.DBHelper.TABLE_ARTICLES;

public class MainActivity extends AppCompatActivity {

    public static final String INTENT_TAG_ARTICLE_LIST = "intent_article_list";
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.tabHost)
    TabLayout tabLayout;
    @Bind(R.id.viewpager)
    ViewPager mViewPager;
    DBHelper mDBHelper;
    SQLiteDatabase database;
    private ArrayList mFavoriteList;
    private PagerAdapter pagerAdapter;
    private static int mSelectedTabIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Log.d("MYLOG", "onCreate");
        mDBHelper = new DBHelper(this);
        database = mDBHelper.getWritableDatabase();
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MYLOG", "onResume" + mSelectedTabIndex);
        mFavoriteList = new ArrayList();
        Cursor cursor = database.query(TABLE_ARTICLES, null, null, null, null, null, null);
        if (cursor.moveToLast()) {
            int idColIndex = cursor.getColumnIndex(DBHelper.KEY_ID);
            int titleColIndex = cursor.getColumnIndex(DBHelper.KEY_TITLE);
            int subTitleColIndex = cursor.getColumnIndex(DBHelper.KEY_SUBTITLE);
            int linkColIndex = cursor.getColumnIndex(DBHelper.KEY_LINK);

            do {
                ArticlesList.Thumb thumb = new ArticlesList.Thumb(cursor.getString(linkColIndex));
                Log.d("MYLOG", "ID = " + cursor.getInt(idColIndex) + " title = "
                        + cursor.getString(titleColIndex) + " subtitle = " + cursor.getString(subTitleColIndex) + " link = " + cursor.getString(linkColIndex));
                mFavoriteList.add(new ArticlesList(cursor.getString(idColIndex), cursor.getString(titleColIndex), cursor.getString(subTitleColIndex), thumb));
//                mFavoriteList.add(new FavoriteArticleList(cursor.getString(idColIndex), cursor.getString(titleColIndex), cursor.getString(subTitleColIndex), cursor.getString(linkColIndex)));

            } while (cursor.moveToPrevious());
        } else {
            Log.d("MyLogss", " 0 rows");
        }
        cursor.close();

        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), MainActivity.this);
        mViewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(mViewPager);

        if (mSelectedTabIndex!=-1) {
            tabLayout.getTabAt(mSelectedTabIndex).select();
            setTitle(tabLayout.getTabAt(mSelectedTabIndex).getText());
        }else{
            setTitle(tabLayout.getTabAt(0).getText());
        }
        tabLayout.setOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager) {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                super.onTabSelected(tab);
                setTitle(tab.getText());
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        mSelectedTabIndex = mViewPager.getCurrentItem();
    }

    class PagerAdapter extends FragmentStatePagerAdapter {

        String tabTitles[] = new String[]{"Actualités", "Économie", "Sport", "Culture", "Favorite"};
        Context context;

        PagerAdapter(FragmentManager fm, Context context) {
            super(fm);
            this.context = context;
        }

        @Override
        public int getCount() {
            return tabTitles.length;
        }

        @Override
        public Fragment getItem(int position) {
            Log.d("MYLOG", "getItem");
            switch (position) {
                case 0:
                    return ArticleListFragment.newInstance("QWN0dWFsaXTDqXNBY3R1YWxpdMOpcw==");
                case 1:
                    return ArticleListFragment.newInstance("w4ljb25vbWllw4ljb25vbWll");
                case 2:
                    return ArticleListFragment.newInstance("U3BvcnRTcG9ydA==");
                case 3:
                    return ArticleListFragment.newInstance("Q3VsdHVyZUN1bHR1cmU=");
                case 4:
                    return ArticleListFragment.newInstance(mFavoriteList);
            }

            return null;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            // Generate title based on item position
            return tabTitles[position];
        }


    }
}
