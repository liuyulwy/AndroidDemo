package com.example.mytablayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {
    private ViewPager vp;
    private TabLayout tl;

    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private ArrayList<String> mTitles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        vp = findViewById(R.id.vp);
        tl = findViewById(R.id.tl);
        mFragments.add(new BlankFragment());
        mFragments.add(new BlankFragment2());
        mFragments.add(new BlankFragment3());
        mFragments.add(new BlankFragment());
        mFragments.add(new BlankFragment2());
        mFragments.add(new BlankFragment3());
        mTitles.add("首页");
        mTitles.add("发现");
        mTitles.add("我的");
        mTitles.add("首页");
        mTitles.add("发现");
        mTitles.add("我的");

        for (int i = 0; i< mTitles.size(); i++){
            TabLayout.Tab tab = tl.newTab();
            tab.setText(mTitles.get(i));
            tl.addTab(tab);
        }
//        BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT 只会在可见fragment 掉用onresume
//        BEHAVIOR_SET_USER_VISIBLE_HINT 会在设置的缓存个数中掉用掉用onresume
//        vp.setOffscreenPageLimit(1); 默认缓存为1
//        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager(),FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
//            @NonNull
//            @Override
//            public Fragment getItem(int position) {
//                return mFragments.get(position);
//            }
//
//            @Override
//            public int getCount() {
//                return mFragments.size();
//            }
//
//            @Nullable
//            @Override
//            public CharSequence getPageTitle(int position) {
//                return mTitles.get(position);
//            }
//        });
//        FragmentStatePagerAdapter 区别在于是否掉用销毁生命周期
//        FragmentPagerAdapter
        vp.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager(),FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return mTitles.get(position);
            }
        });
        tl.setupWithViewPager(vp);
    }
}