package com.example.travelo_app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link whishlist_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class whishlist_fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    RecyclerView rv ;
    wishlist_adapter adapter ;
    DatabaseHelper db ;
    ArrayList<Hotel> hotels ;


    int USER_ID = 1 ;

    public whishlist_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment whishlist_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static whishlist_fragment newInstance(String param1, String param2) {
        whishlist_fragment fragment = new whishlist_fragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_wishlist_viewer, container, false);
        rv = view.findViewById(R.id.wishlist_recyler) ;
        db = new DatabaseHelper(whishlist_fragment.super.getActivity()) ;


        hotels = db.get_liked_hotel(USER_ID);


        adapter = new wishlist_adapter(hotels , USER_ID , whishlist_fragment.super.getActivity());


        RecyclerView.LayoutManager ln;
        ln = new LinearLayoutManager(whishlist_fragment.super.getActivity()) ;

        rv.setHasFixedSize(false);
        rv.setLayoutManager(ln);
        rv.setAdapter(adapter);

        return view;
    }
}