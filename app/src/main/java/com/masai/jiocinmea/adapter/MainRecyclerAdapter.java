package com.masai.jiocinmea.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.masai.jiocinmea.R;
import com.masai.jiocinmea.model.AllCategory;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.MainViewHolder>{
    Context context;
    List<AllCategory> allCategoryList;

    public MainRecyclerAdapter(Context context, List<AllCategory> allCategoryList) {
        this.context = context;
        this.allCategoryList = allCategoryList;
    }

    @NonNull
    @NotNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.main_recycler_row_item,parent,false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MainViewHolder holder, int position) {
    holder.categoryName.setText(allCategoryList.get(position).getCategoryTitle());
    }

    @Override
    public int getItemCount() {
        return allCategoryList.size();
    }
//ViewHolder Class
    public static  final class MainViewHolder extends RecyclerView.ViewHolder{
         private TextView categoryName;
        public MainViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            categoryName =itemView.findViewById(R.id.item_category);
        }
    }

}
