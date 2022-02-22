package com.example.travelo_app;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link city_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class city_fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    RecyclerView rv;
    city_adapter adapter;
    ArrayList<city> cities;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public city_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment city_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static city_fragment newInstance(String param1, String param2) {
        city_fragment fragment = new city_fragment();
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

        View view = inflater.inflate(R.layout.activity_city_viewer, container, false);
        Bundle bundle=this.getArguments();
        String id=bundle.getString("ID");
        //Toast.makeText(this.getActivity(), "ID"+id, Toast.LENGTH_SHORT).show();

        rv = view.findViewById(R.id.city_recyler);

        cities = new ArrayList<>();

        //add cites here

        cities.add(new city("Hurghada", "https://upload.wikimedia.org/wikipedia/commons/thumb/8/82/Alig_walk_way_hurghada_egypt_629.jpg/220px-Alig_walk_way_hurghada_egypt_629.jpg", "https://i.pinimg.com/236x/bf/5f/ea/bf5feafda6d3dd7a3606fb964c19cf61.jpg", "https://i.pinimg.com/236x/5c/c4/7a/5cc47aa133c9fc53c184f58d8aa11350.jpg", "https://i.pinimg.com/236x/95/2f/b3/952fb33d17698fbabdf2bd83240b545f.jpg"));
        cities.add(new city ("Sharm El Sheikh" , "https://i.pinimg.com/236x/85/32/01/8532015072a0dc4c1b424b7de7efdd17.jpg"  , "https://i.pinimg.com/236x/93/59/0f/93590f26306825debb3f47041c6c16e5.jpg" , "https://upload.wikimedia.org/wikipedia/commons/thumb/8/82/Alig_walk_way_hurghada_egypt_629.jpg/220px-Alig_walk_way_hurghada_egypt_629.jpg" , "https://upload.wikimedia.org/wikipedia/commons/thumb/8/82/Alig_walk_way_hurghada_egypt_629.jpg/220px-Alig_walk_way_hurghada_egypt_629.jpg") );
        cities.add(new city ("Cairo" , "https://i.pinimg.com/236x/cb/80/1b/cb801bc9a78eb837b29c7f4ebe142074.jpg"  , "https://upload.wikimedia.org/wikipedia/commons/thumb/8/82/Alig_walk_way_hurghada_egypt_629.jpg/220px-Alig_walk_way_hurghada_egypt_629.jpg" , "https://upload.wikimedia.org/wikipedia/commons/thumb/8/82/Alig_walk_way_hurghada_egypt_629.jpg/220px-Alig_walk_way_hurghada_egypt_629.jpg" , "https://upload.wikimedia.org/wikipedia/commons/thumb/8/82/Alig_walk_way_hurghada_egypt_629.jpg/220px-Alig_walk_way_hurghada_egypt_629.jpg") );
        cities.add(new city ("Sinai" , "https://i.pinimg.com/236x/df/8f/e0/df8fe07316637565451185f9dc79607b.jpg"  , "https://i.pinimg.com/236x/c0/af/39/c0af39b00388a83f89528d4822aed656.jpg" , "https://upload.wikimedia.org/wikipedia/commons/thumb/8/82/Alig_walk_way_hurghada_egypt_629.jpg/220px-Alig_walk_way_hurghada_egypt_629.jpg" , "https://upload.wikimedia.org/wikipedia/commons/thumb/8/82/Alig_walk_way_hurghada_egypt_629.jpg/220px-Alig_walk_way_hurghada_egypt_629.jpg") );



        adapter = new city_adapter(cities, city_fragment.super.getActivity(),id);

        RecyclerView.LayoutManager ln;
        ln = new LinearLayoutManager(city_fragment.super.getActivity());

        rv.setHasFixedSize(true);
        rv.setLayoutManager(ln);
        rv.setAdapter(adapter);



        return  view;

    }

}