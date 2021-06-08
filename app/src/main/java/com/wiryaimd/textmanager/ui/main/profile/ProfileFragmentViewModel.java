package com.wiryaimd.textmanager.ui.main.profile;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.wiryaimd.textmanager.SessionManager;
import com.wiryaimd.textmanager.models.UserModel;
import com.wiryaimd.textmanager.network.main.MainApi;
import com.wiryaimd.textmanager.ui.auth.AuthResource;

import javax.inject.Inject;

public class ProfileFragmentViewModel extends ViewModel {

    private static final String TAG = "ProfileFragmentViewMode";

    private SessionManager sessionManager;

    @Inject
    public ProfileFragmentViewModel(SessionManager sessionManager){
        this.sessionManager = sessionManager;
        Log.d(TAG, "ProfileFragmentViewModel: masuk");
    }

    public LiveData<AuthResource<UserModel>> getLiveData(){
        return sessionManager.getLiveData();
    }

}
