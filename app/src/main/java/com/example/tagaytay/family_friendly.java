package com.example.tagaytay;

import android.content.Intent;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import java.util.List;


public class family_friendly extends Base implements RecyclerViewInterface{
   //variables
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
        setContentView(R.layout.activity_family_friendly);

        photos = new int[]{R.drawable.grove, R.drawable.skyranch, R.drawable.puzzle,
                R.drawable.paradizoo, R.drawable.gingerbread, R.drawable.ledons, R.drawable.orlina, R.drawable.gratchi};

        names = new String[]{"Tagaytay Picnic Grove",
        "SkyRanch", "Puzzle Mansion", "Paradizoo Theme Park", "The Gingerbread House",
        "Le Don´s Garden", "Museo Orlina", "Gratchi's Getaway - Tagaytay Farm Resort"};

       // names=getResources().getStringArray(family_friendly_name);

       desc = getResources().getStringArray(R.array.family_description);


        add = new String[]{
                "4XGX+26G, Tagaytay Picnic Grove Complex, Barangay, End, Tagaytay, Cavite",
                "Km. 60, Tagaytay - Nasugbu Hwy, Kaybagal South, Tagaytay, Cavite",
                "I. Cuadra, Brgy. Asasin, Tagaytay, Cavite",
                "493, Mendez-Tagaytay Road, Mendez, 4121, Philippines",
                "4R4X+9FR, Matagbak - Palumlum Rd, Alfonso, Cavite, Philippines",
                "Purok 3 Emilio Aguinaldo Highway, Biga 1, Silang, 4118 Cavite, Philippines",
                "Hollywood Subdivision Road Brgy, Subd, Tagaytay, Cavite, Philippines",
                "Kabangaan Rd., Brgy. Cabangaan, Silang, Tagaytay, Cavite, Philippines"
        };

        maps = new String[]{"https://goo.gl/maps/Azovr5kb9RPB9TCP6",
                "https://goo.gl/maps/Fc5UeSheQu59jWd18",
                "https://goo.gl/maps/MuJfjpF8zXSD3nUw7",
                "https://goo.gl/maps/twWZDL3FVBcEyRYY6",
                "https://goo.gl/maps/dZar4KNtoc51C2w2A",
                "https://goo.gl/maps/kBcRAC9TApWerroC7",
                "https://goo.gl/maps/kBcRAC9TApWerroC7",
                "https://goo.gl/maps/mjXE9V652NA9VWoM8"
        };

        web = new String[]{"https://www.youtube.com/watch?v=P2Xc3lxOeyQ",
                "https://www.facebook.com/skyranchtagaytayofficial/",
                "https://www.facebook.com/PuzzleMansion/about",
                "https://www.zoomanity.com.ph/themeparks/paradizoo/",
                "https://www.facebook.com/thegingerbreadhouseph/",
                "https://ledonsgarden.wixsite.com/le-dons-garden/weddings",
                "https://www.museo-orlina.org/",
                "http://www.gratchi.com/"
        };

        phones = new String[]{"tel: 63464134206", "tel: 63288627713", "tel: 63464341631",
                "tel: 639176303124", "tel:639165561409", "tel: 63464132581", "tel: 639177265484", "tel: 639177265484"};

        //Collection for the recyclerview
        collection = new AttractionData[names.length];

        for (int i = 0; i<names.length; i++){
            collection[i] = new AttractionData(photos[i], names[i]);
        }


        attractionDatas = Arrays.asList(collection.clone());

        //Instantiate RecyclerView object
        rv = findViewById(R.id.rv_family);
        rv.setHasFixedSize(true);

        //Create the layout manager and set the linearlayout vertical
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        //Instantiate the Adapter and pass the List of attractions to be placed in the Dining activity
        AttractionAdapter adapter = new AttractionAdapter(this, attractionDatas, family_friendly.this);
        rv.setAdapter(adapter);


    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(family_friendly.this, MyChoice.class);
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