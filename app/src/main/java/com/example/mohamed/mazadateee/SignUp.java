package com.example.mohamed.mazadateee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mohamed.mazadateee.Common.Common;
import com.example.mohamed.mazadateee.models.User;

public class SignUp extends AppCompatActivity {


    EditText name, password,email,userName;
    TextView skip,sign;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        name = (EditText) findViewById(R.id.etname);
        password = (EditText) findViewById(R.id.etpass);
        email = (EditText) findViewById(R.id.etemail);
        userName = (EditText) findViewById(R.id.name);
        skip = (TextView) findViewById(R.id.skip);
        sign = (TextView) findViewById(R.id.signUp);


        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUp.this, MainActivity.class));
            }
        });



        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().length() == 0) {
                    name.setError("name required");
                    name.requestFocus();
                } else if (password.getText().toString().length() == 0) {
                    password.setError("password required");
                    password.requestFocus();

                } else if (email.getText().toString().length() == 0) {
                    email.setError("email required");
                    email.requestFocus();

                } else if (userName.getText().toString().length() == 0) {
                    userName.setError("username required");
                    userName.requestFocus();

                } else   {


                    SignUser();

                }
            }
        });



    }

    private void SignUser() {

        Common.currentUser.setName(name.getText().toString());
        Common.currentUser.setUserName(userName.getText().toString());
        Common.currentUser.setEmail(email.getText().toString());
        Common.currentUser.setPassword(password.getText().toString());

        startActivity(new Intent(SignUp.this,MainActivity.class));


    }
}
