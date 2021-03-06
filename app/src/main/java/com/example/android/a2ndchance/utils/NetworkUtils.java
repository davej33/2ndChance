package com.example.android.a2ndchance.utils;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.util.Log;

import com.example.android.a2ndchance.R;

import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by dnj on 5/16/17.
 */

public final class NetworkUtils {

    // log tag
    private static final String LOG_TAG = NetworkUtils.class.getSimpleName();

    // constants
    private static String JOBS_SEARCH_URL = "rezoome/apiTest.php";
    private static String JOBS_TABLES = "jobs";

    // returns data to enter in DB
    public static ContentValues[] fetchData(Context context) throws JSONException {

        // TODO: switch statement to handle parsing of different tables

        // builds Uri using current state of preferences
        Uri uri = Uri.parse(context.getString(R.string.url_base)).buildUpon()
                .appendEncodedPath(JOBS_SEARCH_URL)
                .appendEncodedPath(JOBS_TABLES)
                .build();

        URL url = null;
        try {
            url = new URL(uri.toString());
            Log.i(LOG_TAG, "URL: " + url);
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Malformed URL: " + e);
        }

        String bufferedString = null;
        if (url != null) {
            try {
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setReadTimeout(10000);
                connection.setConnectTimeout(15000);
                connection.connect();
                Log.i(LOG_TAG, "Connection Status: " + connection.getResponseCode());

                InputStream inputStream = connection.getInputStream();
                Log.i(LOG_TAG, "Input Stream: " + inputStream.toString());

                Scanner scanner = new Scanner(inputStream).useDelimiter("\\A");
                if (scanner.hasNext()) {
                    bufferedString = scanner.next();
                    Log.i(LOG_TAG, "%%%%%%%% bufferred string: " + bufferedString);
                }
            } catch (IOException e) {
                Log.e(LOG_TAG, "URL connection error: " + e);
            }
        }

        return JsonUtils.parseJson(bufferedString);
    }
}
