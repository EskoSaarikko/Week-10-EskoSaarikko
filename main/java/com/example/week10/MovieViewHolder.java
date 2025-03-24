package com.example.week10;

import android.graphics.Movie;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MovieViewHolder {



    public static class MovieHolder extends RecyclerView.ViewHolder{
        private View posterImageView;

        private TextView titleTextView;

        private  TextView yearTextView;

        private TextView GenreTextView;


        public MovieHolder(@NonNull View itemView) {
            super(itemView);
            //itemImageView = itemView.findViewById(R.id.imageViewMenuItem);
            //itemTextViewView = itemView.findViewById(R.id.textView);
        }
    }
    //public bind(Movie);
}
