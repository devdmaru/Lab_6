package edu.temple.lab6;


import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CanvasFragment extends Fragment {

    public static final String dataKey = "bundle_data_key";


    public static CanvasFragment newInstance() {
        return new CanvasFragment();
    }

    public CanvasFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_canvas, container, false);

        TextView tv = (TextView) v.findViewById(R.id.canvasText);

        if (getArguments() != null) {

            // Getting the string array and the position of item
            final String[] colourName = getResources().getStringArray(R.array.colours);
            final int position = getArguments().getInt(dataKey);

            // setting the colour based on the colour picked
            if(colourName[position].equals("Red") || colourName[position].equals("Rojo")){
                tv.setBackgroundColor(Color.RED);
            }
            else if(colourName[position].equals("Blue") || colourName[position].equals("Azul")) {
                tv.setBackgroundColor(Color.BLUE);
            }
            else if (colourName[position].equals("Green") || colourName[position].equals("Verde")){
                tv.setBackgroundColor(Color.GREEN);
            }
            else if(colourName[position].equals("Yellow") || colourName[position].equals("Amarillo")) {
                tv.setBackgroundColor(Color.YELLOW);
            }
            else{
                tv.setBackgroundColor(Color.WHITE);
            }

        }
        return v;
    }




}

