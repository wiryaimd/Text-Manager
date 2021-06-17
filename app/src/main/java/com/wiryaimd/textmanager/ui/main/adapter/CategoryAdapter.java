package com.wiryaimd.textmanager.ui.main.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wiryaimd.textmanager.R;
import com.wiryaimd.textmanager.db.models.CategoryModel;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyHolder> {

    List<CategoryModel> categoryModelList = new ArrayList<>();

    @NonNull
    @Override
    public CategoryAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.MyHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return categoryModelList.size() + 2;
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        public MyHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
