package com.niu.bee.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.niu.bee.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListsFragment extends Fragment {


    public ListsFragment() {
        // Required empty public constructor
    }

    public static ListsFragment getInstance() {
        ListsFragment list = new ListsFragment();
        return list;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lists, container, false);
    }
}
