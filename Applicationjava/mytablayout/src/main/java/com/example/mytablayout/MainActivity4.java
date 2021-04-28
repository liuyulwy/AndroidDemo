package com.example.mytablayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class MainActivity4 extends AppCompatActivity {
    private ViewPager2 vp;
    private TabLayout tl;
    private TabLayoutMediator tabLayoutMediator;
    private ArrayList<String> mTitles = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        vp = findViewById(R.id.vp);
        tl = findViewById(R.id.tl);
        tl.setTabMode(TabLayout.MODE_SCROLLABLE);

        mTitles.add("tab1");
        mTitles.add("tab2");
        mTitles.add("tab3");
        mTitles.add("tab4");
        mTitles.add("tab5");
        vp.setAdapter(new FragmentStateAdapter(this) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                return new BlankFragment();
            }

            @Override
            public int getItemCount() {
                return mTitles.size();
            }

        });

        tabLayoutMediator = new TabLayoutMediator(tl, vp, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
//                tab.setText(mTitles.get(position));
                tab.setCustomView(getItemView(position));//自定义view
            }
        });
        tabLayoutMediator.attach();//绑定

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        tabLayoutMediator.detach();//解绑
    }

    public View getItemView(int postion){
        View v = LayoutInflater.from(this).inflate(R.layout.custom_tab_item,null);
        ImageView imageView = v.findViewById(R.id.imageView);
        TextView tv = v.findViewById(R.id.tv_title);
        tv.setText(mTitles.get(postion));
        return v;
    }
}