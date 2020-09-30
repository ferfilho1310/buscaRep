package com.example.buscarep.mvc.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.example.buscarep.Enums.SharedEnums;
import com.example.buscarep.FragmentPageAdapter.PageAdapter;
import com.example.buscarep.R;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    PageAdapter pageAdapter;
    TabLayout tabLayout;
    ViewPager vpPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Fernando Filho");
        getSupportActionBar().setSubtitle("Moema");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources()
                .getColor(R.color.colorPrimaryDark)));

        vpPager = findViewById(R.id.vpPager);
        tabLayout = findViewById(R.id.tabLayout);

        pageAdapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        vpPager.setAdapter(pageAdapter);
        tabLayout.setupWithViewPager(vpPager);
        tabLayout.getTabAt(SharedEnums.numeroTab.firstTab).setIcon(R.drawable.ic_baseline_house_24);
        tabLayout.getTabAt(SharedEnums.numeroTab.secondTab).setIcon(R.drawable.ic_baseline_event_24);

        vpPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}