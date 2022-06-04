package com.example.pcregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //declaring variables
    private EditText name;
    private EditText pass;
    private Button login;
    private int count=5;
    private TextView att;
    private TextView forr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //intializing variables
        name=(EditText)findViewById(R.id.name);
        pass=(EditText)findViewById(R.id.pass);
        login=(Button)findViewById(R.id.btnLogin);
        att=(TextView)findViewById(R.id.atemp);
        forr=(TextView)findViewById(R.id.forget);
        forr.setEnabled(false);
        att.setEnabled(false);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
            }
        });
        forr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                re();
            }
        });
    }
    private void check(){
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading..."); // Setting Message
        progressDialog.setTitle("ProgressDialog"); // Setting Title
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER); // Progress Dialog Style Spinner
        progressDialog.show(); // Display Progress Dialog
        progressDialog.setCancelable(false);
        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                progressDialog.dismiss();
            }
        }).start();
        String username,userpass;
        username=name.getText().toString();
        userpass=pass.getText().toString();
        if(username.equals("Admin")&&userpass.equals("1234")){
            Intent in=new Intent(MainActivity.this,Home.class);
            startActivity(in);
        }
        else{
            count--;
            if(count==4) {
                att.setEnabled(true);
            }
            att.setText("No of attemps remaing :" + String.valueOf(count));
            if(count==0){
                login.setEnabled(false);
                att.setEnabled(false);
                forr.setEnabled(true);
            }
        }
    }
    private void re(){
        Intent intet=new Intent(MainActivity.this,ResetPassword.class);
        startActivity(intet);
    }
}
