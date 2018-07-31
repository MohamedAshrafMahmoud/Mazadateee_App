package com.example.mohamed.mazadateee;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mohamed.mazadateee.Common.Common;
import com.example.mohamed.mazadateee.ViewHolders.ProductInfoAdapter;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ProductDetails extends AppCompatActivity {

    String id, name;
    public TextView productName, price, start, notes, discount, monthes, fulldiscount, insuranceprice, done;

    TextView time;

    RelativeLayout rootlayout;
    int timeSec;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_details);

        id = getIntent().getStringExtra("Id");
        name = getIntent().getStringExtra("Name");

        productName = (TextView) findViewById(R.id.etname);
        price = (TextView) findViewById(R.id.سعر1);
        start = (TextView) findViewById(R.id.المزاد1);
        notes = (TextView) findViewById(R.id.الشروط1);
        discount = (TextView) findViewById(R.id.تقسيط1);
        monthes = (TextView) findViewById(R.id.الاشهر1);
        fulldiscount = (TextView) findViewById(R.id.الشهري1);
        insuranceprice = (TextView) findViewById(R.id.التأمين1);
        done = (TextView) findViewById(R.id.اشترك);
        rootlayout = (RelativeLayout) findViewById(R.id.rootlayout);

        time=(TextView)findViewById(R.id.time);

        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());

        time.setText(currentDateTimeString);

        switch (id) {

            case "TecnoSpark2":

                productName.setText(name);
                price.setText("1000  جنيه");
                start.setText("500");
                notes.setText("50");
                discount.setText("نعم");
                monthes.setText("24");
                fulldiscount.setText("100");
                insuranceprice.setText("500");

                break;

            case "InfinixX604":

                productName.setText(name);
                price.setText("1200 جنيه");
                start.setText("500");
                notes.setText("50");
                discount.setText("نعم");
                monthes.setText("24");
                fulldiscount.setText("100");
                insuranceprice.setText("500");

                break;

            case "Gionee":

                productName.setText(name);
                price.setText("1300  جنيه");
                start.setText("600");
                notes.setText("50");
                discount.setText("لا");
                monthes.setText("0");
                fulldiscount.setText("0");
                insuranceprice.setText("500");

                break;

            case "Asus":

                productName.setText(name);
                price.setText("5000  جنيه");
                start.setText("1500");
                notes.setText("50");
                discount.setText("نعم");
                monthes.setText("24");
                fulldiscount.setText("100");
                insuranceprice.setText("500");

                break;

            case "Samsung":

                productName.setText(name);
                price.setText("4000  جنيه");
                start.setText("1000");
                notes.setText("50");
                discount.setText("لا");
                monthes.setText("0");
                fulldiscount.setText("0");
                insuranceprice.setText("500");

                break;

            case "lg":

                productName.setText(name);
                price.setText("3000 جنيه");
                start.setText("1000");
                notes.setText("50");
                discount.setText("نعم");
                monthes.setText("24");
                fulldiscount.setText("100");
                insuranceprice.setText("500");

                break;

            case "HP":

                productName.setText(name);
                price.setText("7000  جنيه");
                start.setText("3000");
                notes.setText("50");
                discount.setText("نعم");
                monthes.setText("24");
                fulldiscount.setText("100");
                insuranceprice.setText("500");

                break;

            case "LENOVO":

                productName.setText(name);
                price.setText("4000  جنيه");
                start.setText("2000");
                notes.setText("50");
                discount.setText("لا");
                monthes.setText("0");
                fulldiscount.setText("0");
                insuranceprice.setText("500");

                break;

            case "dell":

                productName.setText(name);
                price.setText("8000  جنيه");
                start.setText("4000");
                notes.setText("50");
                discount.setText("نعم");
                monthes.setText("24");
                fulldiscount.setText("100");
                insuranceprice.setText("500");

                break;

            case "pki":

                productName.setText(name);
                price.setText("1000  جنيه");
                start.setText("500");
                notes.setText("50");
                discount.setText("نعم");
                monthes.setText("24");
                fulldiscount.setText("100");
                insuranceprice.setText("500");

                break;

            case "Jinco":

                productName.setText(name);
                price.setText("1000  جنيه");
                start.setText("500");
                notes.setText("50");
                discount.setText("نعم");
                monthes.setText("24");
                fulldiscount.setText("100");
                insuranceprice.setText("500");

                break;

            case "smart":

                productName.setText(name);
                price.setText("1000  جنيه");
                start.setText("500");
                notes.setText("50");
                discount.setText("نعم");
                monthes.setText("24");
                fulldiscount.setText("100");
                insuranceprice.setText("500");

                break;
        }


        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final int wallet = Common.currentUser.getBalance();

                if (wallet <= 0) {
                    Toast.makeText(ProductDetails.this, "عفوا رصيدك لا يكفي", Toast.LENGTH_SHORT).show();
                    Toast.makeText(ProductDetails.this, "بالرجاء شحن رصيدك", Toast.LENGTH_LONG).show();

                    AlertDialog.Builder builder = new AlertDialog.Builder(ProductDetails.this);
                    builder.setMessage(" شحن الرصيد");

                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(ProductDetails.this,edit_Profile.class);
                            startActivity(intent);
                        }
                    });
                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });

                    builder.show();


                } else {


                    AlertDialog.Builder builder = new AlertDialog.Builder(ProductDetails.this);


                    LayoutInflater inflater = ProductDetails.this.getLayoutInflater();
                    View view = inflater.inflate(R.layout.discountmoney, null);

                    builder.setView(view);

                    final TextView entre = (TextView) view.findViewById(R.id.entre);
                    final TextView money = (TextView) view.findViewById(R.id.money);
                    final Button makedone = (Button) view.findViewById(R.id.done);

                    final int Start = Integer.parseInt(start.getText().toString());
                    final int Notes = Integer.parseInt(notes.getText().toString());
                    final int Insuranceprice = Integer.parseInt(insuranceprice.getText().toString());

                    entre.setText("رسم دخول المزاد "+Notes);
                    money.setText(" اشترك الان في المنتج ب "+Start);

                    makedone.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if ((Start + Notes + Insuranceprice) > wallet) {

                                Toast.makeText(ProductDetails.this, "عفوا رصيدك لا يكفي", Toast.LENGTH_SHORT).show();
                                Toast.makeText(ProductDetails.this, "" + (Start + Notes + Insuranceprice), Toast.LENGTH_LONG).show();

                                AlertDialog.Builder builder = new AlertDialog.Builder(ProductDetails.this);
                                builder.setMessage(" شحن الرصيد");

                                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent intent = new Intent(ProductDetails.this,edit_Profile.class);
                                        startActivity(intent);
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


                                Toast.makeText(ProductDetails.this, "done", Toast.LENGTH_SHORT).show();
                                Toast.makeText(ProductDetails.this, "رصيدك الحالي"+Common.currentUser.getBalance(), Toast.LENGTH_LONG).show();

                                Thread thread = new Thread() {
                                    @Override
                                    public void run() {
                                        timeSec = 10000;
                                        try {
                                            sleep(timeSec);


                                        } catch (Exception e) {
                                            // TODO: handle exception
                                            e.printStackTrace();
                                        } finally {

                                            runOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {

                                                    done.setText("بانتظار بدا المزايده");
                                                   done.setEnabled(false);


                                                }
                                            });

                                        }
                                    }
                                };

                                thread.start();



                            }

                        }
                    });


                   builder.show();
                }


            }
        });


    }
}
