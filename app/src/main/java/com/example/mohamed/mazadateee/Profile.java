package com.example.mohamed.mazadateee;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mohamed.mazadateee.Common.Common;


/**
 * A simple {@link Fragment} subclass.
 */
public class Profile extends Fragment {


    FloatingActionButton edit;
    ImageView user;
    TextView name,account,phone,ssn, balance,adress, الفواتير , التامين;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_profile, container, false);


        edit =(FloatingActionButton)view.findViewById(R.id.btnrate);
        الفواتير=(TextView)view.findViewById(R.id.الفواتير);
        التامين=(TextView) view.findViewById(R.id.التامين);
        user =(ImageView)view.findViewById(R.id.imageprofile);
        name=(TextView)view.findViewById(R.id.name1);
        account=(TextView)view.findViewById(R.id.الايميل1);
        phone=(TextView)view.findViewById(R.id.الرقم1);
        ssn=(TextView)view.findViewById(R.id.الموبيل1);
        balance =(TextView)view.findViewById(R.id.الرصيد1);
        adress=(TextView)view.findViewById(R.id.العنوان1);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),edit_Profile.class));
            }
        });



        name.setText(Common.currentUser.getName());
        account.setText(Common.currentUser.getAccount());
        phone.setText(Common.currentUser.getPhone());
        ssn.setText(Common.currentUser.getSsn());
        balance.setText((Common.currentUser.getBalance())+"");
        adress.setText(Common.currentUser.getAdress());


return view;

    }

}
