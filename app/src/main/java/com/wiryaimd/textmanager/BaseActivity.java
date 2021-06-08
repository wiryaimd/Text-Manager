package com.wiryaimd.textmanager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import com.wiryaimd.textmanager.models.UserModel;
import com.wiryaimd.textmanager.ui.auth.AuthActivity;
import com.wiryaimd.textmanager.ui.auth.AuthResource;
import com.wiryaimd.textmanager.ui.main.MainActivity;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

/**
 * di activity ini ngecek jika user yang ada di MainActivity login(authenticated) atau belum
 * kalo belum bakal dipindah ke auth activity
 */
public abstract class BaseActivity extends DaggerAppCompatActivity {

    private static final String TAG = "BaseActivity";

    @Inject
    public SessionManager sessionManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sessionManager.getLiveData().observe(BaseActivity.this, new Observer<AuthResource<UserModel>>() {
            @Override
            public void onChanged(AuthResource<UserModel> userModelAuthResource) {
                switch (userModelAuthResource.authStatus){
                    case AUTHENTICATED:
                        Log.d(TAG, "onChanged: LOGIN SUCCESS BOSS " + userModelAuthResource.data.getEmail() );
                    case NOT_AUTHENTICATED:
                        Log.d(TAG, "onChanged: NOT AUTH ");
                        Intent auth = new Intent(BaseActivity.this, AuthActivity.class);
                        startActivity(auth);
                        break;
                    case ERROR:
                        Log.d(TAG, "onChanged: GAGAL ANJAE");
                        break;
                    case LOADING:

                        break;
                }
            }
        });
    }
}
