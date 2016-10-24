package edu.temple.lab6;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Dev on 10/24/16.
 */

public class CustomAdapter extends BaseAdapter {
    Context context;
    String[] items;

    public CustomAdapter (Context context, String[] items){
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int position) {
        return items[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView l = new TextView(context);
        
        l.setText(items[position]);
        l.setTextSize(20);
        l.setPadding(16, 25, 16, 25);
        l.setBackgroundColor(getColor(position));

        return l;
    }
    // Returns an integer value for the string value of the colour.
    private int getColor(int position){

        if(items[position].equals("Red") || items[position].equals("Rojo")){
            return Color.RED;
        }
        else if(items[position].equals("Blue") || items[position].equals("Azul")){
            return Color.BLUE;
        }
        else if (items[position].equals("Green") || items[position].equals("Verde")){
            return Color.GREEN;
        }
        else if(items[position].equals("White") ||items[position].equals("Blanco")){
            return Color.WHITE;
        }
        return Color.YELLOW;
    }

}
