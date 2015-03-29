package com.dtd.museumme;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

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

        final ArrayList<Exhibit> Array = new ArrayList<Exhibit>();

        Array.add(new Exhibit("Экспонат №1", 1, "Музей", "URL", getResources().getString(R.string.exhibit1)));
        Array.add(new Exhibit("Экспонат №2", 2, "Музей", "URL", getResources().getString(R.string.exhibit1)));
        Array.add(new Exhibit("Экспонат №3", 3, "Музей", "URL", getResources().getString(R.string.exhibit1)));
        Array.add(new Exhibit("Экспонат №4", 4, "Музей", "URL", getResources().getString(R.string.exhibit1)));
        Array.add(new Exhibit("Экспонат №5", 5, "Музей", "URL", getResources().getString(R.string.exhibit1)));
        Array.add(new Exhibit("Экспонат №6", 6, "Музей", "URL", getResources().getString(R.string.exhibit1)));
        Array.add(new Exhibit("Экспонат №7", 7, "Музей", "URL", getResources().getString(R.string.exhibit1)));
        Array.add(new Exhibit("Экспонат №8", 8, "Музей", "URL", getResources().getString(R.string.exhibit1)));
        Array.add(new Exhibit("Экспонат №9", 9, "Музей", "URL", getResources().getString(R.string.exhibit1)));
        Array.add(new Exhibit("Экспонат №10", 10, "Музей", "URL", getResources().getString(R.string.exhibit1)));
        Array.add(new Exhibit("Экспонат №11", 11, "Музей", "URL", getResources().getString(R.string.exhibit1)));
        Array.add(new Exhibit("Экспонат №12", 12, "Музей", "URL", getResources().getString(R.string.exhibit1)));

        bar.setVisibility(View.GONE);

        ExhibitsGridAdapter adapter = new ExhibitsGridAdapter(getActivity(), Array);
        exhibitGrid.setAdapter(adapter);

        exhibitGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), ExhibitActivity.class);
                intent.putExtra("Object", Array.get(position));
                startActivity(intent);
            }
        });

        TextView title = (TextView)getSherlockActivity().getActionBar().getCustomView().findViewById(R.id.actionbarTitle);
        title.setText("Все экспонаты");
        ImageView leftBurger = (ImageView)getSherlockActivity().getActionBar().getCustomView().findViewById(R.id.btn_menu);
        leftBurger.setBackground(getResources().getDrawable(R.drawable.left_arrow));

        leftBurger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(EnterKeyActivity.this, MuseumDescriptionActivity.class);
                //startActivity(intent);
                getActivity().finish();
            }
        });

        return view;
    }



}
