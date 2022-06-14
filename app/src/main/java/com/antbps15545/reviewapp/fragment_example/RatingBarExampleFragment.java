package com.antbps15545.reviewapp.fragment_example;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.antbps15545.reviewapp.R;

import java.util.ArrayList;
import java.util.List;


public class RatingBarExampleFragment extends Fragment {

    private RatingBar ratingBarYours;
    private RatingBar ratingBarAll;

    private Button buttonSubmit;

    private TextView textViewYourCurrentRating;
    private TextView textViewRatingCount;
    private TextView textViewSumAllRating;
    private TextView textViewAverageAllRating;
    View view;
    private List<Float> allRatings = new ArrayList<Float>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rating_bar_example, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.buttonSubmit = (Button)view.findViewById(R.id.button_submit);
        this.ratingBarYours = (RatingBar) view.findViewById(R.id.ratingBar_yours);
        this.ratingBarAll = (RatingBar) view.findViewById(R.id.ratingBar_all);

        this.textViewYourCurrentRating = (TextView)view.findViewById(R.id.textView_yourCurrentRating);
        this.textViewRatingCount= (TextView)view.findViewById(R.id.textView_ratingCount);
        this.textViewSumAllRating= (TextView)view.findViewById(R.id.textView_sumAllRating);
        this.textViewAverageAllRating= (TextView)view.findViewById(R.id.textView_averageAllRating);
        this.ratingBarYours.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                textViewYourCurrentRating.setText("Your current Rating: " + rating);
            }
        });
        this.buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doSubmit();
            }
        });
    }
    private void doSubmit()  {
        float rating = this.ratingBarYours.getRating();
        this.allRatings.add(rating);

        int ratingCount = this.allRatings.size();
        float ratingSum = 0f;
        for(Float r: this.allRatings)  {
            ratingSum += r;
        }
        float averageRating = ratingSum / ratingCount;


        this.textViewRatingCount.setText("Rating Count: " + ratingCount);
        this.textViewSumAllRating.setText("Sum off all Rating: " + ratingSum);
        this.textViewAverageAllRating.setText("Average value off all Rating: " + averageRating);

        float ratingAll = this.ratingBarAll.getNumStars() * averageRating / this.ratingBarYours.getNumStars() ;
        this.ratingBarAll.setRating(ratingAll);
    }
    }
