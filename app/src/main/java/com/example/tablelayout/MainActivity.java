package com.example.tablelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.tablelayout.Fragments.FirstFragment;
import com.example.tablelayout.Fragments.MainFragment;
import com.example.tablelayout.Fragments.SecondFragment;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    //On Instencie le FragmentManger
    FragmentManager fragmentManager = null;
    FirstFragment firstFragment;
    SecondFragment secondFragment;
    MainFragment mainFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //On instancie els fragments
        mainFragment = new MainFragment();
        firstFragment = new FirstFragment();
        secondFragment = new SecondFragment();

        //On instancie et declare les widgets
        TabLayout tabLayout = findViewById(R.id.tllTableLayout);
        FrameLayout frameLayout = findViewById(R.id.frmMain);

        //On declare le fragmentManager
        fragmentManager = getFragmentManager();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }
}
