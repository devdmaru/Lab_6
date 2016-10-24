package edu.temple.lab6;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PaletteFragment extends Fragment {

    public static final String dataKey = "bundle_data_key";

    private OnFragmentInteractionListener message;

    public PaletteFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_palette, container, false);

        ListView listView = (ListView) v.findViewById(R.id.palListView);

        listView.setAdapter(new CustomAdapter(getActivity(), getArguments().getStringArray(dataKey)));

        listView.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                message.displayColor(((TextView) view).getText().toString(), position);
            }
        });

        return v;
    }

    @Override
    public void onAttach(Context c) {
        super.onAttach(c);

        Activity a;
        if (c instanceof Activity){
            a=(Activity) c;
            message = (OnFragmentInteractionListener) a;
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
        message = null;
    }

    //Interface for message communication
    public interface OnFragmentInteractionListener {
        void displayColor(String colorName, int position);
    }

}
