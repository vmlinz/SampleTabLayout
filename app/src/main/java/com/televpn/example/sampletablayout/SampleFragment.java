package com.televpn.example.sampletablayout;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vmlinz on 6/26/15.
 */
public class SampleFragment extends Fragment {
    private List<String> mSampleList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_sample, container, false);
        setupSampleList();
        setupRecyclerView(recyclerView);
        return recyclerView;
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(new SimpleStringRecyclerViewAdapter(getActivity(),
                mSampleList));
    }

    private void setupSampleList() {
        mSampleList.clear();
        mSampleList.add("sample 1");
        mSampleList.add("sample 2");
        mSampleList.add("sample 3");
    }

    private static class SimpleStringRecyclerViewAdapter extends RecyclerView.Adapter<SimpleStringRecyclerViewAdapter.ViewHolder> {
        private List<String> mValues;

        public static class ViewHolder extends RecyclerView.ViewHolder {
            public final TextView mTextView;

            public ViewHolder(View itemView) {
                super(itemView);
                mTextView = (TextView)itemView.findViewById(android.R.id.text1);
            }

            @Override
            public String toString() {
                return super.toString() + " '" + mTextView.getText();
            }
        }

        public String getValueAt(int position) {
            return mValues.get(position);
        }

        public SimpleStringRecyclerViewAdapter(Context context, List<String> mSampleList) {
            mValues = mSampleList;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder viewHolder, int i) {
            viewHolder.mTextView.setText(mValues.get(i));
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }
    }
}
