package com.wiryaimd.textmanager.ui.main.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wiryaimd.textmanager.R;
import com.wiryaimd.textmanager.models.DataModel;

import java.util.ArrayList;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyHolder> {

    List<DataModel> dataModelList = new ArrayList<>();

    @NonNull
    @Override
    public DataAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_datalist, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  DataAdapter.MyHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return dataModelList.size() + 3;
    }

    public class MyHolder extends RecyclerView.ViewHolder {


        public MyHolder(@NonNull View itemView) {
            super(itemView);
        }

    }
}
