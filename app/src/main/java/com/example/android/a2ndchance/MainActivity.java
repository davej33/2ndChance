package com.example.android.a2ndchance;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.w3);

        TextView title = (TextView) findViewById(R.id.title);
        Typeface face=Typeface.createFromAsset(getAssets(),
                "VarelaRound-Regular.ttf");
        title.setTypeface(face);

        Button search = (Button) findViewById(R.id.searchButton);
        search.setTypeface(face);

        Button signIn = (Button) findViewById(R.id.signIn);
        signIn.setTypeface(face);

        Button signUp = (Button) findViewById(R.id.signUp);
        signUp.setTypeface(face);
    }
}
