package com.example.android.a2ndchance.sync;

import android.app.IntentService;
import android.content.Intent;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class JobIntentService extends IntentService {

    public JobIntentService() {
        super("JobIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
        SyncTask.syncData(getApplicationContext());
        }
    }

}
