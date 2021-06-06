package com.wiryaimd.textmanager.di.auth;

import androidx.lifecycle.ViewModel;

import com.wiryaimd.textmanager.di.ViewModelKey;
import com.wiryaimd.textmanager.ui.auth.AuthViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;

@Module
public abstract class AuthViewModelModule {

    /**
     * adanya anotasi IntoMap menjadikan nya method ini me return
     * Map dengan value Provider<yang extends ViewModel>
     *
     * dan diberi key nya yaitu class authvm
     */
    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel.class)
    abstract ViewModel bindAuthViewModel(AuthViewModel authViewModel);


    /**
     * bisa juga pake method yg ini
     * sama fungsinya kek diatas
     */
//    @Provides
//    @IntoMap
//    @ViewModelKey(AuthViewModel.class)
//    static ViewModel providesAuthViewModel(){
//        return new AuthViewModel();
//    }


}
