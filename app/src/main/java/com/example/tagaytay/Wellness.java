package com.example.tagaytay;

import android.content.Intent;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import java.util.List;

public class Wellness extends Base  implements RecyclerViewInterface{

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
        setContentView(R.layout.activity_wellness);

        photos = new int[]{R.drawable.wellness, R.drawable.qi, R.drawable.thouse, R.drawable.kawa};

        names = getResources().getStringArray(R.array.wellness_name);

        desc = getResources().getStringArray(R.array.wellness_description);

        add = new String[]{
                "Pulong Sagingan, Barangay Maitim II West Luzon, Tagaytay, 4120 Cavite, Philippines",
                " 4W2W+CPP, Aguinaldo Highway, Brgy. Maharlika East, Tagaytay City, Philippines, Tagaytay - Nasugbu Hwy, Tagaytay, Cavite, Philippines",
                "3195 Tagaytay - Calamba Rd, Tagaytay, 4120 Cavite, Philippines",
                "St. Francis Drive, Brgy. San Francisco, Tagaytay, 4120 Cavite, Philippines"
        };

        web = new String[]{"http://nurture.com.ph/", "http://www.qiwellnessliving.ph/",
                "https://www.thousetagaytay.com/", "https://la-veryols-kawa-spa.business.site/"
        };

        maps = new String[]{"https://goo.gl/maps/4VjJfEvyCkJb44E36","https://goo.gl/maps/RoQzpVjtxPxZrx8x5",
                "https://goo.gl/maps/c91cgA42rCSSXeGJ6", "https://goo.gl/maps/y1Mu6hLKafsv93T1A"
        };

        phones = new String[]{"tel: 63287109786",
        "tel: 639175226969", "tel: 63287887354", "tel: 63288818316" };


        collection = new AttractionData[names.length];

        for (int i = 0; i<names.length; i++){
            collection[i] = new AttractionData(photos[i], names[i]);
        }


        attractionDatas = Arrays.asList(collection.clone());

        //Instantiate RecyclerView object
        rv = findViewById(R.id.rv_wellness);
        rv.setHasFixedSize(true);

        //Create the layout manager and set the linearlayout vertical
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        //Instantiate the Adapter and pass the List of attractions to be placed in the Dining activity
        AttractionAdapter adapter = new AttractionAdapter(this, attractionDatas, Wellness.this);
        rv.setAdapter(adapter);

    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(Wellness.this, MyChoice.class);
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