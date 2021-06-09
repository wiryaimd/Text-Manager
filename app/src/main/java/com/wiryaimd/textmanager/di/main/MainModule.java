package com.wiryaimd.textmanager.di.main;

import android.app.Application;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.wiryaimd.textmanager.network.main.MainApi;
import com.wiryaimd.textmanager.ui.main.posts.PostsAdapter;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class MainModule {

    // mainscope sama kek authscope yaitu sama sama custom scope untuk grouping tiap subcomponent

    @MainScope
    @Provides
    static MainApi mainApi(Retrofit retrofit){
        return retrofit.create(MainApi.class);
    }

    @MainScope
    @Provides
    static PostsAdapter postsAdapter(){
        return new PostsAdapter();
    }

    @MainScope
    @Provides
    static LinearLayoutManager linearLayoutManager(Application application){
        return new LinearLayoutManager(application);
    }

}
