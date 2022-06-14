package com.antbps15545.reviewapp.fragment_example;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;
import com.antbps15545.reviewapp.R;


public class PopupMenuExampleFragment extends Fragment {
    public static final String LOG_TAG =  "PopupMenuExample";
    View view;
    private Button button1;
    private Button button2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_popup_menu_example, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.button1 = (Button)view.findViewById(R.id.button1);
        this.button2 = (Button)view.findViewById(R.id.button2);

        this.button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                button1Clicked( );
            }
        });
    }

    // User click on the Button 1.
    private void button1Clicked( )  {
        // When user click on the Button 1, create a PopupMenu.
        // And anchor Popup to the Button 2.
        PopupMenu popup = new PopupMenu(getContext(),this.button2);
        popup.inflate(R.menu.layout_popup_menu);

        Menu menu = popup.getMenu();
        // com.android.internal.view.menu.MenuBuilder
        Log.i(LOG_TAG, "Menu class: " + menu.getClass().getName());

        // Register Menu Item Click event.
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return menuItemClicked(item);
            }
        });

        // Show the PopupMenu.
        popup.show();
    }

    // When user click on Menu Item.
    // @return true if event was handled.
    private boolean menuItemClicked(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuItem_bookmark:
                Toast.makeText(getContext(), "Bookmark", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuItem_upload:
                Toast.makeText(getContext(), "Upload", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuItem_facebook:
                Toast.makeText(getContext(), "Share Facebook", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuItem_instagram:
                Toast.makeText(getContext(), "Share Instagram", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(getContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

}