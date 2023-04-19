package com.example.tagaytay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Directory extends AppCompatActivity {

    ImageView police_icon;
    ImageView fire_icon;
    TextView policeText;
    TextView fireText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directory);

        police_icon = findViewById(R.id.policeStation);
        fire_icon = findViewById(R.id.fireStation);
        policeText = findViewById(R.id.policeStation_text);
        fireText = findViewById(R.id.fireStation_text);


        //When the Police ImageView/TextView is clicked, it will take the user to the Cavite province police station directory uri
        policeText.setOnClickListener(view -> {
            Uri police_web = Uri.parse("https://cavite.gov.ph/home/province/general-information/directory/police-stations/");
            Intent intent = new Intent(Intent.ACTION_VIEW, police_web);
            startActivity(intent);
        });

        police_icon.setOnClickListener(view -> {
            Uri police_web = Uri.parse("https://cavite.gov.ph/home/province/general-information/directory/police-stations/");
            Intent intent = new Intent(Intent.ACTION_VIEW, police_web);
            startActivity(intent);
        });


        //When the Fire Station ImageView / TextView is clicked, it will take the user to the Cavite province fire station directory website
        fireText.setOnClickListener(view -> {
            Uri fire_web = Uri.parse("https://cavite.gov.ph/home/province/general-information/directory/fire-stations/");
            Intent intent = new Intent(Intent.ACTION_VIEW, fire_web);
            startActivity(intent);
        });

        fire_icon.setOnClickListener(view -> {
            Uri fire_web = Uri.parse("https://cavite.gov.ph/home/province/general-information/directory/fire-stations/");
            Intent intent = new Intent(Intent.ACTION_VIEW, fire_web);
            startActivity(intent);
        });



    }
}