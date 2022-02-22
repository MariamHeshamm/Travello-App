package com.example.travelo_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;
import static com.example.travelo_app.R.id.slide_description;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    //Array
    public int [] slide_images={
        R.drawable.sphinx,
        R.drawable.temple,
        R.drawable.diver,
        R.drawable.flight,
        R.drawable.calendar1

    };
    public String [] slide_headings={
      "Explore",
      "Discover",
      "Have fun",
      "Travel Now",
      "Trip Schedule"
    };

    public String [] slide_descriptions={
      "The unseen, Adventure awaits",
      "new Places and Cultures",
      "Find your special tour today with adventure",
      "Book your Journey now and have your new adventure",
      "Choose your trip time and enjoy"
    };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==(RelativeLayout)object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.slide_layout,container,false);

        ImageView slideImageView=view.findViewById(R.id.slide_image);
        TextView slideHeading=view.findViewById((R.id.slide_heading));
        TextView slideDescription=view.findViewById((R.id.slide_description));

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_descriptions[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
        //super.destroyItem(container, position, object);
    }
}
