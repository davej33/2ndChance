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

        ArrayList<String> cv = new ArrayList<>();

        final String KEY_ID = "id";
        final String KEY_NAME = "name";
        final String KEY_ZIPCODE = "zipcode";


        try {
            JSONObject root = new JSONObject(bufferedString);
            JSONArray applicants = root.getJSONArray("applicants");
            for (int i = 0; i < applicants.length(); i++) {
                JSONObject element = applicants.getJSONObject(i);

                int id = element.getInt(KEY_ID);
                String name = element.getString(KEY_NAME);
                String zip = element.getString(KEY_ZIPCODE);

                String s = id + " - " + name + " - " + zip;

                cv.add(s);
            }
        } catch (JSONException e) {
            Log.e("Error JU", "Error parsing json: " + e);
        }

        Log.i("JSON UTILS", "Array size: " + cv.size());
        return cv;
    }
}
