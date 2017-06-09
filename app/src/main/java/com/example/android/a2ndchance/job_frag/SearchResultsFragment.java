package com.example.android.a2ndchance.job_frag;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.android.a2ndchance.R;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SearchResultsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class SearchResultsFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {

    private static final int JOB_SEARCH_LOADER_ID = 100;
    private OnFragmentInteractionListener mListener;
    private RecyclerView mRecyclerView;
    private SearchListAdapter mAdpater;

    // Required empty public constructor
    public SearchResultsFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_results, container, false);


        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_job_search);
        // Inflate the layout for this fragment
        return view;
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

        return ;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }



//    AsyncTask<Void, Void, ArrayList<String>> task = new AsyncTask<Void, Void, ArrayList<String>>() {
//        @Override
//        protected ArrayList<String> doInBackground(Void... params) {
//            return NetworkUtils.fetchData(getContext());
//        }
//
//        @Override
//        protected void onPostExecute(ArrayList<String> strings) {
//            mAdpater = new SearchListAdapter(getContext(), strings);
//            mListView.setAdapter(mAdpater);
//        }
//    };


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

    private class SearchListAdapter extends ArrayAdapter<String>{

        private List<String> mList;

        public SearchListAdapter(@NonNull Context context, @NonNull List<String> objects) {
            super(context, 0, objects);
            mList = objects;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            // Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.applicant_item, parent, false);
            }

            String s = mList.get(position);
            TextView textView = (TextView) convertView.findViewById(R.id.applicant_item_textview);
            textView.setText(s);


            return convertView;
        }
    }
}
