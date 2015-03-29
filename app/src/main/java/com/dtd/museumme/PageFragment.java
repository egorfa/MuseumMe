package com.dtd.museumme;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockFragment;

import java.util.ArrayList;

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
                listMuseums = (ListView)view.findViewById(R.id.listMuseums);
                final ArrayList<Museum> Array = new ArrayList<Museum>();
                Array.add(new Museum("ММ Арт Музей", "89162442963", "Остоженка 8/35", 0, 0, "Вт-Вс 10:00 - 19:30", getResources().getString(R.string.museum1), null));
                Array.add(new Museum("Пушкинский музей ИЗО", "89162442963", "Красносельская 56", 0, 0, "Вт-Вс 11:00 - 20:30", getResources().getString(R.string.museum1), null));
                Array.add(new Museum("Центр Толерантности", "89162442963", "улица Образцова 11, стр.1а", 0, 0, "Вт-Вс 10:00 - 19:30", getResources().getString(R.string.museum1), null));
                Array.add(new Museum("Музей ДПИ", "89162442963", "Делегатская ул., 3", 0, 0, "Вт-Вс 10:00 - 19:30", getResources().getString(R.string.museum1), null));
                MuseumsListAdapter adapter = new MuseumsListAdapter(getActivity(), Array);
                listMuseums.setAdapter(adapter);

                listMuseums.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(getSherlockActivity().getBaseContext(), MuseumDescriptionActivity.class);
                        intent.putExtra("Museum", Array.get(position));
                        startActivity(intent);
                    }
                });

                break;
            case 1:
                view = inflater.inflate(R.layout.maps_museums, null);
                break;
        }

        return view;
    }
}
