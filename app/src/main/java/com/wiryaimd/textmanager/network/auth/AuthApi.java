package com.wiryaimd.textmanager.network.auth;

import com.wiryaimd.textmanager.models.UserModel;

import io.reactivex.Flowable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


/**
 * ni gunanya buat nge get response body dari web
 *
 * jadi ini yg namanya RESTFUL API
 *
 * nge get data json yekan
 */
public interface AuthApi {

//    @GET
//    Call<ResponseBody> getResponseAnjaiii();

//    @GET
//    Flowable<ResponseBody> getResponseAnjaiii();

    @GET("users/{id}")
    Flowable<UserModel> getUser(@Path("id") int id);

    

}
