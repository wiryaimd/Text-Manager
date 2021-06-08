package com.wiryaimd.textmanager.di.main;

import androidx.lifecycle.ViewModel;

import com.wiryaimd.textmanager.SessionManager;
import com.wiryaimd.textmanager.di.ViewModelKey;
import com.wiryaimd.textmanager.ui.main.profile.ProfileFragment;
import com.wiryaimd.textmanager.ui.main.profile.ProfileFragmentViewModel;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;

@Module
public class FragmentProfileModule {

    @Provides
    @IntoMap
    @ViewModelKey(ProfileFragmentViewModel.class)
    static ViewModel profileFragmentViewModel(SessionManager sessionManager){
        return new ProfileFragmentViewModel(sessionManager);
    }

}
