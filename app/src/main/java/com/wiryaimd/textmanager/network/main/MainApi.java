package com.wiryaimd.textmanager.network.main;

import com.wiryaimd.textmanager.models.PostsModel;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MainApi {

    @GET("posts")
    Flowable<List<PostsModel>> getPosts(@Query("userId") int userId);

}
