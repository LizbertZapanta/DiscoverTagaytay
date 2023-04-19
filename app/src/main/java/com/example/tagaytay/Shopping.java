package com.example.tagaytay;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import java.util.Arrays;
import java.util.List;

public class Shopping extends Base implements RecyclerViewInterface {


    String[] names;
    int[] photos;
    String[] desc;
    String[] web;
    String[] add;
    String[] shops;
    String[] maps;
    String[] phones;

    List<AttractionData> attractionDatas;
    AttractionData[] collection;
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);

        names = new String[]{"Fora Mall Tagaytay", "Primark Shopping Center", "Ayala Mall Serin", "Robinsons Tagaytay", "Magallanes Square"};

        photos = new int[]{R.drawable.fora_mall, R.drawable.primark, R.drawable.serin, R.drawable.robinsons, R.drawable.magallanes};

        desc = getResources().getStringArray(R.array.shop_description);

        web = new String[]{"https://www.filinvestlifemalls.com/", "https://primark.com.ph/malls/south-luzon/tagaytay",
                "https://www.ayalamalls.com/main/malls/ayala-serin", "https://www.robinsonsmalls.com/mall-info/robinsons-tagaytay",
                "https://magallanessquarehotel.com/"};

        add = new String[]{"Emilio Aguinaldo Highway, East, Silang Junction South, Tagaytay, 4120 Cavite, Philippines",
                " 4W2W+HC4, Tagaytay - Nasugbu Hwy, Tagaytay, Cavite, Philippines",
                "Tagaytay - Nasugbu Hwy, Silang Junction South, Tagaytay, Cavite, Philippines",
                "Tagaytay Nasugbu Road, Maharlika West, KM 58 Gen. E. Aguinaldo Highway, Tagaytay City",
                "Magallanes Dr, Tagaytay, Cavite, Philippines"
        };

        shops = new String[]{
                "Pandora, PhilipStein, Fossil, GShock, Giordano, H&M, Guess, Levi´s, Mossimo, Penshoppe, Triumph, Samsung, Globe, Oppo, Power Mac Center, Smart, BDO, BPI, EaastWest Bank, National Bookstore, Toy Kingdom, Mary Grace, Chowking, Cinnabon, Bon Chon, Classic Savory, Fukuya, Giligans, Ilonggo Grill",
                "Cafe Amazon,Doctor Tooth Corp Multispecialty Dental Clinic,Elysian Spa, His & Her, JC Maturi Hair Design Salon, McDonald's, Nissan, Pan de Manila, Potato Corner, SM Appliance Store, SM Supermarket",
                "Cafe Amazon,Doctor Tooth Corp Multispecialty Dental Clinic,Elysian Spa, His & Her, JC Maturi Hair Design Salon, McDonald's, Nissan, Pan de Manila, Potato Corner, SM Appliance Store, SM Supermarket",
                "Bag of Beans, Hap Chan, Shakeys, Starbucks, Giordano, H&M, Guess, Levi´s, Daiso, HandyMan, Triumph, Samsung, Globe, Oppo, Power Mac Center, Smart, BDO, BPI, EaastWest Bank, National Bookstore, Toy Kingdom, Mary Grace, Chowking, Cinnabon, Bon Chon, Classic Savory, Fukuya, Giligans, Ilonggo Grill",
                "Palawan Pawnshop, Shawarma House, Kuya Rex, Panit ng Taga Malabon, Essensa Naturale, Kurimi"
        };

        phones = new String[]{"tel: 63468534270", "tel: 63468534270", "tel: 63468534270", "tel: 63468534270", "tel: 63468534270"};

        maps = new String[] {"https://goo.gl/maps/npv6Yd11VJtgYUeE9", "https://goo.gl/maps/Hp9dpT5K87GiuSKW8", "https://goo.gl/maps/yMVsitp1MFfQPERR9", "https://goo.gl/maps/6SXwvMd2bopkRRjC9", "https://goo.gl/maps/MkAptATRvyG4Sbyd6" };

        collection = new AttractionData[names.length];

        for (int i = 0; i<names.length; i++){
            collection[i] = new AttractionData(photos[i], names[i]);
        }


        attractionDatas = Arrays.asList(collection.clone());

        //Instantiate RecyclerView object
        rv = findViewById(R.id.rv_shopping);
        rv.setHasFixedSize(true);

        //Create the layout manager and set the linearlayout vertical
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        //Instantiate the Adapter and pass the List of attractions to be placed in the Dining activity
        AttractionAdapter adapter = new AttractionAdapter(this, attractionDatas, Shopping.this);
        rv.setAdapter(adapter);



        /*Instantiate ListView object
        lv = findViewById(R.id.lv_shopping);


        //Create adapter object apply in the sepAdapter parameter
        CustomAdapter adapter = new CustomAdapter(Shopping.this, photos, shop_names);
        lv.setAdapter(adapter);
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Shopping.this, MyChoice.class);
                intent.putExtra("name", shop_names[i]);
                intent.putExtra("address", add[i]);
                intent.putExtra("web", web[i]);
                intent.putExtra("map", maps[i]);
                intent.putExtra("desc", desc[i]);
                intent.putExtra("photos", photos[i]);
                intent.putExtra("phones", phones[i]);
                Toast.makeText(Shopping.this, adapterView.getItemIdAtPosition(i) + " was selected", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });*/


    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(Shopping.this, MyChoice.class);
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