
package com.wiryaimd.textmanager.ui.auth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.wiryaimd.textmanager.R;
import com.wiryaimd.textmanager.models.UserModel;
import com.wiryaimd.textmanager.ui.main.MainActivity;
import com.wiryaimd.textmanager.viewmodels.ViewModelProviderFactory;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class AuthActivity extends DaggerAppCompatActivity {

    private static final String TAG = "AuthActivity";

//    @Inject
//    String anjai;
//
//    @Inject
//    boolean isAppNull;


    /**
     * kita hanya perlu menggunakan anotasi inject
     * untuk memanggil class yang telah di deklarasi di modul
     */
    @Inject
    RequestManager requestManager;

    @Inject
    Drawable bg;

    @Inject
    ViewModelProviderFactory providerFactory;

    private AuthViewModel authViewModel;

    private ImageView imgbg;
    private EditText edtin;
    private Button btnlogin;
    private ProgressBar loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        // deklarasi viewmodel broo, ykl
        authViewModel = new ViewModelProvider(AuthActivity.this, providerFactory).get(AuthViewModel.class);

        imgbg = findViewById(R.id.main_img);
        edtin = findViewById(R.id.main_edtin);
        btnlogin = findViewById(R.id.main_btnlogin);
        loading = findViewById(R.id.main_loading);

//        Log.d(TAG, "onCreate: giley abiez: " + anjai);
//        Log.d(TAG, "onCreate: hello there.. is my application null? if yes say true otherwise false: " + isAppNull);

        authViewModel.observerLiveData().observe(AuthActivity.this, new Observer<AuthResource<UserModel>>() {
            @Override
            public void onChanged(AuthResource<UserModel> userModelAuthResource) {
                // cek melalui auth status
                if(userModelAuthResource != null) {
                    switch (userModelAuthResource.authStatus) {
                        case AUTHENTICATED:
                            Log.d(TAG, "onChanged: LOGIN SUCCESS BOSS " + userModelAuthResource.data.getEmail());
                            loading.setVisibility(View.GONE);
                            startActivity(new Intent(AuthActivity.this, MainActivity.class));
                            finish();
                            break;
                        case NOT_AUTHENTICATED:
                            Log.d(TAG, "onChanged: NOT AUTH");
                            loading.setVisibility(View.GONE);
                            break;
                        case ERROR:
                            Log.d(TAG, "onChanged: GAGAL ANJAE");
                            loading.setVisibility(View.GONE);
                            break;
                        case LOADING:
                            loading.setVisibility(View.VISIBLE);
                            break;
                    }
                }
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtin.getText().toString().isEmpty()){
                    Log.d(TAG, "onClick: empty");
                    return;
                }
                authViewModel.initData(Integer.parseInt(edtin.getText().toString()));
            }
        });

        setupImg();
    }

    private void setupImg() {
        requestManager.load(bg).into(imgbg);
    }
}