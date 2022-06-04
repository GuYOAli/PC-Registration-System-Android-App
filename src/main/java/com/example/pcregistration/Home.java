package com.example.pcregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {
     private Button regist;
     private Button search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        regist=(Button)findViewById(R.id.reg);
        search=(Button)findViewById(R.id.srch);
        regist.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                home();
            }
        });
    }
    private void home(){
        Intent intent = new Intent(Home.this,StudentRegistration.class);
        startActivity(intent);
    }
}
