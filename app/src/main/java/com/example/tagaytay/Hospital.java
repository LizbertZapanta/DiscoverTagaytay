package com.example.tagaytay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.Arrays;
import java.util.List;


public class Hospital extends Base implements RecyclerViewInterface {

    String[] names;
    int[] photos;
    //String[] desc;
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
        setContentView(R.layout.activity_hospital);

        names = new String[]{"Tagaytay Medical Center",
                "Ospital ng Tagaytay",
                "Asian Hospital and Medical Center",
                "Unihealth Southwoods Hospital and Medical Center",
                "Cavite Medical Center"
        };

        photos = new int[]{R.drawable.tmc,R.drawable.osp_tagaytay, R.drawable.asianhosp, R.drawable.uni,
                R.drawable.cavitemm
        };

        //address will be used for description
        add = new String[]{ "Emilio Aguinaldo Hwy, Silang Junction North, Tagaytay, 4120 Cavite, Philippines",
                "3WXR+P3G, Crisanto M. De Los Reyes Ave, Kaybagal South, Tagaytay, Cavite, Philippines",
                "2205 Civic Dr, Alabang, Muntinlupa, 1780 Metro Manila, Philippines",
                "Lot 3 Blk 11 Southwoods Ecocentrum Business Park Brgy, Biñan, 4023 Laguna, Philippines",
                "Manila-Cavite Rd, Dalahican, Cavite City, 4100 Cavite, Philippines"

        };

        web = new String[]{"https://tagaytaymed.com.ph/",
                "https://www.facebook.com/821933307879009/posts/3873661369372839/",
                "https://www.asianhospital.com/",
                "https://unihealthsouthwoodshospital.com/",
                "https://www.facebook.com/OfficialCaviteMedicalCenter/"

        };

        phones = new String[]{"tel: 63464830134",
                "tel: 63464832160",
                "tel: 63287719000",
                "tel: 63287752861",
                "tel: 63464319988"
        };

        maps = new String[]{"https://goo.gl/maps/xDdFvHPiKyPZZS7v8",
                "https://goo.gl/maps/kLfr2kCbTodLN98P9",
                "https://goo.gl/maps/7VoHwkPSV7vSRSMx5",
                "https://goo.gl/maps/5SMLqCbqwnogw3f9A",
                "https://goo.gl/maps/CDYUAKALnGTXxEM3A"
        };

        collection = new AttractionData[names.length];

        for (int i = 0; i<names.length; i++){
            collection[i] = new AttractionData(photos[i], names[i]);
        }


        attractionDatas = Arrays.asList(collection.clone());

        //Instantiate RecyclerView object
        rv = findViewById(R.id.rv_hospital);
        rv.setHasFixedSize(true);

        //Create the layout manager and set the linearlayout vertical
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        //Instantiate the Adapter and pass the List of attractions to be placed in the Dining activity
        AttractionAdapter adapter = new AttractionAdapter(this, attractionDatas, Hospital.this);
        rv.setAdapter(adapter);

    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(Hospital.this, MyChoice.class);
        intent.putExtra("name", names[position]);
        intent.putExtra("address", add[position]);
        intent.putExtra("web", web[position]);
        intent.putExtra("map", maps[position]);
        intent.putExtra("desc", add[position]);
        intent.putExtra("photos", photos[position]);
        intent.putExtra("phones", phones[position]);
        intent.putExtra("Address", "Address:");
        startActivity(intent);
    }
}