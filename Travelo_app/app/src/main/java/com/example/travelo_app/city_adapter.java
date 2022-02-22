package com.example.travelo_app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

import static androidx.core.content.ContextCompat.startActivity;

public class city_adapter extends RecyclerView.Adapter <city_adapter.city_viewer_holder> {

    ArrayList<city> cities;
    Context c;
    String user_id;
    public city_adapter(ArrayList<city> cities,Context c,String user_id) {
        this.cities = cities;
        this.c=c;
        this.user_id=user_id;


    }

    class city_viewer_holder extends RecyclerView.ViewHolder{

        ImageSlider slider ;

        public city_viewer_holder(@NonNull View itemView) {
            super(itemView);
            slider = itemView.findViewById(R.id.slider) ;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    city h = cities.get(position);

                    Intent intent = new Intent(c , hotel_viewer.class) ;
                    Bundle bundle = new Bundle();
                    bundle.putString("ID", user_id);
                    intent.putExtras(bundle);
                    startActivity( c , intent , new Bundle());

                }
            });

        }
    }

    @NonNull
    @Override
    public city_viewer_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.mini_city , null , false) ;
        city_viewer_holder holder = new city_viewer_holder(v );
        return holder ;
    }

    @Override
    public void onBindViewHolder(@NonNull city_viewer_holder holder, int position) {

        city c = cities.get(position) ;

        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel( c.getImage1() , c.getCity_name() ) );
        slideModels.add(new SlideModel( c.getImage2() , c.getCity_name() ) );
        slideModels.add(new SlideModel( c.getImage3() , c.getCity_name() ) );
        slideModels.add(new SlideModel( c.getImage4() , c.getCity_name() ) );

        holder.slider.setImageList(slideModels , true);

    }

    @Override
    public int getItemCount() {
        return cities.size();
    }
}
