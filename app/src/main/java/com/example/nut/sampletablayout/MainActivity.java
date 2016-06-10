package com.example.nut.sampletablayout;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.main_tab_layout)
    TabLayout mainTabLayout;
    @BindView(R.id.main_view_pager)
    ViewPager mainViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragments(HomeFragment.newInstance(), "Home");
        viewPagerAdapter.addFragments(TopFreeFragment.newInstance(), "Top Free");
        viewPagerAdapter.addFragments(TopPaidFragment.newInstance(), "Top Paid");
        mainViewPager.setAdapter(viewPagerAdapter);
        mainViewPager.setOffscreenPageLimit(3);
        mainTabLayout.setupWithViewPager(mainViewPager);
    }
}
