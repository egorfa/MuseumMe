package com.dtd.museumme;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 123 on 29.03.2015.
 */
public class MuseumsListAdapter extends ArrayAdapter<Museum> {

    Context mContext;
    //ArrayList<ArrayList<News>> videos;
    ArrayList<Museum> museums;

    //public NewsAdapter(Context context, ArrayList<ArrayList<News>> videos) {
    public MuseumsListAdapter(Context context, ArrayList<Museum> museums) {
        super(context, R.layout.museum_list_item, museums);
        this.mContext = context;
        this.museums = museums;

    }


    static class ViewHolder {
        TextView title, address, time;
    }

    public View getView(final int position, View convertView, final ViewGroup parent) {

        final ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.museum_list_item, parent, false);
            //holder.img = (ImageView) convertView.findViewById(R.id.img);
            holder.title = (TextView) convertView.findViewById(R.id.museumListTitle);
            holder.address = (TextView) convertView.findViewById(R.id.museumListAddress);
            holder.time = (TextView) convertView.findViewById(R.id.museumListTime);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }


        //int id = mContext.getResources().getIdentifier("contentexample_" + String.valueOf(position + 1) , "drawable", mContext.getPackageName());

        //holder.img.setImageResource(id);

        holder.title.setText(museums.get(position).getTitle());
        holder.address.setText(museums.get(position).getAddress());
        holder.time.setText(museums.get(position).getTime());
        //holder.img.setImageResource();

        String FONT = "fonts/Roboto-Light.ttf";
        Typeface typeface;
        typeface = Typeface.createFromAsset(getContext().getAssets(), FONT);
        holder.title.setTypeface(typeface);
        holder.address.setTypeface(typeface);
        holder.time.setTypeface(typeface);

        return convertView;
    }


}
