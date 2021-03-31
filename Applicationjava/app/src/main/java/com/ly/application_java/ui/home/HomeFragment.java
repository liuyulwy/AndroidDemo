package com.ly.application_java.ui.home;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ly.application_java.R;
import com.ly.application_java.ui.AlertDialog.AlertDialogActivity;

import java.util.ArrayList;
import java.util.List;
class Info {
    public Info(String name, String className){
        super();
        this.className = className;
        this.name = name;
    }
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String className;
    String name;
}
public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);


        ArrayList data = new ArrayList<Info>();
        data.add(new Info("AlertDialog", "AlertDialogActivity"));


        RecyclerView rv = root.findViewById(R.id.rv_list);
        TypeAdapter adapter = new TypeAdapter(data);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 4, RecyclerView.VERTICAL, false);

        rv.setLayoutManager(layoutManager);
        rv.setAdapter(adapter);
        DividerItemDecoration mDividerItemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        Drawable mDrawable = ContextCompat.getDrawable(getContext(), R.drawable.conllection_line);
        mDividerItemDecoration.setDrawable(mDrawable);

        DividerItemDecoration mDividerItemDecoration1 = new DividerItemDecoration(getContext(), DividerItemDecoration.HORIZONTAL);
        Drawable mDrawable1 = ContextCompat.getDrawable(getContext(), R.drawable.collection_v_line);
        mDividerItemDecoration1.setDrawable(mDrawable1);

        rv.addItemDecoration(mDividerItemDecoration);
        rv.addItemDecoration(mDividerItemDecoration1);
        adapter.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(int p) {
//                Toast.makeText(getContext(), "postion:" + p, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), AlertDialogActivity.class);
                getActivity().startActivity(intent);
            }
        });
        return root;
    }

    public class TypeAdapter extends RecyclerView.Adapter<TypeAdapter.ViewHolder> {
        List<Info> list = null;
        private ItemClickListener itemClickListener = null;

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        public TypeAdapter(List<Info> list) {
            super();
            this.list = list;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.type_item_home, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.tv_title.setText(list.get(position).name);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.onItemClick(position);
                }
            });
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            public TextView tv_title = null;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                tv_title = itemView.findViewById(R.id.tv_title);
            }
        }

    }

    public interface ItemClickListener {
        void onItemClick(int p);
    }
}