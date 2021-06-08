package com.wiryaimd.textmanager.ui.auth;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.wiryaimd.textmanager.SessionManager;
import com.wiryaimd.textmanager.models.UserModel;
import com.wiryaimd.textmanager.network.auth.AuthApi;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class AuthViewModel extends ViewModel {

    private static final String TAG = "AuthViewModel";

    private AuthApi authApi;
    private SessionManager sessionManager;

    // mediatod dengan authresource
//    private MediatorLiveData<AuthResource<UserModel>> mediatorLiveData = new MediatorLiveData<>();

    @Inject
    public AuthViewModel(AuthApi authApi, SessionManager sessionManager){
        Log.d(TAG, "AuthViewModel: Anjai ");

        this.authApi = authApi;
        this.sessionManager = sessionManager;

        // observe menggunakan rxjava
//        authApi.getUser(1)
//                .toObservable()
//                .subscribeOn(Schedulers.io())
//                .subscribe(new Observer<UserModel>() {
//                    @Override
//                    public void onSubscribe(@NonNull Disposable d) {
//                        Log.d(TAG, "onSubscribe: subscribe dong busku");
//                    }
//
//                    @Override
//                    public void onNext(@NonNull UserModel userModel) {
//                        Log.d(TAG, "onNext: wanjay " + userModel.getUsername());
//                        Log.d(TAG, "onNext: anjejerr " + userModel.getEmail());
//                    }
//
//                    @Override
//                    public void onError(@NonNull Throwable e) {
//                        Log.d(TAG, "onError: lah");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "onComplete: okehhhhhhhhhh anjeg");
//                    }
//                });
    }

    public void initData(int id) {
        sessionManager.initAuth(getDataFromApi(id));
    }

    public LiveData<AuthResource<UserModel>> getDataFromApi(int id){
        // get data dari api
        // langsung dengan meng konversi nya ke live data
        LiveData<AuthResource<UserModel>> liveData = LiveDataReactiveStreams.fromPublisher(
                authApi.getUser(id).subscribeOn(Schedulers.io())
                        .onErrorReturn(new Function<Throwable, UserModel>() {
                            @Override
                            public UserModel apply(@NonNull Throwable throwable) throws Exception {
                                // jika error maka set id menjadi -1
                                // kemudia cek di method map dibawah VV
                                UserModel userModel = new UserModel();
                                userModel.setId(-1);
                                return userModel;
                            }
                        }).map(new Function<UserModel, AuthResource<UserModel>>() {
                    @Override
                    public AuthResource<UserModel> apply(@NonNull UserModel userModel) throws Exception {
                        // jika id nya == -1 maka terjadi error dan return auth error
                        if (userModel.getId() == -1) {
                            return AuthResource.error("konttt", null);
                        }
                        // jika tidak return usermodel yang di fetch dari  epi ai (API)
                        return AuthResource.authenticated(userModel);
                    }
                })
        );
        return liveData;
    }

    public LiveData<AuthResource<UserModel>> observerLiveData(){
        return sessionManager.getLiveData();
    }

}
