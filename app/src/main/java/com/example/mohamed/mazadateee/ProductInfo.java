package com.example.mohamed.mazadateee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mohamed.mazadateee.ViewHolders.ProductInfoAdapter;
import com.example.mohamed.mazadateee.ViewHolders.auctionAdapter;

public class ProductInfo extends AppCompatActivity {


    RecyclerView recyclerView;
    ProductInfoAdapter adabter;


    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_info);

        id = getIntent().getStringExtra("id");


        recyclerView = (RecyclerView) findViewById(R.id.recyclelist);


        String[] namesphone = {" Tecno Sparidsk 2", "Infinix X604", "Gionee"};
        String[] idsphone = {"TecnoSpark2", "InfinixX604", "Gionee"};
        int[] imagesphone = {R.drawable.tecnospark, R.drawable.infinx, R.drawable.gionee};


        String[] namesTv = {"Asus", "Samsung", "lg"};
        String[] idsTv = {"Asus", "Samsung", "lg"};
        int[] imagesTv = {R.drawable.asus, R.drawable.samsung, R.drawable.lg};


        String[] namesLab = {"Hp Spectre Laptop", " LENOVO", "DELL"};
        String[] idsLab = {"HP", "LENOVO", "dell"};
        int[] imagesLab = {R.drawable.hp, R.drawable.lenovo, R.drawable.dell};


        String[] namesCards = {"PKI", "Jinco", "Smart card"};
        String[] idsCards = {"pki", "Jinco", "smart"};
        int[] imagesCards = {R.drawable.kpi, R.drawable.jinco, R.drawable.smart};



        switch (id) {
            case "phones":
                adabter = new ProductInfoAdapter(this, idsphone, namesphone, imagesphone);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                recyclerView.setAdapter(adabter);
                break;

            case "tv":
                adabter = new ProductInfoAdapter(this, idsTv, namesTv, imagesTv);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                recyclerView.setAdapter(adabter);
                break;

            case "lab":
                adabter = new ProductInfoAdapter(this, idsLab, namesLab, imagesLab);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                recyclerView.setAdapter(adabter);
                break;

            case "card":
                adabter = new ProductInfoAdapter(this, idsCards, namesCards, imagesCards);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                recyclerView.setAdapter(adabter);
                break;
        }



    }
}
