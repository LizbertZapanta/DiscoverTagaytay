package com.example.tagaytay;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.Arrays;
import java.util.List;

public class Coffee extends Base implements RecyclerViewInterface{

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
        setContentView(R.layout.activity_coffee);

        names = getResources().getStringArray(R.array.coffee_name);

        photos = new int[]{R.drawable.voila,
                R.drawable.starbucks,
                R.drawable.bagofbeans,
                R.drawable.mainit,
                R.drawable.dreams,
                R.drawable.chars};

        desc = getResources().getStringArray(R.array.coffee_description);

        web = new String[]{"https://www.facebook.com/CafeVoiLa1/", "https://www.starbucks.com/", "https://www.facebook.com/bobtagaytay/",
                "https://www.facebook.com/KapengMainitTagaytay/", "https://www.facebook.com/CoffeeAndDreamsOfficial/", "https://www.facebook.com/charsgardencafe/"};

        add = new String[]{"42P6+G9J, Tagaytay, Cavite, Philippines",
                "Purok 162 Tagaytay - Calamba Rd, Tolentino West, Tagaytay, 4120 Cavite, Philippines",
                "3WW8+242, Tagaytay - Nasugbu Hwy, Tagaytay, Cavite, Philippines",
                "4W2W+XVG, Tagaytay, 4120 Cavite, Philippines",
                "1315 Emilio Aguinaldo Hwy, Silang Junction South, Tagaytay, 4120 Cavite, Philippines",
                "4W3G+QWP, Patutong Malaki North, Tagaytay, Cavite, Philippines"
        };

        maps = new String[]{"https://goo.gl/maps/fn6w1UgMSLVsN55g8",
                "https://goo.gl/maps/w8H4fjN5jwZWhFYQA",
                "https://goo.gl/maps/n927k2FgPKosjNGT9",
                "https://goo.gl/maps/18SipfShoHY6icoJ9",
                "https://goo.gl/maps/g9b2FS8LXxh2DNJr9",
                "https://goo.gl/maps/7evsnBtAjAo9fi7q8"};

        phones = new String[]{"tel: 639053314457",
                "tel: 63464130725",
                "tel: 639178667033",
                "tel: 639776090146",
                "tel: 639275407163",
                "tel: 639065363228"};

        collection = new AttractionData[names.length];

        for (int i = 0; i<names.length; i++){
            collection[i] = new AttractionData(photos[i], names[i]);
        }


        attractionDatas = Arrays.asList(collection.clone());

        //Instantiate RecyclerView object
        rv = findViewById(R.id.rv_coffee);
        rv.setHasFixedSize(true);

        //Create the layout manager and set the linearlayout vertical
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        //Instantiate the Adapter and pass the List of attractions to be placed in the Dining activity
        AttractionAdapter adapter = new AttractionAdapter(this, attractionDatas, Coffee.this);
        rv.setAdapter(adapter);

    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(Coffee.this, MyChoice.class);
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