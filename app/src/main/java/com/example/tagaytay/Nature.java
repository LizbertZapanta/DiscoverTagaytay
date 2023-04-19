package com.example.tagaytay;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import java.util.Arrays;
import java.util.List;

public class Nature extends Base implements RecyclerViewInterface{


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
        setContentView(R.layout.activity_nature);

        photos = new int[]{R.drawable.strawberry, R.drawable.people, R.drawable.volcano, R.drawable.ridge, R.drawable.ambon};

        names = getResources().getStringArray(R.array.nature_names);

        desc = getResources().getStringArray(R.array.nature_description);

        web = new String[]{"https://www.queensstrawberryfarm.com/",
                "https://en.wikipedia.org/wiki/People%27s_Park_in_the_Sky",
                "https://en.wikipedia.org/wiki/Taal_Volcano", "http://wikimapia.org/31475542/Tagaytay-Ridge",
                "http://www.pinoymountaineer.com/2007/10/ambon-ambon-falls.html"
        };

        maps = new String[]{
                "https://goo.gl/maps/TVmS2VyhzHHQx7BJ9", "https://goo.gl/maps/TgBSmctUQqyzEifU7",
                "https://goo.gl/maps/wcr7dE7TdMRg739F6", "https://goo.gl/maps/BL1pgK9gx9a7iBW96", "https://goo.gl/maps/BL1pgK9gx9a7iBW96"
        };

        add = new String[]{
                "Sitio Hawilian 2, Alfonso, Cavite, Philippines",
                "42RC+MQ8, Tagaytay - Calamba Rd, Tagaytay, Cavite, Philippines",
                "Talisay, Philippines", "Tagaytay, Cavite, Philippines", "3W22+CW7, Laurel, Batangas, Philippines"
        };

        phones = new String[]{
                "tel: 69488417161", "tel: 6399900000", "tel: 6399900000", "tel: 6399900000", "tel: 6399900000"
        };

        /*
        collection is the list of data that will be used for the recyclerview
         */
        collection = new AttractionData[names.length];

        for (int i = 0; i<names.length; i++){
            collection[i] = new AttractionData(photos[i], names[i]);
        }


        attractionDatas = Arrays.asList(collection.clone());

        //Instantiate RecyclerView object
        rv = findViewById(R.id.rv_nature);
        rv.setHasFixedSize(true);

        //Create the layout manager and set the linearlayout vertical
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        //Instantiate the Adapter and pass the List of attractions to be placed in the Dining activity
        AttractionAdapter adapter = new AttractionAdapter(this, attractionDatas, Nature.this);
        rv.setAdapter(adapter);

    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(Nature.this, MyChoice.class);
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