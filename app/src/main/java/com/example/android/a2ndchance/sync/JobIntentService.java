package com.example.android.a2ndchance.sync;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class JobIntentService extends IntentService {

    private static final String LOG_TAG = JobIntentService.class.getSimpleName();
    public JobIntentService() {
        super("JobIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
        SyncTask.syncData(getApplicationContext());
        } else {
            Log.e(LOG_TAG, "Null Intent");
        }
    }
}
