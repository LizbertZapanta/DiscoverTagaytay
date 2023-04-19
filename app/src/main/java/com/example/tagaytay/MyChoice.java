package com.example.tagaytay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MyChoice extends AppCompatActivity {
    TextView sName = null;
    ImageButton sWeb = null;
    ImageButton sShare = null;
    ImageButton sMap = null;
    ImageButton sCall = null;
    ImageView sPhotos = null;
    TextView sDesc = null;
    TextView titleDesc = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_choice);

        //Retrieve all the Arrays of data from the activity that initiated the intent
        String retrieveName = getIntent().getStringExtra("name");
        String retrieveAdd = getIntent().getStringExtra("address");
        String retrieveWeb = getIntent().getStringExtra("web");
        String retrieveDesc = getIntent().getStringExtra("desc");
        String retrieveMap = getIntent().getStringExtra("map");
        String retrievePhone=getIntent().getStringExtra("phones");
        String retrieveTitle = getIntent().getStringExtra("Address");



        //Create all the widget objects
        sName = findViewById(R.id.selected_name);
        titleDesc = findViewById(R.id.desc_text);
        sWeb = findViewById(R.id.website);
        sDesc = findViewById(R.id.desc);
        sPhotos = findViewById(R.id.image_def);
        sShare = findViewById(R.id.icon_share);
        sCall = findViewById(R.id.icon_call);
        sMap = findViewById(R.id.icon_map);

        //Set texts and parameters for the widgets
        sName.setText(retrieveName);
        sDesc.setText(retrieveDesc);
        sPhotos.setImageResource(getIntent().getIntExtra("photos",1));
        if (retrieveTitle!=null){
            titleDesc.setText(retrieveTitle);
        }


        //Name textview with onclick to open the website
        sWeb.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(retrieveWeb));
            startActivity(intent);
        });

        //Button with onclick to open the googlemap to show location on map
        // sAddress.setText(retrieveAdd);

        sMap.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(retrieveMap));
            startActivity(intent);
        });

        sShare.setOnClickListener(view -> {
            Intent intent= new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_SUBJECT, "Address for: " + retrieveName);
            intent.putExtra(Intent.EXTRA_TEXT, retrieveAdd);
            startActivity(Intent.createChooser(intent,"Share address"));
        });

        // When the Call Button is clicked, a phone call will be made to the number to the umber retrieved thatinitiated the Intent

        sCall.setOnClickListener(view -> {
            Intent intent= new Intent(Intent.ACTION_DIAL, Uri.parse(retrievePhone));
            startActivity(intent);
        });

    }

}