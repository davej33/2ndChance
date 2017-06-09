package com.example.android.a2ndchance.job_frag;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.a2ndchance.R;

/**
 * Created by dnj on 6/8/17.
 */

public class JobRecyclerView extends RecyclerView.Adapter<JobRecyclerView.JobSearchViewHolder> {


    @Override
    public JobSearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.job_search_item, parent, false);

        return new JobSearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(JobSearchViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class JobSearchViewHolder extends RecyclerView.ViewHolder{

        public JobSearchViewHolder(View itemView) {
            super(itemView);
        }
    }
}
