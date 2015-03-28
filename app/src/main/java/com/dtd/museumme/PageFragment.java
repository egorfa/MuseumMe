package com.dtd.museumme;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockFragment;

public class PageFragment extends SherlockFragment {
    static final String ARGUMENT_PAGE_NUMBER = "arg_page_number";
    ListView listMuseums;
    int pageNumber;

    static PageFragment newInstance(int page) {
        PageFragment pageFragment = new PageFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(ARGUMENT_PAGE_NUMBER, page);
        pageFragment.setArguments(arguments);
        return pageFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNumber = getArguments().getInt(ARGUMENT_PAGE_NUMBER);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = null;

        switch (pageNumber){
            case 0:
                view = inflater.inflate(R.layout.list_museums, null);
                break;
            case 1:
                view = inflater.inflate(R.layout.maps_museums, null);
                break;
        }

        return view;
    }
}
