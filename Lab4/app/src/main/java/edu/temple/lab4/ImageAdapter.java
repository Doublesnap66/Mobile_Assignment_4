package edu.temple.lab4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter {
    private Context context; //context
    private ArrayList<String> items; //data source of the list adapter
    private ArrayList<Integer> pics;

    public ImageAdapter(Context context, ArrayList<String> items, ArrayList<Integer> pics) {
        this.context = context;
        this.items = items;
        this.pics = pics;
    }

    @Override
    public int getCount() {
        return items.size(); //returns total of items in the list
    }

    @Override
    public Object getItem(int position) {
        return items.get(position); //returns list item at the specified position
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.spinner_value_layout, null);
        }

        TextView textView = (TextView) convertView.findViewById(R.id.spinnerTextView);
        textView.setText(items.get(position));

        ImageView imageView = (ImageView) convertView.findViewById(R.id.spinnerImages);
        if (position != 0) {
            imageView.setImageResource(pics.get(position));
        }

        return convertView;
    }

}