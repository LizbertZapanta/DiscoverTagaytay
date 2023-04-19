package com.example.tagaytay;

import android.content.Intent;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class Night extends Base implements RecyclerViewInterface{


    String[] names;
    int[] photos;
    String[] desc;
    String[] web;
    String[] add;
    String[] maps;
    String[] phones;

    List<AttractionData> attractionDatas;
    AttractionData[] collection;
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_night);

        names = new String[]{"Papa Doms Bar and Restaurant", "Skypiea Rooftop Bar & Kitchen", "Sky View RestoBar", "Santiago Craft Beer Garden",
                "Cabanas Dine and Bar", "Lighthouse bar and restaurant"};

        photos = new int[]{R.drawable.papadoms, R.drawable.sky, R.drawable.skyview, R.drawable.santiago, R.drawable.cabanas, R.drawable.lighthouse};

        desc = new String[]{"Your best party place down south! Famous for their calamri, crispy pata, and rib eye. Average price per plate P250", "They offer Filipino, Italian and Japanese Cuisine. Cocktails and mocktails price average P180",
                "They serve both Mediterranean and Filipino dishes", "Recommended for an intimate celebration with family and friends, gathered with delicious food, unlimited local CRAFT BEER, music and fun!", "Perfect place to hang out and chill with friends after working hours. Great food and live bands", "They serve Filipino dishes. Cocktails and mocktails price average P200"};

        web = new String[]{"https://www.facebook.com/PAPADOMSPH", "https://www.instagram.com/skypieatagaytay/?hl=en", "https://www.facebook.com/SkyViewRestoBar2016/",
                "https://www.facebook.com/santiagotagaytay/?show_switched_toast=0&show_invite_to_follow=0&show_switched_tooltip=0&show_podcast_settings=0&show_community_transition=0&show_community_review_changes=0&show_community_rollback=0&show_follower_visibility_disclosure=0",
                "https://www.instagram.com/cabanastagaytay/", "https://www.facebook.com/AfPinarb/"};

        add = new String[]{"Vista Point, Tagaytay, 4120 Cavite, Philippines", "Rooftop Bar and Kitchen\n" +
                "3F Crisol Bldg. San Jose, Tagaytay City", "Magallanes Dr, Tagaytay, 4120 Cavite, Philippines",
                "Km. 60 Santa Rosa - Tagaytay Rd, Brgy. Francisco, Tagaytay, Cavite, Philippines",
                "9034 Tagaytay - Nasugbu Hwy, Silang Junction South, Tagaytay, 4120 Cavite, Philippines",
                "Magallanes square hotel 3rd level, Tagaytay, 4118, Philippines"};

        maps = new String[]{"https://goo.gl/maps/NNRqRuF9bp2R9zj59", "https://goo.gl/maps/ZK9sxh2MFgFsj13y5", "https://goo.gl/maps/ZK9sxh2MFgFsj13y5",
                "https://goo.gl/maps/oHU2U9QayyP2LqQz5", "https://goo.gl/maps/QYdqbmF4NbrmhtMm9", "https://goo.gl/maps/EvtZ6Z2RqLCAomRU7"
        };

        phones = new String[]{"tel: 63468534270", "tel: 63468534270", "tel: 63468534270", "tel: 63468534270", "tel: 63468534270", "tel: 63468534270"};

        collection = new AttractionData[names.length];

        for (int i = 0; i<names.length; i++){
            collection[i] = new AttractionData(photos[i], names[i]);
        }


        attractionDatas = Arrays.asList(collection.clone());

        //Instantiate RecyclerView object
        rv = findViewById(R.id.rv_night);
        rv.setHasFixedSize(true);

        //Create the layout manager and set the linearlayout vertical
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        //Instantiate the Adapter and pass the List of attractions to be placed in the Dining activity
        AttractionAdapter adapter = new AttractionAdapter(this, attractionDatas, Night.this);
        rv.setAdapter(adapter);

    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(Night.this, MyChoice.class);
        intent.putExtra("name", names[position]);
        intent.putExtra("address", add[position]);
        intent.putExtra("web", web[position]);
        intent.putExtra("map", maps[position]);
        intent.putExtra("desc", desc[position]);
        intent.putExtra("photos", photos[position]);
        intent.putExtra("phones", phones[position]);
        startActivity(intent);
    }
}