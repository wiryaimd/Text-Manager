package com.wiryaimd.textmanager.di.main;

import androidx.lifecycle.ViewModel;

import com.wiryaimd.textmanager.SessionManager;
import com.wiryaimd.textmanager.di.ViewModelKey;
import com.wiryaimd.textmanager.network.main.MainApi;
import com.wiryaimd.textmanager.ui.main.posts.PostsFragmentViewModel;
import com.wiryaimd.textmanager.ui.main.profile.ProfileFragmentViewModel;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;

@Module
public class FragmentMapModule {

    @Provides
    @IntoMap
    @ViewModelKey(ProfileFragmentViewModel.class)
    static ViewModel profileFragmentViewModel(SessionManager sessionManager){
        return new ProfileFragmentViewModel(sessionManager);
    }

    @Provides
    @IntoMap
    @ViewModelKey(PostsFragmentViewModel.class)
    static ViewModel postsFragmentViewModel(SessionManager sessionManager, MainApi mainApi){
        return new PostsFragmentViewModel(sessionManager, mainApi);
    }

}
