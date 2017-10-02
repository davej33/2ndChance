package com.example.android.a2ndchance.job_frag;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.a2ndchance.R;
import com.example.android.a2ndchance.data.JobsContract;
import com.example.android.a2ndchance.sync.SyncUtils;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SearchResultsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class SearchResultsFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {

    private static final String LOG_TAG = SearchResultsFragment.class.getSimpleName();
    private static final int JOB_SEARCH_LOADER_ID = 100;
    private OnFragmentInteractionListener mListener;
    private RecyclerView mRecyclerView;
    private JobRecyclerViewAdapter mAdapter;


    // Required empty public constructor
    public SearchResultsFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_results, container, false);

        // setup recycler view with adapter and layout manager
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_job_search);
        mAdapter = new JobRecyclerViewAdapter();
        mRecyclerView.setAdapter(mAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);

        if (SyncUtils.sIsInitialized) {
            displayData();
        } else {
            SyncUtils.initializeDB(getContext());
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    displayData();
                }
            }, 1000);
        }


        return view;
    }

    private void displayData() {
        getLoaderManager().initLoader(JOB_SEARCH_LOADER_ID, null, this);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        // return new cursor loader
        return new CursorLoader(getContext(), JobsContract.JobSearchEntry.JOB_SEARCH_RESULTS_URI,
                null, null, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        if (data != null && data.getCount() > 0) {
            mAdapter.swapCursor(data);
        } else {
            Log.d(LOG_TAG, "OnLoadFinished cursor count: ");
        }

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mAdapter.swapCursor(null);
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


}
