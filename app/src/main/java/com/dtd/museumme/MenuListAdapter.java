package com.dtd.museumme;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Egor on 28.03.2015.
 */
public class MenuListAdapter extends ArrayAdapter<String> {

    Context context;

    public MenuListAdapter(Context context, int resourceId, List<String> items){
        super(context, resourceId, items);
        this.context = context;
    }

    private class ViewHolder{
        TextView tv;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder = null;
        String menuItem = getItem(position);

        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if(convertView == null){
            convertView = mInflater.inflate(R.layout.menu_list_item, null);
            holder = new ViewHolder();
            holder.tv = (TextView) convertView.findViewById(R.id.tv);
            convertView.setTag(holder);
        }else
            holder = (ViewHolder) convertView.getTag();

        holder.tv.setText(menuItem);

        return convertView;
    }

}
