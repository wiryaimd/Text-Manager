package com.wiryaimd.textmanager.ui.main.posts;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wiryaimd.textmanager.R;
import com.wiryaimd.textmanager.models.PostsModel;
import com.wiryaimd.textmanager.ui.main.MainResource;
import com.wiryaimd.textmanager.viewmodels.ViewModelProviderFactory;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class PostsFragment extends DaggerFragment {

    private static final String TAG = "PostsFragment";

    @Inject
    ViewModelProviderFactory viewModelProviderFactory;

    @Inject
    PostsAdapter adapter;

    @Inject
    LinearLayoutManager linearLayoutManager;

    private RecyclerView recyclerView;
    private PostsFragmentViewModel postsFragmentViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return getLayoutInflater().inflate(R.layout.fragment_posts, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        recyclerView = view.findViewById(R.id.posts_recyclerview);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

        postsFragmentViewModel = new ViewModelProvider(PostsFragment.this, viewModelProviderFactory).get(PostsFragmentViewModel.class);

        postsFragmentViewModel.observeData().removeObservers(getViewLifecycleOwner());
        postsFragmentViewModel.observeData().observe(getViewLifecycleOwner(), new Observer<MainResource<List<PostsModel>>>() {
            @Override
            public void onChanged(MainResource<List<PostsModel>> listMainResource) {
                switch (listMainResource.mainStatus){
                    case ERROR:
                        Log.d(TAG, "onChanged: FAILED GET DATA");
                        break;
                    case LOADING:
                        Log.d(TAG, "onChanged: loading....");
                        break;
                    case SUCCESS:
                        Log.d(TAG, "onChanged: " + listMainResource.data);
                        Log.d(TAG, "onChanged: size nyah " + listMainResource.data.size());
                        adapter.setPosts(listMainResource.data);
                        break;
                }
            }
        });

    }
}
