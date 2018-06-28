package id.slametriyadi.wisataindonesia.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.slametriyadi.wisataindonesia.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PantaiFragment extends Fragment {


    public PantaiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pantai, container, false);
    }

}
