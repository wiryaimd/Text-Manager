package com.wiryaimd.textmanager.ui.main.posts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wiryaimd.textmanager.R;
import com.wiryaimd.textmanager.models.PostsModel;

import java.util.ArrayList;
import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.MyHolder>{

    private List<PostsModel> postsModels = new ArrayList<>();

    public void setPosts(List<PostsModel> posts){
        this.postsModels = posts;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PostsAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_posts, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  PostsAdapter.MyHolder holder, int position) {
        holder.tvtitle.setText(postsModels.get(position).getTitle());
        holder.tvdesc.setText(postsModels.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return postsModels.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        public TextView tvtitle, tvdesc;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            tvtitle = itemView.findViewById(R.id.postsitem_title);
            tvdesc = itemView.findViewById(R.id.postsitem_desc);
        }
    }
}
