package com.igor.test;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Igor on 21.09.2016.
 */

public class DBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 3;
    public static final String DATABASE_NAME = "articlesDB";
    public static final String TABLE_ARTICLES = "articles";

    public static final String KEY_ID = "_id";
    public static final String KEY_TITLE = "title";
    public static final String KEY_SUBTITLE = "subtitle";
    public static final String KEY_LINK = "link";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("MyLogs", "OncreateDatabase");
        db.execSQL("create table " + TABLE_ARTICLES + " (" + KEY_ID + " text," + KEY_TITLE
                + " text, " + KEY_SUBTITLE + " text," + KEY_LINK + " text" + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("MyLogs", "onUpgradeDatabase");
        db.execSQL("drop table if exists " + TABLE_ARTICLES);
        onCreate(db);
    }
}
