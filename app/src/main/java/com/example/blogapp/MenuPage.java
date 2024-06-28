package com.example.blogapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MenuPage extends AppCompatActivity {

    AppCompatButton b1,b2,b3,b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu_page);
        b1=(AppCompatButton) findViewById(R.id.addbtn);
        b2=(AppCompatButton) findViewById(R.id.searchbtn);
        b3=(AppCompatButton) findViewById(R.id.deletebtn);
        b4=(AppCompatButton) findViewById(R.id.logoutmenubtn);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), AddPost.class);
                startActivity(i);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), SearchPost.class);
                startActivity(i);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), DeletePost.class);
                startActivity(i);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences=getSharedPreferences("login",MODE_PRIVATE);
                SharedPreferences.Editor editor= preferences.edit();
                editor.clear();
                editor.apply();
                Intent i=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

    }
}