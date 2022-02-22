package com.example.travelo_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class hotel_viewer extends AppCompatActivity  implements  Dialog.DialogLinstener , DialogII.DialogLinstener {

    RecyclerView rv ;
    hotel_view_adapter adapter ;
    DatabaseHelper db ;
    ArrayList<Hotel> hotels ;

    String City ;
    String id="";
    int userID ;


    int check_sort_dependency ;

    int seek_bar_value , rating_bar_value ;
    Button filter, sort ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //CHANGE
        City = "Hurghada";



        setContentView(R.layout.activity_hotel_viewer);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            id = bundle.getString("ID", "");
            //Toast.makeText(this, "ID"+id, Toast.LENGTH_SHORT).show();
            userID=Integer.parseInt(id);
        }

        rv = findViewById(R.id.recyler_view_hotels) ;
        db = new DatabaseHelper(hotel_viewer.this) ;



        //hotels = db.get_hotels_in_city(City) ;

        hotels = db.get_all_hotels() ;

        adapter = new hotel_view_adapter(hotels , userID , hotel_viewer.this);
        //RecyclerView.LayoutManager lm = new LinearLayoutManager(hotel_viewer.this);

        RecyclerView.LayoutManager ln;
        ln = new LinearLayoutManager(hotel_viewer.this ) ;

        rv.setHasFixedSize(false);
        rv.setLayoutManager(ln);
        rv.setAdapter(adapter);




        //sort and filter code HERE



        sort = findViewById(R.id.sort_btn);
        filter = findViewById(R.id.filter_btn) ;


        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openDialog();


            }
        });


        sort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                openDialogII();


            }
        });



    }

    private void openDialog() {

        Dialog dialog = new Dialog( ) ;
        dialog.show(getSupportFragmentManager() , "Example Dialog");



    }

    @Override
    public void sendTexts(int seekBar_value, int ratingBar_value) {

        seek_bar_value = seekBar_value ;
        rating_bar_value = ratingBar_value;


        //write the filtration code here

        ArrayList<Hotel> filtered_hotels = new ArrayList<>();
        for (int i = 0 ; i< hotels.size() ; i++) {
            if (hotels.get(i).getPrice() <= seekBar_value && hotels.get(i).getRate() <= rating_bar_value)
                filtered_hotels.add(new Hotel(hotels.get(i)));



        }

        adapter = new hotel_view_adapter(filtered_hotels , userID , hotel_viewer.this);
        //RecyclerView.LayoutManager lm = new LinearLayoutManager(hotel_viewer.this);

        RecyclerView.LayoutManager ln;
        ln = new LinearLayoutManager(hotel_viewer.this ) ;

        rv.setHasFixedSize(false);
        rv.setLayoutManager(ln);
        rv.setAdapter(adapter);
    }

    ///////////////sort stuff
    private void openDialogII() {

        DialogII dialogII = new DialogII( ) ;
        dialogII.show(getSupportFragmentManager() , "Example Dialog");



    }
    @Override
    public void sendChoice(int choice) {

        ArrayList<Hotel> sorted_hotels = new ArrayList<>();

        for (int i = 0  ; i< hotels.size() ; i++)
            sorted_hotels.add(new Hotel(hotels.get(i)));


        check_sort_dependency = choice ;

        if (check_sort_dependency == 1)
        {
            //sort based on rate

            Collections.sort(sorted_hotels , new sort_hotel_by_rate());


        }
        else {

            // sort based on price
            Collections.sort(sorted_hotels , new sort_hotel_by_price());

        }

        adapter = new hotel_view_adapter(sorted_hotels , userID , hotel_viewer.this) ;
        //RecyclerView.LayoutManager lm = new LinearLayoutManager(hotel_viewer.this);

        RecyclerView.LayoutManager ln;
        ln = new LinearLayoutManager(hotel_viewer.this ) ;

        rv.setHasFixedSize(false);
        rv.setLayoutManager(ln);
        rv.setAdapter(adapter);


    }
}