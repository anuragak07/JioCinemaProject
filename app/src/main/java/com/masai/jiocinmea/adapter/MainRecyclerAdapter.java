package com.masai.jiocinmea.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.masai.jiocinmea.R;
import com.masai.jiocinmea.model.AllCategory;
import com.masai.jiocinmea.model.CategoryItem;

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
    setItemRecycler(holder.itemRecycler,allCategoryList.get(position).getCategoryItemList());

      
    }

    @Override
    public int getItemCount() {
        return allCategoryList.size();
    }
//ViewHolder Class
    public static  final class MainViewHolder extends RecyclerView.ViewHolder{
         private TextView categoryName;
         RecyclerView itemRecycler;

        public MainViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            categoryName =itemView.findViewById(R.id.item_category);
            itemRecycler=itemView.findViewById(R.id.item_recycler);
        }
    }
    private  void setItemRecycler(RecyclerView recyclerView, List<CategoryItem> categoryItemList){
        ItemRecyclerAdapter itemRecyclerAdapter =new ItemRecyclerAdapter(context,categoryItemList);
        recyclerView.setLayoutManager(new LinearLayoutManager(context,RecyclerView.HORIZONTAL,false));
        recyclerView.setAdapter(itemRecyclerAdapter);
    }

}
