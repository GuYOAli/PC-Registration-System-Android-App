package com.example.pcregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class StudentRegistration extends AppCompatActivity {
    private Button buton;
    private static final int Camera_Request = 123;
    ImageView imaage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_registration);
        buton = (Button) findViewById(R.id.btn);
        imaage = (ImageView) findViewById(R.id.image);
    }

    public void btnClick(View V) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, Camera_Request);
    }

    public void onActivityResult(int requestCode, int resultcode, Intent data) {
        if (requestCode == Camera_Request && resultcode == Activity.RESULT_OK) {
            Bitmap phot = (Bitmap) data.getExtras().get("data");
            imaage.setImageBitmap(phot);
        }
    }
}
