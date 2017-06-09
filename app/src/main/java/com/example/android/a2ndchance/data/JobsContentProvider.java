package com.example.android.a2ndchance.data;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by dnj on 6/9/17.
 */

public final class JobsContentProvider extends ContentProvider {

    // log tag
    private static final String LOG_TAG = JobsContentProvider.class.getSimpleName();

    // URI codes
    private static final int JOB_SEARCH_TABLE_CODE = 100;
    private static final int JOB_SEARCH_ITEM_CODE = 101;

    // URI matcher
    private static UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    // add URIs to matcher
    static {
        sUriMatcher.addURI(JobsContract.CONTENT_AUTHORITY, JobsContract.JOB_SEARCH_RESULTS_PATH, JOB_SEARCH_TABLE_CODE);
        sUriMatcher.addURI(JobsContract.CONTENT_AUTHORITY, JobsContract.JOB_SEARCH_RESULTS_PATH + "/#", JOB_SEARCH_ITEM_CODE);
    }

    // DB helper
    private JobsDbHelper mDbHelper;

    @Override
    public boolean onCreate() {
        // instantiate DB helper
        mDbHelper = new JobsDbHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int bulkInsert(@NonNull Uri uri, @NonNull ContentValues[] values) {

        // db and insert variable
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        int insertCount = 0;

        // match URI and insert
        switch(sUriMatcher.match(uri)){
            case JOB_SEARCH_TABLE_CODE:
                db.beginTransaction();
                long check;
                try{
                    for (ContentValues cv: values) {
                        check = db.insert(JobsContract.JobSearchEntry.JOB_SEARCH_RESULTS_TABLE, null, cv);
                        if(check != 1) insertCount++;
                    }
                    db.setTransactionSuccessful();
                } catch (SQLException e){
                    Log.e(LOG_TAG, "Bulk insert error: " + e);
                } finally {
                    db.endTransaction();
                }
                return insertCount;
            default:
                return super.bulkInsert(uri, values);
        }
    }
}
