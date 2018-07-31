package com.example.mohamed.mazadateee;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_home, container, false);

//        Toolbar toolbar=(Toolbar)view.findViewById(R.id.toolbar);
//        view.setSupportActionBar(toolbar);
//        if (getSupportActionBar() !=null)
//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        return view;
    }

}
