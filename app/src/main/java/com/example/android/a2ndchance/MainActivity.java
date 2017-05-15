package com.example.android.a2ndchance;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView title = (TextView) findViewById(R.id.title);
        Typeface face =Typeface.createFromAsset(getAssets(),
                "VarelaRound-Regular.ttf");
        title.setTypeface(face);

        Button search = (Button) findViewById(R.id.searchButton);
        search.setTypeface(face);

        TextView signInText = (TextView) findViewById(R.id.signInText);
        signInText.setTypeface(face);
        TextView signUpText = (TextView) findViewById(R.id.signUpText);
        signUpText.setTypeface(face);


    }

    public void searchJobs(View view) {
        startActivity(new Intent(this, JobListActivity.class));
    }
}
