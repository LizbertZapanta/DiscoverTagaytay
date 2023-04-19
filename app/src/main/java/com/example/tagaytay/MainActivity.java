package com.example.tagaytay;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.firebase.analytics.FirebaseAnalytics;


public class MainActivity extends Base {

    //Declare variables
    ImageView shopping = null;
    ImageView travel = null;
    ImageView night = null;
    ImageView dining = null;
    ImageView coffeebreak = null;
    ImageView info = null;
    TextView travelText = null;
    TextView nightText = null;
    TextView diningText = null;
    TextView coffeebreakText = null;
    TextView infoText = null;
    TextView shoppingText = null;

    //Firebase Analytics
    private FirebaseAnalytics mFirebaseAnalytics;

    //adMob
    private static final String TAG = "MainActivity";
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ºAdMob snippet
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {
            }
        });

        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        //Create all widget objects
        dining = findViewById(R.id.food_dining);
        night = findViewById(R.id.nightlife);
        coffeebreak = findViewById(R.id.coffee);
        travel = findViewById(R.id.travel);
        shopping = findViewById(R.id.shopping);
        info = findViewById(R.id.info);
        travelText = findViewById(R.id.explore);
        nightText = findViewById(R.id.party);
        coffeebreakText = findViewById(R.id.coffee_break);
        diningText = findViewById(R.id.dining);
        infoText = findViewById(R.id.useful_info);
        shoppingText = findViewById(R.id.shop);

        //onClickListeners

        //When the travel ImageView/TextView is clicked, the user will be directed to the Explore Activity
        travel.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Explore.class);
            startActivity(intent);
        });

        travelText.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Explore.class);
            startActivity(intent);
        });


        //When the NightLife ImageView/TextView is clicked, the user will be directed to the Night Activity
        night.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Night.class);
            startActivity(intent);
        });

        nightText.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Night.class);
            startActivity(intent);
        });


        //When the Coffee ImageView/TextView is clicked, the user will be directed to the Coffee Activity
        coffeebreak.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Coffee.class);
            startActivity(intent);
        });

        coffeebreakText.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Coffee.class);
            startActivity(intent);
        });


        //When the Dining ImageView/TextView is clicked, the user will be directed to the Dining Activity
        dining.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Dining.class);
            startActivity(intent);
        });

        diningText.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Dining.class);
            startActivity(intent);
        });


        //When the Useful Info ImageView/TextView is clicked, the user will be directed to the UsefulInfo Activity
        info.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, UsefulInfo.class);
            startActivity(intent);
        });

        infoText.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, UsefulInfo.class);
            startActivity(intent);
        });

        //When the Shopping ImageView/TextView is clicked, the user will be directed to the Shopping Activity
        shopping.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Shopping.class);
            startActivity(intent);
        });

        shoppingText.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Shopping.class);
            startActivity(intent);
        });

    }


}