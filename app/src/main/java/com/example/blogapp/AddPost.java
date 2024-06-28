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

public class AddPost extends AppCompatActivity {

    EditText ed1,ed2,ed3;
    AppCompatButton b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_post);
        ed1=(EditText) findViewById(R.id.addtitle) ;
        ed2=(EditText) findViewById(R.id.adddescrip) ;
        ed3=(EditText) findViewById(R.id.addkeyw) ;
        b1=(AppCompatButton) findViewById(R.id.btn_add);
        b2=(AppCompatButton) findViewById(R.id.addbacktomenubtn);
        b3=(AppCompatButton) findViewById(R.id.logoutaddbtn);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String getTitle=ed1.getText().toString();
                    String getDescrip=ed2.getText().toString();
                    String getKeyw=ed3.getText().toString();

                    if(getTitle.isEmpty()&&getDescrip.isEmpty())
                        Toast.makeText(getApplicationContext(),"Please enter the title and description",Toast.LENGTH_SHORT).show();
                    else if(!getTitle.isEmpty()&&getDescrip.isEmpty())
                        Toast.makeText(getApplicationContext(),"Please enter the description",Toast.LENGTH_SHORT).show();
                    else if(getTitle.isEmpty()&& !getDescrip.isEmpty())
                        Toast.makeText(getApplicationContext(),"Please enter the title",Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(getApplicationContext(),"Post with title '"+getTitle+"'\nAdded to blog",Toast.LENGTH_SHORT).show();
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