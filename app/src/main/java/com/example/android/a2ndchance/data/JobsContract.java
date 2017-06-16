package com.example.android.a2ndchance.data;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by dnj on 6/8/17.
 */

public final class JobsContract  {

    public static final String CONTENT_AUTHORITY = "com.example.android.a2ndchance";
    public static final Uri CONTENT_BASE_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String JOB_SEARCH_RESULTS_PATH = "job-search";

    public static final class JobSearchEntry implements BaseColumns{

        // job search table URI
        public static final Uri JOB_SEARCH_RESULTS_URI = CONTENT_BASE_URI.buildUpon()
                .appendPath(JOB_SEARCH_RESULTS_PATH)
                .build();

        // table
        public static final String JOB_SEARCH_RESULTS_TABLE = "results";

        // columns
        public static final String _ID = BaseColumns._ID;
        public static final String JOB_ZIPCODE = "zipcode";
        public static final String EMPLOYER_ID = "employer_id";
        public static final String JOB_TITLE = "title";
        public static final String DESCRIPTION = "description";



    }
}
