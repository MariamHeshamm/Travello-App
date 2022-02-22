package com.example.travelo_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;


import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.travelo_app.ui.main.fragments.InformationFragment;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.example.travelo_app.NavigationMenuActivity;

import static com.example.travelo_app.R.drawable.*;
import static com.example.travelo_app.R.drawable.ic_baseline_favorite_black_24;
import static com.example.travelo_app.R.drawable.ic_baseline_favorite_red_24;


public class HotelDescriptionActivity extends AppCompatActivity {


    private ViewPager viewPager;
    Button information,location;
    PagerAdapter pagerAdapter;
    Button Reserve;
    Button wish;
    TextView hotelName, wifi,pet,pool;
    TextView rate ,ViewTV;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_description);

        final int hotel_ID=1 ; // as a start make the value equals 1
        final int user_ID;
        final DatabaseHelper d = new DatabaseHelper(HotelDescriptionActivity.this);
        final Hotel h = d.get_all_hotels().get(0);
        Bundle bundle = getIntent().getExtras();
        user_ID = bundle.getInt("ID", -1);
        //Toast.makeText(this, "ID"+user_ID, Toast.LENGTH_SHORT).show();


        ImageSlider imageSlider=(ImageSlider)findViewById(R.id.Slider_Image);
        List<SlideModel> slideModels=new ArrayList<>();

        slideModels.add(new SlideModel(h.getImg_one()," "));
        slideModels.add(new SlideModel(h.getImg_two()," "));
        slideModels.add(new SlideModel(h.getImg_three()," "));

        imageSlider.setImageList(slideModels,true);


        information=findViewById(R.id.information_btn);
        location=findViewById(R.id.location_btn);
        Reserve=findViewById(R.id.Reserve_btn);
        hotelName=findViewById(R.id.hotel_name);
        rate=findViewById(R.id.Rate);
        wish=findViewById(R.id.Whishlist_btn);
        hotelName.setText(h.getName());
        wifi=findViewById(R.id.wifi_facility);
        pool=findViewById(R.id.pool_facility);
        pet=findViewById(R.id.pet_facility);
        rate.setText((String.valueOf(h.getRate())));


        if(d.hotel_is_liked(hotel_ID,user_ID))
        {
            wish.setBackgroundResource(ic_baseline_favorite_red_24);
        }
        else
        {
            wish.setBackgroundResource(ic_baseline_favorite_black_24);
        }
        wish.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {



                                            if (d.hotel_is_liked(hotel_ID,user_ID)){

                                                //true exist and press the button delete
                                                wish.setBackgroundResource(ic_baseline_favorite_black_24);

                                                //remove from the database
                                                d.delete_wish(user_ID , h.getID());

                                            }
                                            else {

                                                //does not exist and press the button add to the database
                                                wish.setBackgroundResource(ic_baseline_favorite_red_24);

                                                //add inside the database

                                                d.add_wish(new Wish (user_ID , h.getID()));


                                            }
                                        }
                                    }

        );
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:0,0?q=Kempinski Hotel Soma Bay, Safaga"));
                startActivity(intent);
            }
        });

        Reserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HotelDescriptionActivity.this, MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("ID", user_ID);
                bundle.putInt("Hotel_ID",hotel_ID);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
       // pagerAdapter=new com.example.travelo_app.ui.main.fragments.PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        //viewPager.setAdapter(pagerAdapter);

  //      hotelName.setText(h.getName());
//        rate.setText(h.getRate());






    }

}