package com.example.hotelmanagementsystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context mContext;
    List<Home> mHome;

    public RecyclerViewAdapter(Context mContext, List<Home> mHome) {
        this.mContext = mContext;
        this.mHome = mHome;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.hotel_list, parent, false);
        final MyViewHolder myViewHolder = new MyViewHolder(v);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bookName.setText(mHome.get(position).getBookName());
        holder.bookAuthor.setText(mHome.get(position).getBookAuthor());
        holder.book_image.setImageResource(mHome.get(position).getHotelImage());
    }

    @Override
    public int getItemCount() {
        return mHome.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final Context mContext;
        private TextView bookName;
        private TextView bookAuthor;
        private Button bookIssue;
        private ImageView book_image;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            bookName = itemView.findViewById(R.id.bookName);
            bookAuthor = itemView.findViewById(R.id.author_Name);
            book_image = itemView.findViewById(R.id.book_image);
            bookIssue = itemView.findViewById(R.id.Issue_Book);

            mContext = itemView.getContext();
            bookIssue.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            BottomSheetDialogFragment bottomSheetDialogFragment;

            switch (getLayoutPosition()) {
                case 0: {
                    bottomSheetDialogFragment =new BottomSheetDialog();
                    bottomSheetDialogFragment.show(((FragmentActivity) mContext).getSupportFragmentManager(), bottomSheetDialogFragment.getTag());
                    bottomSheetDialogFragment.setStyle(DialogFragment.STYLE_NORMAL, R.style.BottomSheetDialogTheme); //for transparent background
                    break;
                }
                case 1: {
                    bottomSheetDialogFragment =new BottomSheetDialogTwo();
                    bottomSheetDialogFragment.show(((FragmentActivity) mContext).getSupportFragmentManager(), bottomSheetDialogFragment.getTag());
                    bottomSheetDialogFragment.setStyle(DialogFragment.STYLE_NORMAL, R.style.BottomSheetDialogTheme); //for transparent background
                    break;
                }
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7: {
                    Toast.makeText(mContext, "Try Booking First Two Hotels", Toast.LENGTH_LONG).show();
                    break;
                }
            }
        }
    }
}
