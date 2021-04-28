package com.ly.myviewpager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {
    private ViewPager2 vp;

    List<Fragment> fragments = new ArrayList<>();
    List<String> titles = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        vp = findViewById(R.id.vp);

        //这样写会造成内存泄露 数组中强引用了fragment  而viewpager无法销毁
        fragments.add(AFragment.newInstance("11111", "11111"));
        fragments.add(BFragment.newInstance("22222", "22222"));
        fragments.add(CFragment.newInstance("33333", "33333"));
        fragments.add(DFragment.newInstance("11111", "11111"));
        fragments.add(EFragment.newInstance("22222", "22222"));
        fragments.add(FFragment.newInstance("33333", "33333"));
        titles.add("fragment1");
        titles.add("fragment2");
        titles.add("fragment3");
//        vp.setAdapter(new FragmentStateAdapter(this) {
//            @NonNull
//            @Override
//            public Fragment createFragment(int position) {
//                return fragments.get(position);
//            }
//
//            @Override
//            public int getItemCount() {
//                return fragments.size();
//            }
//        });

        vp.setAdapter(new RecyclerView.Adapter() {
            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.v2_content,parent,false);
                return new MyViewHolder(view);
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
                MyViewHolder h = (MyViewHolder) holder;
                h.tv.setText(titles.get(position));
            }

            @Override
            public int getItemCount() {
                return titles.size();
            }

            class MyViewHolder extends RecyclerView.ViewHolder {
                public TextView tv;

                public MyViewHolder(@NonNull View itemView) {
                    super(itemView);
                    tv = itemView.findViewById(R.id.tv);
                }
            }

        });


    }
}