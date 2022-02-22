package com.example.travelo_app;

import java.util.Comparator;

public class sort_hotel_by_rate implements Comparator<Hotel> {



        // Used for sorting in ascending order of
        // roll number
        public int compare(Hotel a, Hotel b)
        {
            return a.getRate() - b.getRate();
        }


}
