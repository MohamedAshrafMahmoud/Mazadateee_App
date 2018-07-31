package com.example.mohamed.mazadateee;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mohamed.mazadateee.Common.Common;

import java.io.IOException;

public class edit_Profile extends AppCompatActivity {

    FloatingActionButton take;
    ImageView user;
    EditText name,account,phone,ssn, balance,adress;
    TextView done;

    private final int pickImageRequest = 71;
    Uri saveuri;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit__profile);

        take=(FloatingActionButton)findViewById(R.id.btntake);
        user =(ImageView)findViewById(R.id.imageprofile);
        name=(EditText) findViewById(R.id.name1);
        account=(EditText)findViewById(R.id.الايميل1);
        phone=(EditText)findViewById(R.id.الرقم1);
        ssn=(EditText)findViewById(R.id.الموبيل1);
        balance =(EditText)findViewById(R.id.الرصيد1);
        adress=(EditText)findViewById(R.id.العنوان1);
        done=(TextView)findViewById(R.id.done);


        name.setText(Common.currentUser.getName());
        account.setText(Common.currentUser.getAccount());
        phone.setText(Common.currentUser.getPhone());
        ssn.setText(Common.currentUser.getSsn());
        balance.setText((Common.currentUser.getBalance())+"");
        adress.setText(Common.currentUser.getAdress());

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Common.currentUser.setName(name.getText().toString());
                Common.currentUser.setAccount(account.getText().toString());
                Common.currentUser.setPhone(phone.getText().toString());
                Common.currentUser.setSsn(ssn.getText().toString());
                Common.currentUser.setBalance(Integer.parseInt(balance.getText().toString()));
                Common.currentUser.setAdress(adress.getText().toString());

                Toast.makeText(edit_Profile.this, "done", Toast.LENGTH_SHORT).show();
            }
        });

        take.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChooseImage();
            }
        });


    }




    private void ChooseImage() {

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "select picture"), pickImageRequest);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == pickImageRequest && resultCode == RESULT_OK && data != null && data.getData() != null) {
            saveuri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), saveuri);
                user.setImageBitmap(bitmap);
              //  Common.currentUser.setImage(user.getIma);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
