package com.example.hotelmanagementsystem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheetDialogTwo extends BottomSheetDialogFragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.bottomsheetdialogtwo, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final TextView hotelName = view.findViewById(R.id.hotel_Name);
        final EditText name = view.findViewById(R.id.Customers_name);
        final EditText quans = view.findViewById(R.id.quants);
        final EditText email = view.findViewById(R.id.email);
        final EditText book_up_to = view.findViewById(R.id.book_Up_to);
        Button proceed = view.findViewById(R.id.proceed);


        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDataBase myDataBase = new MyDataBase(getContext());

                //Converting Student id integer to string
                String id= quans.getText().toString();
                int quantity=Integer.parseInt(id);

                //Converting Issued Date integer to string
                String issue= book_up_to.getText().toString();
                int ReserveUpTo=Integer.parseInt(issue);


                myDataBase.insertValues(hotelName.getText().toString().trim(), name.getText().toString().trim(),
                        quantity, email.getText().toString().trim(), ReserveUpTo
                );
            }

        });
    }
}
