package com.example.tagaytay;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class Base extends AppCompatActivity {
    // this class is going to be inherited by some classes in order to set my menu bar.
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id= item.getItemId();

        if (id== R.id.share) {
            //if the share icon from the menu is selected, it will send the user to the google playstore app to
            Intent intent= new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            String body="Download this app in Google Playstore";
            intent.putExtra(Intent.EXTRA_SUBJECT, body);
            startActivity(Intent.createChooser(intent, "Spread the news! Share our app"));
            return super.onOptionsItemSelected(item);
        }else if (id== R.id.rate) {
            Intent rateus= new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/games?hl=en&gl=US"));
            //once app is uploaded in playstore, i can edit this link to include the app id
            startActivity(Intent.createChooser(rateus, "Rate our App"));
            return super.onOptionsItemSelected(item);
        }else if (id== R.id.language) {
            
        }
        //else if for the setting is missing

        return false;
    }
}
