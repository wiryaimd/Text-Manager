package com.wiryaimd.textmanager.ui.main.profile;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.wiryaimd.textmanager.R;
import com.wiryaimd.textmanager.di.ViewModelFactoryModule;
import com.wiryaimd.textmanager.models.UserModel;
import com.wiryaimd.textmanager.ui.auth.AuthResource;
import com.wiryaimd.textmanager.viewmodels.ViewModelProviderFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class ProfileFragment extends DaggerFragment {

    private static final String TAG = "ProfileFragment";

    @Inject
    ViewModelProviderFactory viewModelProviderFactory;

    private ProfileFragmentViewModel profileFragmentViewModel;

    private TextView tvusername, tvemail, tvwebsite;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Toast.makeText(getActivity(), "profile fragment neh", Toast.LENGTH_SHORT).show();

        tvusername = view.findViewById(R.id.profile_username);
        tvemail = view.findViewById(R.id.profile_email);
        tvwebsite = view.findViewById(R.id.profile_website);

        profileFragmentViewModel = new ViewModelProvider(ProfileFragment.this, viewModelProviderFactory).get(ProfileFragmentViewModel.class);

        profileFragmentViewModel.getLiveData().removeObservers(getViewLifecycleOwner());
        profileFragmentViewModel.getLiveData().observe(getViewLifecycleOwner(), new Observer<AuthResource<UserModel>>() {
            @Override
            public void onChanged(AuthResource<UserModel> userModelAuthResource) {
                Log.d(TAG, "onChanged: ini knp ya???");
                switch (userModelAuthResource.authStatus){
                    case AUTHENTICATED:
                        tvusername.setText(userModelAuthResource.data.getUsername());
                        tvemail.setText(userModelAuthResource.data.getEmail());
                        tvwebsite.setText(userModelAuthResource.data.getWebsite());
                        break;
                    case ERROR:
                        Toast.makeText(getActivity(), "Error brohh", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}
