package com.example.mohamed.mazadateee.ViewHolders;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mohamed.mazadateee.ProductInfo;
import com.example.mohamed.mazadateee.R;
import com.example.mohamed.mazadateee.models.product;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * Created by 7aSSan on 4/20/2018.
 */

public class auctionAdapter extends RecyclerView.Adapter<auctionAdapter.ViewHolder> {


    public static class ViewHolder extends RecyclerView.ViewHolder {


        TextView id, name;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id);
            name = itemView.findViewById(R.id.category);
            imageView = itemView.findViewById(R.id.image);


        }

    }


    public Context context;


    String ids[];
    String names[];
    int images[];



    public auctionAdapter(Context context, String ids[], String names [], int images[]) {
        this.context = context;
        this.ids = ids;
        this.names = names;
        this.images = images;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.item_product, null);
        return new auctionAdapter.ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {


        holder.id.setText(ids[position]);
        holder.name.setText(names[position]);
        holder.imageView.setImageResource(images[position]);



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, ProductInfo.class);
                i.putExtra("id", ids[position]);

                context.startActivity(i);
            }
        });


    }


    @Override
    public int getItemCount() {
        return ids.length;
    }


}
