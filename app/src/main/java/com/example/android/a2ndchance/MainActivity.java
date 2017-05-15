package com.example.android.a2ndchance;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.a2ndchance.job_frag.AppliedJobsFragment;
import com.example.android.a2ndchance.job_frag.JobFragment;
import com.example.android.a2ndchance.job_frag.SaveJobsFragment;
import com.example.android.a2ndchance.job_frag.SearchResultsFragment;
import com.example.android.a2ndchance.profile_frag.ProfileFragment;

public class MainActivity extends AppCompatActivity implements
        JobFragment.OnFragmentInteractionListener,
        ProfileFragment.OnFragmentInteractionListener,
        SearchResultsFragment.OnFragmentInteractionListener,
        SaveJobsFragment.OnFragmentInteractionListener,
        AppliedJobsFragment.OnFragmentInteractionListener {

    static boolean sIsInitialized;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (!sIsInitialized) {
            getSupportFragmentManager().beginTransaction().add(R.id.main_frag_container, new JobFragment()).commit();
            sIsInitialized = true;
        }


        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.navigation_jobs:
                                getSupportFragmentManager().beginTransaction().replace(R.id.main_frag_container,
                                        new JobFragment()).commit();
                                break;
                            case R.id.navigation_dashboard:

                                break;
                            case R.id.navigation_profile:
                                getSupportFragmentManager().beginTransaction().replace(R.id.main_frag_container,
                                        new ProfileFragment()).commit();

                                break;
                        }
                        return true;
                    }
                });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_job_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */

        public PlaceholderFragment() {
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_job, container, false);
//            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
//            textView.setText(getString(R.string.section_format));
            return rootView;
        }
    }


}
