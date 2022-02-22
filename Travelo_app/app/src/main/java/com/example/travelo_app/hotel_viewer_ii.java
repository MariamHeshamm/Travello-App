package com.example.travelo_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class hotel_viewer_ii extends AppCompatActivity {

    RecyclerView rv ;
    hotel_adapter_ii adapter ;
    DatabaseHelper db ;
    ArrayList<Hotel> hotels ;
    String City ;

    Button filter, sort ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_viewer_ii);
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation_bar);
        bottomNavigationView.setSelectedItemId(R.id.Home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch ((item.getItemId()))
                {
                    case R.id.Home:
                        return true;
                    case R.id.Whishlist:
                        startActivity(new Intent(getApplicationContext(),city_viewer.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.History:
                        startActivity(new Intent(getApplicationContext(),city_viewer.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return true;
            }
        });

        //CHANGE
        City = "Hurghada";




        rv = findViewById(R.id.hotel_recyler_ii) ;
        db = new DatabaseHelper(hotel_viewer_ii.this) ;
        hotels = db.get_hotels_in_city(City) ;




        adapter = new hotel_adapter_ii(hotels);
        //RecyclerView.LayoutManager lm = new LinearLayoutManager(hotel_viewer.this);

        RecyclerView.LayoutManager ln;
        ln = new LinearLayoutManager(this ) ;

        rv.setHasFixedSize(false);
        rv.setLayoutManager(ln);
        rv.setAdapter(adapter);


        //sort and filter code HERE

        sort.findViewById(R.id.sort_btn);
        filter.findViewById(R.id.filter_btn) ;


        sort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openDialog();


            }
        });


    }

    private void openDialog() {
    }
}