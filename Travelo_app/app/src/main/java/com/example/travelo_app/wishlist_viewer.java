package com.example.travelo_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class wishlist_viewer extends AppCompatActivity {

    RecyclerView rv ;
    wishlist_adapter adapter ;
    DatabaseHelper db ;
    ArrayList<Hotel> hotels ;


    int USER_ID = 1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishlist_viewer);

        rv = findViewById(R.id.wishlist_recyler) ;
        db = new DatabaseHelper(wishlist_viewer.this) ;


        hotels = db.get_liked_hotel(USER_ID);


        adapter = new wishlist_adapter(hotels , USER_ID , wishlist_viewer.this);


        RecyclerView.LayoutManager ln;
        ln = new LinearLayoutManager(wishlist_viewer.this ) ;

        rv.setHasFixedSize(false);
        rv.setLayoutManager(ln);
        rv.setAdapter(adapter);

    }
}