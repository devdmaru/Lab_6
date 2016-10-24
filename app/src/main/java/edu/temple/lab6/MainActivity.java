package edu.temple.lab6;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends Activity implements PaletteFragment.OnFragmentInteractionListener {

    boolean twoPanes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  Determine if only one or two panes are visible
        twoPanes = (findViewById(R.id.fragment_canvas) != null);

        //Load navigation fragment by default
        Fragment PaletteFrag = new PaletteFragment();

        //  Place data for the fragment to use.
        Bundle bundle = new Bundle();
        bundle.putStringArray(PaletteFragment.dataKey, getResources().getStringArray(R.array.colours));
        PaletteFrag.setArguments(bundle);

        loadFragment(R.id.fragment_palette, PaletteFrag, false);

        /*
         *  Check if details pain is visible in current layout (e.g. large or landscape)
         *  and load fragment if true.
         */
        if (twoPanes){
            loadFragment(R.id.fragment_canvas, new CanvasFragment(), false);
        }
    }


    //  Load fragment in a specified frame
    private void loadFragment(int paneId, Fragment fragment, boolean placeOnBackstack){
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction()
                .replace(paneId, fragment);
        if (placeOnBackstack)
            ft.addToBackStack(null);
        ft.commit();
        fm.executePendingTransactions();
    }

    @Override
    public void displayColor(String colorName, int position) {
        CanvasFragment canvasFrag = new CanvasFragment();

        Bundle bundle = new Bundle();
        bundle.putString(CanvasFragment.dataKey, colorName);
        bundle.putInt(CanvasFragment.dataKey, position);
        canvasFrag.setArguments(bundle);

        loadFragment(twoPanes ? R.id.fragment_canvas : R.id.fragment_palette, canvasFrag, !twoPanes);
    }

}
