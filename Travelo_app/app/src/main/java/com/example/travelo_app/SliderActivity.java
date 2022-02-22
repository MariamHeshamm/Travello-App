package com.example.travelo_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class SliderActivity extends AppCompatActivity {

    private LinearLayout dotLayout;
    private ViewPager sliderViewPager;
    private SliderAdapter sliderAdapter;
    private TextView[] Dots;
    private Button GetStarted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);
        GetStarted=findViewById(R.id.get_started_btn);
        sliderViewPager = (ViewPager) findViewById(R.id.slider_view_layout);
        dotLayout = (LinearLayout) findViewById(R.id.dots_layout);

        SharedPreferences sharedPreferences=getSharedPreferences("com.example.travelo_app.name",MODE_PRIVATE);
        String FirstTimeInApp=sharedPreferences.getString("FirstTime","");

        if(FirstTimeInApp.equals("Yes"))
        {
            Intent intent=new Intent(SliderActivity.this,LoginActivity.class);
            startActivity(intent);
        }
        else{
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putString("FirstTime","Yes");
            editor.apply();
        }

        sliderAdapter = new SliderAdapter(this);

        sliderViewPager.setAdapter(sliderAdapter);

        sliderViewPager.addOnPageChangeListener(viewListener);
        //addDotsIndicator(0);

        GetStarted.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent LogInIntent = new Intent(SliderActivity.this, com.example.travelo_app.LoginActivity.class);
                startActivity(LogInIntent);

                finish();
            }
        });

    }

    public void addDotsIndicator(int position)
    {
        Dots=new TextView[5];
        dotLayout.removeAllViews();
        for(int i = 0; i<Dots.length; i++)
        {
            Dots[i]=new TextView(this);
            Dots[i].setText(Html.fromHtml("&#8226;"));
            Dots[i].setTextSize(50);
            Dots[i].setTextColor(getResources().getColor(R.color.logo_background));



            dotLayout.addView(Dots[i]);
        }
        if(Dots.length>0)
        {
            Dots[position].setTextColor(getResources().getColor(R.color.indecator_inactive));
        }
    }
    ViewPager.OnPageChangeListener viewListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDotsIndicator(position);

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}