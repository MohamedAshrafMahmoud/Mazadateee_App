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

public class SignIn extends AppCompatActivity {

    EditText name, password;
    Button log;
    TextView skip, create_one;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);

        name = (EditText) findViewById(R.id.etname);
        password = (EditText) findViewById(R.id.etpass);
        log = (Button) findViewById(R.id.log);
        skip = (TextView) findViewById(R.id.skip);
        create_one = (TextView) findViewById(R.id.createone);


        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignIn.this, MainActivity.class));
            }
        });
        create_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignIn.this, SignUp.class));
            }
        });

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().length() == 0) {
                    name.setError("name required");
                    name.requestFocus();
                } else if (password.getText().toString().length() == 0) {
                    password.setError("password required");
                    password.requestFocus();

                } else {


                    SignUser();

                }
            }
        });


    }

    private void SignUser() {

        Common.currentUser.setName(name.getText().toString());
        Common.currentUser.setPassword(password.getText().toString());



        startActivity(new Intent(SignIn.this, MainActivity.class));


    }
}
