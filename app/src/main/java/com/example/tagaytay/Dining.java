package com.example.tagaytay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import java.util.Arrays;
import java.util.List;

public class Dining extends AppCompatActivity implements RecyclerViewInterface{


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
        setContentView(R.layout.activity_dining);

        names = getResources().getStringArray(R.array.dining_name);

        desc = getResources().getStringArray(R.array.dining_description);

        photos = new int[]{R.drawable.point, R.drawable.balay, R.drawable.josephine, R.drawable.bag,
                R.drawable.leslie,};

        web = new String[]{"https://bulalopointttgrill.wixsite.com/bulalopointturo-turo/gallery-1",
                "https://www.antoniosrestaurant.ph/balay-dako",
                "https://www.facebook.com/JosephineRestaurantTagaytay/closed",
                "https://www.facebook.com/bobtagaytay/",
                "https://lesliesrestaurants.com/"
        };

        add = new String[]{
                "Tagaytay - Nasugbu Hwy, Tagaytay, 4120 Cavite, Philippines",
                "Tagaytay - Nasugbu Hwy, Tagaytay, 4120 Cavite, Philippines",
                "Km. 58, General E Aguinaldo Highway, Maharlika West, Tagaytay, 4120 Cavite, Philippines",
                "150 Emilio Aguinaldo Hwy, Tagaytay, Cavite, Philippines",
                "4X22+RMG, Nasugbu Highway, Tagaytay, Cavite, Philippines"
        };

        phones = new String[]{
                "tel: 63464871203",
                "tel: 639237266290",
                "tel: 6281139608605",
                "tel: 639177160536",
                "tel: 63464834271"
        };

        maps = new String[]{
                "https://goo.gl/maps/8hmwoXGU5n6W2qFfA",
                "https://goo.gl/maps/pv87JEnE98ZMBYXu9",
                "https://goo.gl/maps/4TWfiRUnSzNPxw726",
                "https://goo.gl/maps/cuFWDpaBCTobvGJ96",
                "https://goo.gl/maps/RZuNWBHk1v2tKH348"
        };


        collection = new AttractionData[names.length];

        for (int i = 0; i<names.length; i++){
            collection[i] = new AttractionData(photos[i], names[i]);
        }


        attractionDatas = Arrays.asList(collection.clone());


        //Instantiate RecyclerView object
        rv = findViewById(R.id.recyclerView);
        rv.setHasFixedSize(true);

        //Create the layout manager and set the linearlayout vertical
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        //Instantiate the Adapter and pass the List of attractions to be placed in the Dining activity
        AttractionAdapter adapter = new AttractionAdapter(this, attractionDatas, Dining.this);
        rv.setAdapter(adapter);
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(Dining.this, MyChoice.class);
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