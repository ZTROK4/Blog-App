package com.example.blogapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignUpPage extends AppCompatActivity {

    EditText ed1,ed2,ed3,ed4,ed5,ed6,ed7;
    AppCompatButton b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up_page);
        ed1=(EditText) findViewById(R.id.name);
        ed2=(EditText) findViewById(R.id.date);
        ed3=(EditText) findViewById(R.id.email);
        ed4=(EditText) findViewById(R.id.phNo);
        ed5=(EditText) findViewById(R.id.enterusername);
        ed6=(EditText) findViewById(R.id.enterpass);
        ed7=(EditText) findViewById(R.id.enterpassConfirm);
        b1=(AppCompatButton) findViewById(R.id.signupbtn);
        b2=(AppCompatButton) findViewById(R.id.tosignnbtn);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getName=ed1.getText().toString();
                String getRollno=ed2.getText().toString();
                String getSem=ed3.getText().toString();
                String getClasOfStudy=ed4.getText().toString();
                String readUsername=ed5.getText().toString();
                String readPass=ed6.getText().toString();
                String readPassConfirm=ed7.getText().toString();

                if(readPass.equals(readPassConfirm))
                    Toast.makeText(getApplicationContext(),"Succesfully Resgistered\nWelcome "+getName+"\nContinue to Signin",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplicationContext(),"Passwords Should match\nRe-enter your password",Toast.LENGTH_LONG).show();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }
}