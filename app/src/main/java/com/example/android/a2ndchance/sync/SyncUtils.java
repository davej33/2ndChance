package com.example.android.a2ndchance.sync;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;

import com.example.android.a2ndchance.data.JobsContract;

/**
 * Created by dnj on 6/13/17.
 */

public final class SyncUtils {

    public static boolean sIsInitialized;

    public static void initializeDB(final Context context) {

        //
        if(!sIsInitialized){
            sIsInitialized = true;
        }

        // check provider
        Thread providerCheck = new Thread(new Runnable() {
            @Override
            public void run() {
                String[] projection = {JobsContract.JobSearchEntry._ID};
                Cursor c = context.getContentResolver().query(JobsContract.JobSearchEntry.JOB_SEARCH_RESULTS_URI,
                        projection,null,null,null);
                if(c == null || c.getCount() == 0){
                    syncImmediately(context);
                }
//                c.close();
            }
        });
        providerCheck.run();

    }

    private static void syncImmediately(Context context) {
        Intent intent = new Intent(context, JobIntentService.class);
        context.startService(intent);
    }
}
