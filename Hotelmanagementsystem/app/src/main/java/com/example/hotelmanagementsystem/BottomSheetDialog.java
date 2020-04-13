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

public class BottomSheetDialog extends BottomSheetDialogFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.bottomsheetdialog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Defining Id's..
        final TextView hotelname = view.findViewById(R.id.book_title);
        final EditText name = view.findViewById(R.id.Customer_name);
        final EditText Quan = view.findViewById(R.id.quan);
        final EditText email = view.findViewById(R.id.email);
        final EditText issue_up_to = view.findViewById(R.id.Issue_Up_to);
        Button proceed = view.findViewById(R.id.proceed);


        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDataBase myDataBase = new MyDataBase(getContext());
                String id = Quan.getText().toString();
                int quants = Integer.parseInt(id);

                String issue = issue_up_to.getText().toString();
                int Bookedupto = Integer.parseInt(issue);


                myDataBase.insertValues(hotelname.getText().toString().trim(), name.getText().toString().trim(),
                        quants, email.getText().toString().trim(), Bookedupto
                );


            }

        });

    }
}
