package com.example.android.a2ndchance.sync;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.util.Log;

import com.example.android.a2ndchance.data.JobsContract;
import com.example.android.a2ndchance.utils.NetworkUtils;

import org.json.JSONException;

/**
 * Created by dnj on 6/14/17.
 */

public final class SyncTask {

    private static final String LOG_TAG = SyncTask.class.getSimpleName();

    synchronized static void syncData(Context context){

        ContentValues[] cv = null;
        try{
            cv = NetworkUtils.fetchData(context);
        } catch (JSONException e){
            Log.e(LOG_TAG, "Error fetching data: " + e);
        }

        if(cv != null && cv.length != 0){
            try{
                int rowsDeleted = context.getContentResolver().delete(JobsContract.JobSearchEntry.JOB_SEARCH_RESULTS_URI,
                        null,null);
                Log.i(LOG_TAG, "rows deleted %%%%%%% " + rowsDeleted);
                int rowsInserted = context.getContentResolver().bulkInsert(JobsContract.JobSearchEntry.JOB_SEARCH_RESULTS_URI,
                        cv);
                Log.i(LOG_TAG, "rows inserted %%%%%%% " + rowsInserted);
                Cursor c = context.getContentResolver().query(JobsContract.JobSearchEntry.JOB_SEARCH_RESULTS_URI, null,
                        null,null,null); // TODO: update efficiency or remove
                Log.i(LOG_TAG, "cursor count %%%%%%% " + c.getCount());
            } catch (SQLException e){
                Log.e(LOG_TAG, "Bulk insert error: " + e);
            }
        }
    }
}
