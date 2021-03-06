package com.antbps15545.reviewapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.antbps15545.reviewapp.R;

public class StudioFragment extends Fragment {
    View view;
    WebView wv;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_studio, container, false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Android Studio Overview");
        wv = view.findViewById(R.id.wvstudio);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadUrl("https://viblo.asia/p/gioi-thieu-lap-trinh-android-va-cai-dat-moi-truong-yMnKMvBAZ7P");
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
