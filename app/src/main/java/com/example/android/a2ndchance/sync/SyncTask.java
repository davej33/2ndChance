package com.example.android.a2ndchance.sync;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

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
    }
}
