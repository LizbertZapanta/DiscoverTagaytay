package com.example.tagaytay;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.Arrays;
import java.util.List;

public class Embassy extends Base implements RecyclerViewInterface{

    String[] names;
    int[] photos;
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
        setContentView(R.layout.activity_embassy);

        names = new String[]{ "Embassy of Argentina", "Embassy of Australia", "Embassy of Belgium", "Embassy of Canada",
                "Embassy of Chile", "Embassy of Germany", "Embassy of Japan", "Embassy of Malaysia", "Embassy of Poland",
                "Embassy of Singapore", "Embassy of Spain", "Embassy of United Kingdom", "Embassy of the United States of America"

        };

        photos = new int[]{R.drawable.argentina, R.drawable.australiaflag,R.drawable.belgium, R.drawable.canada, R.drawable.chile,
                R.drawable.germanyflag, R.drawable.japan,R.drawable.malaysia, R.drawable.poland, R.drawable.sin, R.drawable.spain,
                R.drawable.uk, R.drawable.usa
        };

        //address will be used for description
        add = new String[]{"104, 8th Floor Liberty Center, H.V. De La Costa Street, Salcedo Village, Makati, 1227 Metro Manila, Philippines",
            "Level 23 Tower 2, RCBC Plaza Tower 2 6819 Ayala Avenue, Makati City 1200 Philippines",
                "Multinational Bancorporation Center 9th floor - 6805 Ayala Avenue 1200, Philippines",
                "RCBC Plaza Tower 2, 6th-8th Floor, 6819 Ayala Ave, Makati, 1227 Metro Manila, Philippines",
                "17th Floor Liberty Center Building, 104, H.V. Dela Costa corner Leviste, Salcedo Village Makati, 1227 Metro Manila, Philippines",
                "6819 Ayala Ave, Makati, Metro Manila, Philippines",
                "2627, 1300 Roxas Blvd, Pasay, Metro Manila, Philippines",
                "07 Tordesillas Street Salcedo Village, Makati, Metro Manila, Phillipines",
                "9th Floor, Del Rosario Law Centre, 21st Drive, cor 20th Dr, Taguig, 1630 Metro Manila, Philippines",
                "505 Rizal Drive, Bonifacio Global City 1634 Taguig City, Metro Manila, Philippines",
                "L27, Equitable Bank Tower, 8751 Paseo de Roxas, Makati, Metro Manila, Philippines",
                "120 Upper McKinley Rd, Taguig, 1630 Metro Manila, Philippines",
                "1201 Roxas Blvd, Ermita, Manila, 1000 Metro Manila, Philippines"

        };

        web = new String[]{"https://www.embassypages.com/argentina-embassy-manila-philippines",
            "https://philippines.embassy.gov.au/mnla/home.html",
                "https://philippines.diplomatie.belgium.be/en",
                "https://www.international.gc.ca/country-pays/philippines/index.aspx?lang=eng",
                "https://www.chile.gob.cl/filipinas/",
                "https://manila.diplo.de/",
                "https://www.ph.emb-japan.go.jp/itprtop_en/index.html",
                "https://www.kln.gov.my/web/phl_manila/home/-/asset_publisher/8ppt/blog/site_map",
                "https://www.gov.pl/web/philippines/embassy",
                "https://www.mfa.gov.sg/manila",
                "https://www.exteriores.gob.es/Consulados/manila/en/Paginas/index.aspx",
                "https://www.gov.uk/world/philippines",
                "https://ph.usembassy.gov/"

        };

        phones = new String[]{"tel: 63288453218",
        "tel: 63277578100", "tel: 63288451869",
                "tel: 63288579000",
                "tel: 63288433463",
                "tel: 63287023000",
                "tel: 63285515710",
                "tel: 63286628200",
                "tel: 63253182700",
                "tel: 63288569922",
                "tel: 63288179997",
                "tel: 63288582200",
                "tel: 6323012000"
        };

        maps = new String[]{ "https://goo.gl/maps/zMRZ7zNoiwZKihFH8",
                "https://goo.gl/maps/jyWFTrW3bwJG5yns5",
                "https://goo.gl/maps/q1KfTrzH1PhGxcfU8",
                "https://goo.gl/maps/MQBpE7fARXJF1oKy8",
                "https://goo.gl/maps/7SZJfHaunSgi9qKJ8",
                "https://goo.gl/maps/tA2bb4sDtYGBpaMf9",
                "https://goo.gl/maps/eYXm7qN91Hu31Qah7",
                "https://goo.gl/maps/paGjvpk2cb6wvBCBA",
                "https://goo.gl/maps/KDKPYQeTboWTZGFp6",
                "https://goo.gl/maps/T7ivVLp59PzaQJmE7",
                "https://goo.gl/maps/6zZsao6eku6kR3kv9",
                "https://goo.gl/maps/RjodbHUC4H3Km27p9",
                "https://goo.gl/maps/UczqnbudMNwdKv29A"
        };

        collection = new AttractionData[names.length];

        for (int i = 0; i<names.length; i++){
            collection[i] = new AttractionData(photos[i], names[i]);
        }


        attractionDatas = Arrays.asList(collection.clone());

        //Instantiate RecyclerView object
        rv = findViewById(R.id.rv_embassy);
        rv.setHasFixedSize(true);

        //Create the layout manager and set the linearlayout vertical
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        //Instantiate the Adapter and pass the List of attractions to be placed in the Dining activity
        AttractionAdapter adapter = new AttractionAdapter(this, attractionDatas, Embassy.this);
        rv.setAdapter(adapter);


    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(Embassy.this, MyChoice.class);
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