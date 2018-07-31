package com.example.mohamed.mazadateee.ViewHolders;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mohamed.mazadateee.Common.Common;
import com.example.mohamed.mazadateee.ProductDetails;
import com.example.mohamed.mazadateee.ProductInfo;
import com.example.mohamed.mazadateee.R;
import com.example.mohamed.mazadateee.edit_Profile;


/**
 * Created by 7aSSan on 4/20/2018.
 */

public class ProductInfoAdapter extends RecyclerView.Adapter<ProductInfoAdapter.ViewHolder> {


    public static class ViewHolder extends RecyclerView.ViewHolder {


        TextView id, name,details;
        ImageView imageView;
        Button begin;
        RelativeLayout rootlayout;

        public ViewHolder(View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id);
            name = itemView.findViewById(R.id.name);
            details = itemView.findViewById(R.id.details);
            imageView = itemView.findViewById(R.id.image);
            begin = itemView.findViewById(R.id.begin);
            rootlayout = itemView. findViewById(R.id.rootlayout);



        }

    }


    public Context context;


    String ids[];
    String names[];
    int images[];


    public ProductInfoAdapter(Context context, String ids[], String names [], int images[]) {
        this.context = context;
        this.ids = ids;
        this.names = names;
        this.images = images;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.item_info, null);
        return new ProductInfoAdapter.ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {


        holder.id.setText(ids[position]);
        holder.name.setText(names[position]);
        holder.imageView.setImageResource(images[position]);



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, ProductDetails.class);
                i.putExtra("Id", ids[position]);
                i.putExtra("Name", names[position]);
                context.startActivity(i);
            }
        });


        holder.begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final int wallet = Common.currentUser.getBalance();

                if (wallet <= 0) {
                    Toast.makeText(context, "عفوا رصيدك لا يكفي", Toast.LENGTH_SHORT).show();
                    Toast.makeText(context, "بالرجاء شحن رصيدك", Toast.LENGTH_LONG).show();





                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setMessage(" شحن الرصيد");

                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(context,edit_Profile.class);
                            context.startActivity(intent);
                        }
                    });
                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });

                    builder.show();


                } else {


                    AlertDialog.Builder builder = new AlertDialog.Builder(context);


                    View view = LayoutInflater.from(context).inflate(R.layout.discountmoney, null);

                    builder.setView(view);

                    final TextView entre = (TextView) view.findViewById(R.id.entre);
                    final TextView money = (TextView) view.findViewById(R.id.money);
                    final Button makedone = (Button) view.findViewById(R.id.done);

                    final int Start = 1000;
                    final int Notes = 50;
                    final int Insuranceprice = 500;

                    entre.setText("رسم دخول المزاد "+Notes);
                    money.setText(" اشترك الان في المنتج ب "+Start);

                    makedone.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if ((Start + Notes + Insuranceprice) > wallet) {

                                Toast.makeText(context, "عفوا رصيدك لا يكفي", Toast.LENGTH_SHORT).show();
                                Toast.makeText(context, "" + (Start + Notes + Insuranceprice), Toast.LENGTH_SHORT).show();


                                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                                builder.setMessage(" شحن الرصيد");

                                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent intent = new Intent(context,edit_Profile.class);
                                        context.startActivity(intent);
                                    }
                                });
                                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                });

                                builder.show();


                            } else {
                                Common.currentUser.setBalance(wallet - (Start + Notes + Insuranceprice));

                                Toast.makeText(context, "done", Toast.LENGTH_SHORT).show();
                                Toast.makeText(context, "رصيدك الحالي"+Common.currentUser.getBalance(), Toast.LENGTH_LONG).show();
                            }

                        }
                    });


                    builder.show();
                }

            }
        });


    }


    @Override
    public int getItemCount() {
        return ids.length;
    }


}
