package com.antbps15545.reviewapp.fragment_example;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.antbps15545.reviewapp.R;
import com.google.android.material.snackbar.Snackbar;

public class SnackBarExampleFragment extends Fragment {

    private Button button1;
    private Button button2;
    private Button button3;
    private View baseView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_snack_bar_example, container, false);
        return view;

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.baseView = view.findViewById(R.id.constraintLayout);

        this.button1 = (Button) view.findViewById(R.id.button1);
        this.button2 = (Button) view.findViewById(R.id.button2);
        this.button3 = (Button) view.findViewById(R.id.button3);

        this.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSnackbarDefault();
            }
        });
        this.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSnackbarActionCall();
            }
        });
        this.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSnackbarCustom();
            }
        });
    }

    private void showSnackbarDefault()  {
        Snackbar snackbar = Snackbar
                .make(this.baseView, "Install successful!", Snackbar.LENGTH_LONG);
        // Show
        snackbar.show();
    }

    private void showSnackbarActionCall() {

        Snackbar snackbar = Snackbar
                .make(this.baseView, "Message is deleted", Snackbar.LENGTH_LONG)
                .setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Show another Snackbar.
                        Snackbar snackbar1 = Snackbar.make(baseView, "Message is restored!", Snackbar.LENGTH_SHORT);
                        snackbar1.show();
                    }
                });

        snackbar.show();
    }


    private void showSnackbarCustom() {
        Snackbar snackbar = Snackbar
                .make(this.baseView, "Try again!", Snackbar.LENGTH_LONG)
                .setAction("RETRY", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    }
                });
        snackbar.setActionTextColor(Color.RED);
        View sbView = snackbar.getView();
        TextView textView = sbView.findViewById(com.google.android.material.R.id.snackbar_text);
        textView.setTextColor(Color.YELLOW);
        // Align center.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        } else {
            textView.setGravity(Gravity.CENTER_HORIZONTAL);
        }
        // Show Sneckbar
        snackbar.show();
    }
}


