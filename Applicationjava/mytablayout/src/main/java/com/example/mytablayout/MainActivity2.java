package com.example.mytablayout;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class MainActivity2 extends AppCompatActivity {
    TabLayout tl ;
    TabLayout tabLayout4;
    private final String[] mTitles = {
            "上海", "头条推荐", "生活", "娱乐八卦", "体育",
            "段子", "美食", "电影", "科技", "搞笑",
            "社会", "财经", "时尚", "汽车", "军事",
            "小说", "育儿", "职场", "萌宠", "游戏",
            "健康", "动漫", "互联网"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tl = findViewById(R.id.tab_layout3);
        tl.setTabMode(TabLayout.MODE_SCROLLABLE);

        tabLayout4 = findViewById(R.id.tab_layout4);

        for(int i = 0;i<mTitles.length;i++){
            String item = mTitles[i];
            TabLayout.Tab tab = tl.newTab();
            tab.setTag(item);
            tab.setText(item);
            tl.addTab(tab);
        }

        //监听事件
        tl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //选中了tab的逻辑

                Log.i("tag","======我选中了===="+tab.getTag());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //未选中tab的逻辑
                Log.i("tag","======我未被选中===="+tab.getTag());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                //再次选中tab的逻辑
                Log.i("tag","======我再次被选中===="+tab.getTag());
            }
        });


        for (int i = 0; i < tabLayout4.getTabCount(); i++){
            TabLayout.Tab tab = tabLayout4.getTabAt(i);
            if (tab != null){
                tab.setCustomView(getItemView(i));
                if (i == 0){
                    TextView tv = tab.getCustomView().findViewById(R.id.tv_title);
                    tv.setTextColor(getResources().getColor(R.color.design_default_color_primary_variant));
                    tv.setTextSize(15);
                }
            }
        }

        //监听事件
        tabLayout4.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //选中了tab的逻辑

                Log.i("tag","======我选中了===="+tab.getTag());
                TextView tv = tab.getCustomView().findViewById(R.id.tv_title);
                tv.setTextColor(getResources().getColor(R.color.design_default_color_primary_variant));
                tv.setTextSize(15);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //未选中tab的逻辑
                Log.i("tag","======我未被选中===="+tab.getTag());
                TextView tv = tab.getCustomView().findViewById(R.id.tv_title);
                tv.setTextColor(getResources().getColor(R.color.black));
                tv.setTextSize(13);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                //再次选中tab的逻辑
                Log.i("tag","======我再次被选中===="+tab.getTag());
            }
        });


    }


    public View getItemView(int postion){
        View v = LayoutInflater.from(this).inflate(R.layout.custom_tab_item,null);
        ImageView imageView = v.findViewById(R.id.imageView);
        TextView tv = v.findViewById(R.id.tv_title);
        tv.setText(mTitles[postion]);
        return v;
    }

}