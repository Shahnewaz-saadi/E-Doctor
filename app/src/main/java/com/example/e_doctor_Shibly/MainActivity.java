package com.example.e_doctor_Shibly;

import static com.example.e_doctor_Shibly.R.*;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private ImageView phn;
    private ImageView msg;
    private ImageView BMIView;
    private ImageView PregView;
    private ImageView youtube;

    Button clickButton;
    Button appoinment;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);


        // youtube setup

        youtube = findViewById(id.youtube);
        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String videoUrl = "https://www.youtube.com/@dr.md.shiblyshahriar";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(videoUrl));
                intent.setPackage("com.google.android.youtube");
                startActivity(intent);
            }
        });

        //Appoinment Button setup
        appoinment = findViewById(id.appoinment);
        appoinment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Appoinment.class);
                startActivity(i);
            }
        });


//        Button setup
        clickButton = findViewById(id.clickButton);
        clickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });

//        BMI Calculator
        BMIView = findViewById(id.BMIView);
        BMIView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainActivityBMI.class);
                startActivity(intent);

            }
        });



////        pregnency calculator
       PregView = findViewById(id.pregView);
       PregView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this,MainActivityPreCAlc.class);
               startActivity(intent);
           }
       });




//        facebook link set up
        imageView = findViewById(id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String facebookUrl = "https://www.facebook.com/profile.php?id=100086737985104";
                String facebookAppUrl = "fb://facewebmodal/f?href=" + facebookUrl;
                Intent intent = new Intent();
                try {
                    getPackageManager().getPackageInfo("com.facebook.katana",0);
                } catch (Exception e)
                {
                    intent = new Intent(Intent.ACTION_VIEW,Uri.parse(facebookAppUrl));
                }
                startActivity(intent);
            }
        });

//        phone link
        phn = findViewById(id.phn);
        phn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = "+8801744950405";
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+phoneNumber));
                startActivity(intent);
            }
        });

//        message link
        msg =findViewById(id.msg);
        msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  phoneNumber = "+8801744950405";
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("smsto:"+phoneNumber));
                startActivity(intent);
            }
        });
    }
}