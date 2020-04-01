package com.example.tablelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.tablelayout.Fragments.FirstFragment;
import com.example.tablelayout.Fragments.MainFragment;
import com.example.tablelayout.Fragments.SecondFragment;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //On Instencie le FragmentManger et les fragments en global
    FragmentManager fragmentManager = null;
    FirstFragment firstFragment;
    SecondFragment secondFragment;
    MainFragment mainFragment;
    ArrayList<Fragment> fragments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //On instancie les fragments
        mainFragment = new MainFragment();
        firstFragment = new FirstFragment();
        secondFragment = new SecondFragment();
        fragments = new ArrayList<>();
        fragments.add(mainFragment);
        fragments.add(firstFragment);
        fragments.add(secondFragment);

        //On instancie et declare les widgets
        TabLayout tabLayout = findViewById(R.id.tllTableLayout);

        tabLayout.addTab(tabLayout.newTab().setText("Tab 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 3"));

        //On declare le fragmentManager
        fragmentManager = getFragmentManager();
        ReplaceFragment(mainFragment);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int postion = tab.getPosition();
                Fragment fragment = fragments.get(postion);
                ReplaceFragment(fragment);

                // ou commen ca :
                //ReplaceFragment(fragments.get(tab.getPosition()));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void ReplaceFragment(Fragment frag){
        //On demarre une transaction pour changer les fragments
        fragmentManager.beginTransaction()
                .replace(R.id.frmMain,frag)
                .commit();
    }
}