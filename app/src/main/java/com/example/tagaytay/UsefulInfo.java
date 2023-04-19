package com.example.tagaytay;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class UsefulInfo extends Base {

    //variables
    ImageView embassies;
    ImageView police;
    ImageView fire;
    ImageView weather;
    ImageView hospitals;
    TextView embassyText;
    TextView directoryText;
    TextView weatherText;
    TextView hospitalText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_useful_info);

        //Create all widget objects
        embassies = findViewById(R.id.embassies);
        hospitals = findViewById(R.id.hospitals);
        weather = findViewById(R.id.weather);
        police = findViewById(R.id.police_icon);
        fire = findViewById(R.id.fire_icon);
        embassyText = findViewById(R.id.embassies_text);
        directoryText = findViewById(R.id.dir_text);
        weatherText = findViewById(R.id.weather_text);
        hospitalText = findViewById(R.id.hosp_text);


        //OnClickListeners

        //If the embassies ImageView/TextView is clicked, the user will be directed to the Embassy Activity
        embassies.setOnClickListener(view -> {
            Intent intent = new Intent(UsefulInfo.this, Embassy.class);
            startActivity(intent);
        });

        embassyText.setOnClickListener(view -> {
            Intent intent = new Intent(UsefulInfo.this, Embassy.class);
            startActivity(intent);
        });

        //If the police/fire ImageView ic clicked, the user will be directed to the Directory Activity
        police.setOnClickListener(view -> {
            Intent intent = new Intent(UsefulInfo.this, Directory.class);
            startActivity(intent);
        });

        fire.setOnClickListener(view -> {
            Intent intent = new Intent(UsefulInfo.this, Directory.class);
            startActivity(intent);
        });


         //If the directory TextView ic clicked, the user will be directed to the Directory Activity
        directoryText.setOnClickListener(view -> {
            Intent intent = new Intent(UsefulInfo.this, Directory.class);
            startActivity(intent);
        });

        //If the weather TextView/ImageView is clicked, the user will be directed to the Directory Activity
        weatherText.setOnClickListener(view -> {
            Uri web = Uri.parse("https://www.accuweather.com/en/ph/tagaytay-city/262695/weather-forecast/262695");
            Intent intent = new Intent(Intent.ACTION_VIEW, web);
            startActivity(intent);
        });

        weather.setOnClickListener(view -> {
            Uri web = Uri.parse("https://www.accuweather.com/en/ph/tagaytay-city/262695/weather-forecast/262695");
            Intent intent = new Intent(Intent.ACTION_VIEW, web);
            startActivity(intent);
        });

        //If the hospital TextView/ImageView is clicked, the user will be directed to the Embassy Activity
        hospitalText.setOnClickListener(view -> {
            Intent intent = new Intent(UsefulInfo.this, Hospital.class);
            startActivity(intent);
        });

        hospitals.setOnClickListener(view -> {
            Intent intent = new Intent(UsefulInfo.this, Hospital.class);
            startActivity(intent);
        });


    }

}