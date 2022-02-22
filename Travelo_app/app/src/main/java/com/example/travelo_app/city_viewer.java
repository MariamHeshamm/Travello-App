package com.example.travelo_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class city_viewer extends AppCompatActivity {

    RecyclerView rv ;
    city_adapter adapter ;
    ArrayList<city> cities;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_viewer);


        rv = findViewById(R.id.city_recyler);

        cities = new ArrayList<>();

        //add cites here

        cities.add(new city ("Hurghada" , "https://upload.wikimedia.org/wikipedia/commons/thumb/8/82/Alig_walk_way_hurghada_egypt_629.jpg/220px-Alig_walk_way_hurghada_egypt_629.jpg"  , "https://i.pinimg.com/236x/bf/5f/ea/bf5feafda6d3dd7a3606fb964c19cf61.jpg" , "https://i.pinimg.com/236x/5c/c4/7a/5cc47aa133c9fc53c184f58d8aa11350.jpg" , "https://i.pinimg.com/236x/95/2f/b3/952fb33d17698fbabdf2bd83240b545f.jpg") );
        cities.add(new city ("Sharm El Sheikh" , "https://i.pinimg.com/236x/85/32/01/8532015072a0dc4c1b424b7de7efdd17.jpg"  , "https://i.pinimg.com/236x/93/59/0f/93590f26306825debb3f47041c6c16e5.jpg" , "https://upload.wikimedia.org/wikipedia/commons/thumb/8/82/Alig_walk_way_hurghada_egypt_629.jpg/220px-Alig_walk_way_hurghada_egypt_629.jpg" , "https://upload.wikimedia.org/wikipedia/commons/thumb/8/82/Alig_walk_way_hurghada_egypt_629.jpg/220px-Alig_walk_way_hurghada_egypt_629.jpg") );
        cities.add(new city ("Cairo" , "https://i.pinimg.com/236x/cb/80/1b/cb801bc9a78eb837b29c7f4ebe142074.jpg"  , "https://upload.wikimedia.org/wikipedia/commons/thumb/8/82/Alig_walk_way_hurghada_egypt_629.jpg/220px-Alig_walk_way_hurghada_egypt_629.jpg" , "https://upload.wikimedia.org/wikipedia/commons/thumb/8/82/Alig_walk_way_hurghada_egypt_629.jpg/220px-Alig_walk_way_hurghada_egypt_629.jpg" , "https://upload.wikimedia.org/wikipedia/commons/thumb/8/82/Alig_walk_way_hurghada_egypt_629.jpg/220px-Alig_walk_way_hurghada_egypt_629.jpg") );
        cities.add(new city ("Sinai" , "https://i.pinimg.com/236x/df/8f/e0/df8fe07316637565451185f9dc79607b.jpg"  , "https://i.pinimg.com/236x/c0/af/39/c0af39b00388a83f89528d4822aed656.jpg" , "https://upload.wikimedia.org/wikipedia/commons/thumb/8/82/Alig_walk_way_hurghada_egypt_629.jpg/220px-Alig_walk_way_hurghada_egypt_629.jpg" , "https://upload.wikimedia.org/wikipedia/commons/thumb/8/82/Alig_walk_way_hurghada_egypt_629.jpg/220px-Alig_walk_way_hurghada_egypt_629.jpg") );



        adapter = new city_adapter(cities,city_viewer.this,"1") ;

        RecyclerView.LayoutManager ln;
        ln = new LinearLayoutManager(city_viewer.this  ) ;

        rv.setHasFixedSize(true);
        rv.setLayoutManager(ln);
        rv.setAdapter(adapter);


    }
}