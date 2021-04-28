package com.ly.myviewpager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    private ViewPager vp;
    private static final String TAG = "MainActivity2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        vp = findViewById(R.id.vp);
        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new AFragment());
        list.add(new BFragment());
//        BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT  区别： 注意看onResume是否执行 打印生命周期观察
//        BEHAVIOR_SET_USER_VISIBLE_HINT

//        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(),FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,list);
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(),FragmentPagerAdapter.BEHAVIOR_SET_USER_VISIBLE_HINT,list);
        vp.setAdapter(adapter);
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {


            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.d(TAG, "onPageSelected: " + position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                //0表示什么都没做，1正在滑动，2滑动完毕
                Log.d(TAG, "onPageScrollStateChanged: " + state);
            }
        });


    }
}

class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> list = null;
    public MyFragmentPagerAdapter(@NonNull FragmentManager fm, int behavior,ArrayList<Fragment> list) {
        super(fm, behavior);
        this.list = list;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return "1234";
    }
}