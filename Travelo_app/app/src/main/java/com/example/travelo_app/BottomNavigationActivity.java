package com.example.travelo_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class BottomNavigationActivity extends AppCompatActivity {


    String id="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_bar);
        bottomNavigationView.setOnCreateContextMenuListener(new city_fragment());
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            id = bundle.getString("ID", "");
            //Toast.makeText(this, "ID"+id, Toast.LENGTH_SHORT).show();
        }





       /* bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch ((item.getItemId()))
                {
                    case R.id.Home:
                        startActivity(new Intent(getApplicationContext(),city_viewer.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.Whishlist:
                        startActivity(new Intent(getApplicationContext(),hotel_viewer.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.History:
                        startActivity(new Intent(getApplicationContext(),city_viewer.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return true;
            }
        });*/
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch ((item.getItemId())) {
                        case R.id.Whishlist:
                            selectedFragment = new whishlist_fragment();
                            break;
                        case R.id.Home:
                            selectedFragment = new city_fragment();

                            break;
                        case R.id.History:
                            selectedFragment = new city_fragment();
                            break;

                    }
                    //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                    //Intent intent = new Intent(BottomNavigationActivity.this, selectedFragment.getClass());
                    Bundle bundle = new Bundle();
                    bundle.putString("ID",id);
                    selectedFragment.setArguments(bundle);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
                    //startActivity(intent);
                    return true;

                }
            };
}
