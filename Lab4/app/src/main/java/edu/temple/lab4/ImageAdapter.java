package edu.temple.lab4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter {
    private Context context; //context
    private ArrayList<Integer> items; //data source of the list adapter
    private ArrayList<Integer> pics;
    private static LayoutInflater inflater=null;

    public ImageAdapter(Context context, ArrayList<Integer> items, ArrayList<Integer> pics) {
        this.context = context;
        this.items = items;
        this.pics = pics;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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

    public class Holder
    {
        TextView tv;
        ImageView img;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder=new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.item_layout, null);

        ImageView imageView;
        if (convertView == null) {
            holder.tv=(TextView) rowView.findViewById(R.id.textView1);
            holder.img=(ImageView) rowView.findViewById(R.id.imageView1);

            holder.tv.setText(items.get(position));
            holder.img.setImageResource(pics.get(position));

            //holder.img.setLayoutParams(new ViewGroup.LayoutParams(200, 200));
            holder.img.setScaleType(ImageView.ScaleType.CENTER_CROP);
            holder.img.setPadding(8, 8, 8, 8);

        }
        else {
            rowView = convertView;
        }

        return rowView;
    }

}