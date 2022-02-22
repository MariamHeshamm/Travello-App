package com.example.travelo_app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import static com.example.travelo_app.R.drawable.ic_baseline_favorite_black_24;
import static com.example.travelo_app.R.drawable.ic_baseline_favorite_red_24;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link hotel_description_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class hotel_description_fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabItem information,location;
    PagerAdapter pagerAdapter;
    Button wish;
    TextView hotelName;
    TextView rate;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public hotel_description_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment hotel_description_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static hotel_description_fragment newInstance(String param1, String param2) {
        hotel_description_fragment fragment = new hotel_description_fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_hotel_description, container, false);
        int hotel_ID =1; // as a start make the value equals 1
        int user_ID=2;
        DatabaseHelper d = new DatabaseHelper(hotel_description_fragment.super.getActivity());
        Hotel h = d.get_all_hotels().get(0);
        ImageSlider imageSlider=view.findViewById(R.id.Slider_Image);
        List<SlideModel> slideModels=new ArrayList<>();

        slideModels.add(new SlideModel(h.getImg_one()," "));
        slideModels.add(new SlideModel(h.getImg_two()," "));
        slideModels.add(new SlideModel(h.getImg_three()," "));
        imageSlider.setImageList(slideModels,true);

        hotelName=view.findViewById(R.id.hotel_name);
        rate=view.findViewById(R.id.Rate);
        wish.findViewById(R.id.Whishlist_btn);
        hotelName.setText(h.getName());
        rate.setText((String.valueOf(h.getRate())));

        if(d.hotel_is_liked(hotel_ID,user_ID))
        {
            wish.setBackgroundResource(ic_baseline_favorite_red_24);
        }
        else
        {
            wish.setBackgroundResource(ic_baseline_favorite_black_24);
        }



        // Inflate the layout for this fragment
        return view;
    }
}