package com.example.travelo_app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static androidx.core.content.ContextCompat.startActivity;

//import static androidx.core.graphics.drawable.IconCompat.getResources;

public class wishlist_adapter extends RecyclerView.Adapter<wishlist_adapter.hotel_view_holder> {
    ArrayList<Hotel> hotel;
    ArrayList<Wish> wishs;
    Context c;
    DatabaseHelper db;
    int userID;

    public wishlist_adapter(ArrayList<Hotel> hotel, int userID, Context c) {
        this.hotel = hotel;
        this.userID = userID;
        this.c = c;
        db = new DatabaseHelper(c);
        this.wishs = db.get_wishes_for_selected_user(this.userID);
    }

    class hotel_view_holder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView price;
        TextView rate;
        TextView name;
        Button like_btn;

        public hotel_view_holder(@NonNull View itemView) {
            super(itemView);

            this.image = itemView.findViewById(R.id.custom_hotel_image);
            this.name = itemView.findViewById(R.id.custom_hotel_name_tv);
            this.price = itemView.findViewById(R.id.custom_hotel_price);
            this.rate = itemView.findViewById(R.id.custom_hotel_rate);
            this.like_btn = itemView.findViewById(R.id.like_btn);




        }
    }

    public Boolean check(Hotel h) {
        boolean flag = false;

        if (wishs.size() > 0) {
            for (int i = 0; i < wishs.size(); i++) {
                if (h.getID() == wishs.get(i).getHotel_id()) {

                    flag = true;
                    break;
                }

            }
        }


        return flag;
    }

    @NonNull
    @Override
    public hotel_view_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.hotel_card_view, null, false);
        hotel_view_holder viewholder = new hotel_view_holder(v);


        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull hotel_view_holder holder, int position) {


        Hotel h = hotel.get(position);


        holder.name.setText(h.getName());


        // @SuppressLint("UseCompatLoadingForDrawables") Drawable d = getResources().getDrawable(h.getMain_IMG() , this);
        if (h.getID() == 1)
        {
            holder.image.setImageResource(R.drawable.kempinski_main);
        }
        else if (h.getID() ==2)
        {
            holder.image.setImageResource(R.drawable.sunrise_main);
        }
        else if (h.getID() ==3)
        {
            holder.image.setImageResource(R.drawable.steigenberger_main);
        }
        else if (h.getID() ==4)
        {
            holder.image.setImageResource(R.drawable.continental_main);
        }


        holder.rate.setText(String.valueOf(h.getRate()));
        holder.price.setText(String.valueOf(h.getPrice()));


        if (check(h)) {
            holder.like_btn.setBackgroundResource(R.drawable.ic_baseline_favorite_red_24);
        } else {
            holder.like_btn.setBackgroundResource(R.drawable.ic_baseline_favorite_black_24);
        }


    }

    @Override
    public int getItemCount() {
        return hotel.size();
    }
}
