package com.dtd.museumme;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.actionbarsherlock.app.SherlockFragment;

import java.util.ArrayList;

/**
 * Created by Egor on 28.03.2015.
 */
public class ListExhibit extends SherlockFragment {

    ProgressBar bar;
    RelativeLayout viewRL;

    GridView exhibitGrid;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_exhibit, container, false);

        exhibitGrid = (GridView) view.findViewById(R.id.gridView);
        bar = (ProgressBar) view.findViewById(R.id.bar);
        viewRL =  (RelativeLayout)view.findViewById(R.id.RL);

        ArrayList<Exhibit> Array = new ArrayList<Exhibit>();

        Array.add(new Exhibit("Экспонат №1", 1, "Музей", "URL"));
        Array.add(new Exhibit("Экспонат №2", 2, "Музей", "URL"));
        Array.add(new Exhibit("Экспонат №3", 3, "Музей", "URL"));
        Array.add(new Exhibit("Экспонат №4", 4, "Музей", "URL"));
        Array.add(new Exhibit("Экспонат №5", 5, "Музей", "URL"));
        Array.add(new Exhibit("Экспонат №6", 6, "Музей", "URL"));
        Array.add(new Exhibit("Экспонат №7", 7, "Музей", "URL"));
        Array.add(new Exhibit("Экспонат №8", 8, "Музей", "URL"));
        Array.add(new Exhibit("Экспонат №9", 9, "Музей", "URL"));
        Array.add(new Exhibit("Экспонат №10", 10, "Музей", "URL"));
        Array.add(new Exhibit("Экспонат №11", 11, "Музей", "URL"));
        Array.add(new Exhibit("Экспонат №12", 12, "Музей", "URL"));

        bar.setVisibility(View.GONE);

        ExhibitsGridAdapter adapter = new ExhibitsGridAdapter(getActivity(), Array);
        exhibitGrid.setAdapter(adapter);

        return view;
    }



}