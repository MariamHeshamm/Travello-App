package com.example.travelo_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class hotel_adapter_ii extends RecyclerView.Adapter<hotel_adapter_ii.hotel_view_holder> {
    ArrayList<Hotel> hotel;

    public hotel_adapter_ii(ArrayList<Hotel> hotel) {
        this.hotel = hotel;
    }

    class hotel_view_holder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView price;
        TextView rate;
        TextView name;

        public hotel_view_holder(@NonNull View itemView) {
            super(itemView);

            this.image = itemView.findViewById(R.id.hotel_main_image);
            this.name = itemView.findViewById(R.id.hotel_card_name_ii);
            this.price = itemView.findViewById(R.id.hotel_card_price_ii);
            this.rate = itemView.findViewById(R.id.custom_card_hotel_rate_ii);
        }
    }

    @NonNull
    @Override
    public hotel_adapter_ii.hotel_view_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.hotel_card_view2, null, false);
        hotel_adapter_ii.hotel_view_holder viewholder = new hotel_adapter_ii.hotel_view_holder(v);


        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull hotel_adapter_ii.hotel_view_holder holder, int position) {

        Hotel h = hotel.get(position);


        holder.name.setText(h.getName());


        // @SuppressLint("UseCompatLoadingForDrawables") Drawable d = getResources().getDrawable(h.getMain_IMG() , this);

        holder.image.setImageResource(R.drawable.continental_main);
        holder.rate.setText(String.valueOf(h.getRate()));
        holder.price.setText(String.valueOf(h.getPrice()));
    }

    @Override
    public int getItemCount() {
        return hotel.size();
    }
}
