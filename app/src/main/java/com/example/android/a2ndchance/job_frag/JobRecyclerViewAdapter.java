package com.example.android.a2ndchance.job_frag;

import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.a2ndchance.R;
import com.example.android.a2ndchance.data.JobsContract;

/**
 * Created by dnj on 6/8/17.
 */

public class JobRecyclerViewAdapter extends RecyclerView.Adapter<JobRecyclerViewAdapter.JobSearchViewHolder> {

    private static final String LOG_TAG = JobSearchViewHolder.class.getSimpleName();
    private static Cursor mCursor;

    public JobRecyclerViewAdapter(){

    }
    @Override
    public JobSearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // inflate item view in view holder
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.job_search_item, parent, false);
        return new JobSearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(JobSearchViewHolder holder, int position) {

        Log.i(LOG_TAG, "Cursor count %%%%%: " + mCursor.toString());
        mCursor.moveToPosition(position);

        // get item variables
        int titleCol = mCursor.getColumnIndex(JobsContract.JobSearchEntry.JOB_TITLE);
        String jobTitle = mCursor.getString(titleCol);

        int companyCol = mCursor.getColumnIndex(JobsContract.JobSearchEntry.COMPANY_NAME);
        String company = mCursor.getString(companyCol);

//        int zipCol = mCursor.getColumnIndex(JobsContract.JobSearchEntry.JOB_ZIPCODE);
//        String zipcode = mCursor.getString(zipCol);

        int descrCol = mCursor.getColumnIndex(JobsContract.JobSearchEntry.DESCRIPTION);
        String description = mCursor.getString(descrCol);

        // set variables
        holder.mTitleTV.setText(jobTitle);
        holder.mCompanyTV.setText(company);
        holder.mDescrTV.setText(description);

//        holder.mZipTV.setText(zipcode);
    }

    @Override
    public int getItemCount() {
        if (mCursor == null) {
            return 0;
        } else {
            return mCursor.getCount();
        }
    }

    // replace current cursor with new cursor
    public void swapCursor(Cursor c){
        mCursor = c;
        notifyDataSetChanged();
    }

    public static class JobSearchViewHolder extends RecyclerView.ViewHolder {

        TextView mTitleTV;
        TextView mDescrTV;
        TextView mCompanyTV;

        public JobSearchViewHolder(View itemView) {
            super(itemView);

            mTitleTV = (TextView) itemView.findViewById(R.id.positionTitle);
            mDescrTV = (TextView) itemView.findViewById(R.id.descriptionText);
            mCompanyTV = (TextView) itemView.findViewById(R.id.companyName);
        }
    }
}
