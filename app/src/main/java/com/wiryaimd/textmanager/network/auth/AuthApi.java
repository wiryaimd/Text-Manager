package com.wiryaimd.textmanager.network.auth;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;


/**
 * ni gunanya buat nge get response body dari web
 *
 * jadi ini yg namanya RESTFUL API
 *
 * nge get data json yekan
 */
public interface AuthApi {

    @GET
    Call<ResponseBody> getResponseAnjaiii();

}
