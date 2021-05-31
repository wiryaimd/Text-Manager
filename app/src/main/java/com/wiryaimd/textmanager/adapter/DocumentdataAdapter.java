package com.wiryaimd.textmanager.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wiryaimd.textmanager.Documentdata;
import com.wiryaimd.textmanager.R;

import java.util.ArrayList;
import java.util.List;

/**
 * recyclerview biasa doang nioh bos
 */
public class DocumentdataAdapter extends RecyclerView.Adapter<DocumentdataAdapter.MyHolder> {

    private Activity activity;
    private List<Documentdata> allDocumentdata = new ArrayList<>();

    public DocumentdataAdapter(Activity activity) {
        this.activity = activity;
//        this.allDocumentdata = allDocumentdata;
    }

    /**
     * untuk set documentdata list kemudian meng notify agar di reload
     */
    public void setAllDocumentdata(List<Documentdata> allDocumentdata){
        this.allDocumentdata = allDocumentdata;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DocumentdataAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.documentdata_item, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DocumentdataAdapter.MyHolder holder, int position) {
        Documentdata documentdata = allDocumentdata.get(position);
        holder.title.setText(documentdata.getTitle());
        holder.text.setText(documentdata.getText());
    }

    @Override
    public int getItemCount() {
        return allDocumentdata.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        private TextView title, text;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.documentdata_item_title);
            text = itemView.findViewById(R.id.documentdata_item_text);
        }
    }
}
