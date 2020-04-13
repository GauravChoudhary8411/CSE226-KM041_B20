package com.example.hotelmanagementsystem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class AccountFragment extends Fragment {
    View v;
    ListView lst;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.account_fragment,container,false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lst=getView().findViewById(R.id.listView);

        final MyDataBase md= new MyDataBase(getActivity());
        ArrayList<String> al=md.showValues();
        ArrayAdapter ad =new ArrayAdapter<>(getContext(),R.layout.textview,al);
        lst.setAdapter(ad);
    }
}

