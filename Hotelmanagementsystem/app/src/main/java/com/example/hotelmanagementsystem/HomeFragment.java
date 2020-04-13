package com.example.hotelmanagementsystem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    View v;
    private RecyclerView recyclerView;
    private List<Home> listHotel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.home_fragment,container,false);

        recyclerView = v.findViewById(R.id.home_recyclerView);
        RecyclerViewAdapter recyclerViewAdapterHome = new RecyclerViewAdapter(getContext(), listHotel);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerViewAdapterHome);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listHotel = new ArrayList<>();

        listHotel.add(new Home("JW Marriot", "Hyderabad", R.drawable.mini_jw));
        listHotel.add(new Home("Oberoi Hotel", "Mumbai", R.drawable.oberoi));
        listHotel.add(new Home("Taj Hotel", "Mumbai", R.drawable.taj));
        listHotel.add(new Home("Taj Falaknuma Palace", "Hyderabad", R.drawable.taj_falaknuma));
        listHotel.add(new Home("Hotel Ananda", "Himayalas", R.drawable.ananda));
        listHotel.add(new Home("Umaid Bhawan", "Jodhpur", R.drawable.umaid));
        listHotel.add(new Home("The Oberoi Udaivillas", "Jodhpur", R.drawable.theoeroi));
    }
}

