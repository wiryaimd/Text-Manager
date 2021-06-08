package com.wiryaimd.textmanager.ui.main.posts;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.wiryaimd.textmanager.SessionManager;
import com.wiryaimd.textmanager.models.PostsModel;
import com.wiryaimd.textmanager.network.main.MainApi;
import com.wiryaimd.textmanager.ui.main.MainResource;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class PostsFragmentViewModel extends ViewModel {

    private static final String TAG = "PostsFragmentViewModel";
    
    private SessionManager sessionManager;
    private MainApi mainApi;

    private MediatorLiveData<MainResource<List<PostsModel>>> mediatorLiveData;

    @Inject
    public PostsFragmentViewModel(SessionManager sessionManager, MainApi mainApi) {
        this.sessionManager = sessionManager;
        this.mainApi = mainApi;

        Log.d(TAG, "PostsFragmentViewModel: boom workkk");
    }

    public LiveData<MainResource<List<PostsModel>>> observeData() {
        mediatorLiveData = new MediatorLiveData<>();

        LiveData<MainResource<List<PostsModel>>> liveData = LiveDataReactiveStreams
                .fromPublisher(mainApi.getPosts(sessionManager.getLiveData().getValue().data.getId())
                        .onErrorReturn(new Function<Throwable, List<PostsModel>>() {
                            @Override
                            public List<PostsModel> apply(@NonNull Throwable throwable) throws Exception {
                                List<PostsModel> list = new ArrayList<>();
                                PostsModel postsModel = new PostsModel();
                                postsModel.setUserId(-1);
                                list.add(postsModel);
                                return list;
                            }
                        }).map(new Function<List<PostsModel>, MainResource<List<PostsModel>>>() {
                            @Override
                            public MainResource<List<PostsModel>> apply(@NonNull List<PostsModel> postsModels) throws Exception {
                                if (postsModels.size() > 0 && postsModels.get(0).getUserId() == -1) {
                                    return MainResource.error(null, null);
                                }
                                return MainResource.success(postsModels);
                            }
                        }).subscribeOn(Schedulers.io()));

        mediatorLiveData.addSource(liveData, new Observer<MainResource<List<PostsModel>>>() {
            @Override
            public void onChanged(MainResource<List<PostsModel>> listMainResource) {
                mediatorLiveData.setValue(listMainResource);
                mediatorLiveData.removeSource(liveData);
            }
        });

        return mediatorLiveData;
    }

    public LiveData<MainResource<List<PostsModel>>> getLiveData(){
        return mediatorLiveData;
    }

}
