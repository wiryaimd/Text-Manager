package com.wiryaimd.textmanager.ui.auth;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.wiryaimd.textmanager.network.auth.AuthApi;

import javax.inject.Inject;

public class AuthViewModel extends ViewModel {

    private static final String TAG = "AuthViewModel";

    private AuthApi authApi;

    @Inject
    public AuthViewModel(AuthApi authApi){
        Log.d(TAG, "AuthViewModel: Anjai ngeri abizzz bosskuuu hahay papalepal");

        this.authApi = authApi;

        if (authApi != null){
            Log.d(TAG, "AuthViewModel: wanjeeerrrr gileyyy euyyy");
        }else{
            Log.d(TAG, "AuthViewModel: cokk kok noll bjerr");
        }
    }

}
