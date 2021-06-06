
package com.wiryaimd.textmanager.ui.auth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.wiryaimd.textmanager.R;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        // deklarasi viewmodel broo, ykl
        authViewModel = new ViewModelProvider(AuthActivity.this, providerFactory).get(AuthViewModel.class);

        imgbg = findViewById(R.id.main_img);

//        Log.d(TAG, "onCreate: giley abiez: " + anjai);
//        Log.d(TAG, "onCreate: hello there.. is my application null? if yes say true otherwise false: " + isAppNull);



        setupImg();
    }

    private void setupImg() {
        requestManager.load(bg).into(imgbg);
    }
}