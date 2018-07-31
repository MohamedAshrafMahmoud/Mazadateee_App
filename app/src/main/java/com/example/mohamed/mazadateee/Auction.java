package com.example.mohamed.mazadateee;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.mohamed.mazadateee.ViewHolders.auctionAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class Auction extends Fragment {


    RecyclerView recyclerView;
    auctionAdapter adabter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_auction, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.recyclelist);


        String[] names = {"الاجهزه المحموله", "شاشات التلفزيون", "كمبيوتر ولاب توب", "الكروت"};
        String[] ids = {"phones", "tv", "lab", "card"};
        int[] images = {R.drawable.ic_smartphone_black_24dp, R.drawable.ic_desktop_mac_black_24dp, R.drawable.ic_laptop_mac_black_24dp, R.drawable.ic_payment_black_24dp};


        adabter = new auctionAdapter(getContext(), ids,names,images);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
        recyclerView.setAdapter(adabter);


        return view;
    }

}
