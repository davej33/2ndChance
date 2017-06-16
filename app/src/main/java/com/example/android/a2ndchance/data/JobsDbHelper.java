package com.example.android.a2ndchance.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by dnj on 6/9/17.
 */

final class JobsDbHelper extends SQLiteOpenHelper {

    // Database name and version
    private static final String JOBS_DB_NAME = "jobs";
    private static final int DB_VERSION = 1;

    public JobsDbHelper(Context context) {
        super(context, JOBS_DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//    final String CREATE_DB = "CREATE TABLE " + JobsContract.JobSearchEntry.JOB_SEARCH_RESULTS_TABLE + " (" +
//            JobsContract.JobSearchEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
//            JobsContract.JobSearchEntry.JOB_TITLE + " TEXT NOT NULL, " +
//            JobsContract.JobSearchEntry.EMPLOYER_ID + " TEXT NOT NULL, " +
//            JobsContract.JobSearchEntry.JOB_ZIPCODE + " TEXT NOT NULL); ";

        final String CREATE_DB = "CREATE TABLE " + JobsContract.JobSearchEntry.JOB_SEARCH_RESULTS_TABLE + " (" +
                JobsContract.JobSearchEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                JobsContract.JobSearchEntry.JOB_TITLE + " TEXT NOT NULL, " +
                JobsContract.JobSearchEntry.DESCRIPTION + " TEXT NOT NULL, " +
                JobsContract.JobSearchEntry.EMPLOYER_ID + " TEXT NOT NULL); ";

        db.execSQL(CREATE_DB);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + JobsContract.JobSearchEntry.JOB_SEARCH_RESULTS_TABLE);
        onCreate(db);
    }
}
