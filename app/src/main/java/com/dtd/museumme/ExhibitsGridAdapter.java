package com.dtd.museumme;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Egor on 28.03.2015.
 */
public class ExhibitsGridAdapter extends ArrayAdapter<Exhibit> {

    Context mContext;
    //ArrayList<ArrayList<News>> videos;
    ArrayList<Exhibit> exhibit;

    //public NewsAdapter(Context context, ArrayList<ArrayList<News>> videos) {
    public ExhibitsGridAdapter(Context context, ArrayList<Exhibit> exhibit) {
        super(context, R.layout.exhibit_item, exhibit);
        this.mContext = context;
        this.exhibit = exhibit;

    }


    static class ViewHolder {
        ImageView img;
        TextView title;
    }

    public View getView(final int position, View convertView, final ViewGroup parent) {

        ViewHolder holder;
        if(convertView==null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.exhibit_item, parent, false);
            holder.img = (ImageView) convertView.findViewById(R.id.img);
            holder.title = (TextView) convertView.findViewById(R.id.title);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }


        int id = mContext.getResources().getIdentifier("contentexample_" + String.valueOf(position + 1) , "drawable", mContext.getPackageName());

        holder.img.setImageResource(id);

        holder.title.setText(exhibit.get(position).getTitleExhibit());
        //holder.img.setImageResource();


        return convertView;
    }
}
