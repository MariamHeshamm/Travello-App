package com.example.travelo_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public class NavigationMenuActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle mToggle;
    private NavigationView navigationView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_menu);

       toolbar= (Toolbar) findViewById(R.id.toolbar);
       setSupportActionBar(toolbar);

        navigationView=(NavigationView) findViewById(R.id.drawer_nav);

        drawerLayout=(DrawerLayout)findViewById(R.id.drawer);
        mToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.Open,R.string.Close);
        drawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch ((item.getItemId()))
                {
                    case R.id.Profile:
                        Toast.makeText(getApplicationContext(),"profile",Toast.LENGTH_LONG).show();
                        Intent sliderIntent = new Intent(NavigationMenuActivity.this, HotelDescriptionActivity.class);
                        startActivity(sliderIntent);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.Whishlist:
                        Toast.makeText(getApplicationContext(),"whishlist",Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.History:
                        Toast.makeText(getApplicationContext(),"history",Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }
                return  true;
            }
        });
    }





}