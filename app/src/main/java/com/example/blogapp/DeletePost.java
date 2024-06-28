package com.example.blogapp;

import android.content.Intent;
import android.content.SharedPreferences;
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

public class DeletePost extends AppCompatActivity {

    EditText ed;
    AppCompatButton b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_delete_post);
        ed=(EditText) findViewById(R.id.dlttitle) ;
        b1=(AppCompatButton) findViewById(R.id.dltbtn);
        b2=(AppCompatButton) findViewById(R.id.dltbacktomenubtn);
        b3=(AppCompatButton) findViewById(R.id.logoutdltbtn);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String getTitle=ed.getText().toString();
                    if(!getTitle.isEmpty())
                        Toast.makeText(getApplicationContext(),"Post with title '"+getTitle+"' deleted",Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(getApplicationContext(),"Please enter the title",Toast.LENGTH_SHORT).show();
                }
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(), MenuPage.class);
                startActivity(i);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
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