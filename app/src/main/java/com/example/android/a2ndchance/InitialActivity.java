package com.example.android.a2ndchance;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class InitialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial);

        // title
        TextView title = (TextView) findViewById(R.id.title);

        // set custom typeface
        Typeface face =Typeface.createFromAsset(getAssets(),
                "VarelaRound-Regular.ttf");
        title.setTypeface(face);

        // search button with custom typeface
        Button search = (Button) findViewById(R.id.searchButton);
        search.setTypeface(face);

        // sign-in/up textview with custome typeface
        TextView signInText = (TextView) findViewById(R.id.signInText);
        signInText.setTypeface(face);
        TextView signUpText = (TextView) findViewById(R.id.signUpText);
        signUpText.setTypeface(face);


    }

    // search button onClick action
    public void searchJobs(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

    // TODO: sign-in button action
    // TODO: sign-up button action
}
