package com.example.android.a2ndchance.utils;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by dnj on 5/17/17.
 */

public final class JsonUtils {

    public static ArrayList<String> parseJson(String bufferedString) {

        // TODO: switch statement to handle parsing of different tables
        ArrayList<String> cv = jobsJsonParse(bufferedString);

        return cv;
    }

    private static ArrayList<String> jobsJsonParse(String bufferedString) {

        final String JOB_KEY_ID = "id";
        final String JOB_KEY_EMPLOYER_ID = "employer_id";
        final String JOB_KEY_CATEGORY_ID = "category_id";
        final String JOB_KEY_EMPLOYMENT_TYPE = "employment_type";
        final String JOB_KEY_TITLE = "title";
        final String JOB_KEY_ZIPCODE = "zipcode";
        final String JOB_KEY_DESCRIPTION = "description";
        final String JOB_KEY_POST_DATE = "post_date";
        final String JOB_KEY_CLOSE_DATE = "close_date";
        final String JOB_KEY_HOURLY_LOW = "hourly_low";
        final String JOB_KEY_HOURLY_HIGH = "hourly_high";
        final String JOB_KEY_SALARY_LOW = "salary_low";
        final String JOB_KEY_SALARY_HIGH = "salary_high";
        final String JOB_KEY_COMMISSION = "commission";
        final String JOB_KEY_NEGOTIABLE = "salary_negotiable";

        ArrayList<String> cv = new ArrayList<>();

        try {
            JSONObject root = new JSONObject(bufferedString);
            JSONArray jobs = root.getJSONArray("jobs");
            for (int i = 0; i < jobs.length(); i++) {
                JSONObject element = jobs.getJSONObject(i);

                int job_id = element.getInt(JOB_KEY_ID);
                int emp_id = element.getInt(JOB_KEY_EMPLOYER_ID);
                int categ_id = element.getInt(JOB_KEY_CATEGORY_ID);
                String title = element.getString(JOB_KEY_TITLE);
                String zip = element.getString(JOB_KEY_ZIPCODE);

                String s = job_id + " - " + emp_id + " - " + categ_id + " - " + title + " - " + zip;

                cv.add(s);
            }
        } catch (JSONException e) {
            Log.e("Error JU", "Error parsing json: " + e);
        }

        Log.i("JSON UTILS", "Array size: " + cv.size());
        return cv;
    }
}
