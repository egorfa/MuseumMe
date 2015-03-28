package com.dtd.museumme;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;

/**
 * Created by 123 on 28.03.2015.
 */
public class FragmentSettings extends SherlockFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_settings, null);
        setActionBar();

        return view;
    }

    public void setActionBar(){
        ActionBar actionBar = getActivity().getActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        View customView = getActivity().getLayoutInflater().inflate(R.layout.actionbar_center, null);
        TextView title = (TextView) customView.findViewById(R.id.actionbarTitle);
        title.setText("Настройки");

        actionBar.setCustomView(customView);
    }
}
