package com.wiryaimd.textmanager.ui.main.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wiryaimd.textmanager.R;
import com.wiryaimd.textmanager.db.models.DataModel;

import java.util.ArrayList;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<DataModel> dataModelList = new ArrayList<>();

    public static final int HORIZONTAL = 1;
    public static final int VERTICAL = 2;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType != 1) {
            View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_datalist, parent, false);
            return new VerticalHolder(view);
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        return new HorizontalHolder(view);
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            return HORIZONTAL;
        }
        return VERTICAL;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == HORIZONTAL){

        }
    }

    @Override
    public int getItemCount() {
        return dataModelList.size() + 3;
    }

    public class HorizontalHolder extends RecyclerView.ViewHolder{

        public HorizontalHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public class VerticalHolder extends RecyclerView.ViewHolder {

        public VerticalHolder(@NonNull View itemView) {
            super(itemView);
        }

    }
}
