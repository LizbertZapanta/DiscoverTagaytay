package com.example.tagaytay;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import java.util.Arrays;
import java.util.List;

public class romantic_getaways extends Base implements RecyclerViewInterface{

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
        setContentView(R.layout.activity_romantic_getaways);
        photos=new int[] {R.drawable.sonya, R.drawable.carmelence, R.drawable.perlas, R.drawable.lake};

        names =getResources().getStringArray(R.array.romantic_names);

        desc = getResources().getStringArray(R.array.romantic_description);

        add = new String[]{"Barangay, Alfonso, 4123 Cavite, Philippines",
                "117 Villa Carmelence 2, Tagaytay-Nasugbu Highway, Maharlika West, Tagaytay, 4120 Cavite, Philippines",
                "5 Pulong Bunga Rd, Silang, Cavite, Philippines",
                "Km.58, Gen. Brgy., Emilio Aguinaldo Hwy, Tagaytay, 4120 Cavite, Philippines"
        };

        web = new String[]{
                "https://sonyasgarden.com/",
                "https://www.thecarmelenceview.com/",
                "https://www.facebook.com/profile.php?id=100083376240725",
                "https://www.lakehoteltagaytay.com/"
        };

        maps = new String[]{
             "https://goo.gl/maps/sHUCeT8D6JCX8tVG6",
                "https://goo.gl/maps/5jYA4BMwPekfiUzo9",
                "https://goo.gl/maps/cf4vhwYL1E3cKHva9",
                "https://goo.gl/maps/sUeg1LuYkLNkSTQf7"
        };

        phones = new String[]{
                "tel: 639177033442",
                "tel: 639175843825",
                "tel: ",
                "tel: 63464134680"
        };

        //objects for the recyclerview
        collection = new AttractionData[names.length];

        for (int i = 0; i<names.length; i++){
            collection[i] = new AttractionData(photos[i], names[i]);
        }


        attractionDatas = Arrays.asList(collection.clone());

        //Instantiate RecyclerView object
        rv = findViewById(R.id.rv_romantic);
        rv.setHasFixedSize(true);

        //Create the layout manager and set the linearlayout vertical
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        //Instantiate the Adapter and pass the List of attractions to be placed in the Dining activity
        AttractionAdapter adapter = new AttractionAdapter(this, attractionDatas, romantic_getaways.this);
        rv.setAdapter(adapter);

    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(romantic_getaways.this, MyChoice.class);
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
