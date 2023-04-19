package com.example.tagaytay;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Explore extends Base {
    ImageView family = null;
    ImageView romantic = null;
    ImageView wellness = null;
    ImageView nature = null;
    TextView familyText = null;
    TextView romanticText = null;
    TextView wellnessText = null;
    TextView natureText = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);

        //Create widget objects
        wellness = findViewById(R.id.health_wellness);
        family = findViewById(R.id.family_friendly);
        romantic = findViewById(R.id.romantic_getaways);
        nature = findViewById(R.id.nature_trips);
        wellnessText = findViewById(R.id.health_text);
        familyText = findViewById(R.id.ff_text);
        romanticText = findViewById(R.id.romantic_text);
        natureText = findViewById(R.id.nature_text);

        //onClickListeners

        /* When Family-Friendly ImageView/TextView is clicked, the user will be directed
        to MyChoice Activity with a list of places of interest suitable for families
         */
        familyText.setOnClickListener(view -> {
            Intent intent = new Intent(Explore.this, family_friendly.class);
            startActivity(intent);
        });

        family.setOnClickListener(view -> {
            Intent intent = new Intent(Explore.this, family_friendly.class);
            startActivity(intent);
        });


        /* When Health and Wellness ImageView/TextView is clicked, the user will be directed
        to MyChoice Activity with a list of places of interest suitable for Serene and Relaxing Vacation
         */
        romanticText.setOnClickListener(view -> {
            Intent intent = new Intent(Explore.this, romantic_getaways.class);
            startActivity(intent);
        });

        romantic.setOnClickListener(view -> {
            Intent intent = new Intent(Explore.this, romantic_getaways.class);
            startActivity(intent);
        });


        /* When Romantic Getaways ImageView/TextView is clicked, the user will be directed
        to MyChoice Activity with a list of places of interest suitable for couples
         */
        wellnessText.setOnClickListener(view -> {
            Intent intent = new Intent(Explore.this, Wellness.class);
            startActivity(intent);
        });

        wellness.setOnClickListener(view -> {
            Intent intent = new Intent(Explore.this, Wellness.class);
            startActivity(intent);
        });


        /* When Nature Trips ImageView/TextView is clicked, the user will be directed
        to MyChoice Activity with a list of places of interest suitable for outdoor activities
         */
        natureText.setOnClickListener(view -> {
            Intent intent = new Intent(Explore.this, Nature.class);
            startActivity(intent);
        });

        nature.setOnClickListener(view -> {
            Intent intent = new Intent(Explore.this, Nature.class);
            startActivity(intent);
        });

    }


}