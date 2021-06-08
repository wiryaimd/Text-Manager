package com.wiryaimd.textmanager;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;

import com.wiryaimd.textmanager.models.UserModel;
import com.wiryaimd.textmanager.ui.auth.AuthResource;

import javax.inject.Inject;
import javax.inject.Singleton;

// kek repository maybe??
// class ini dibuat agar data yang diambil dari internet tersimpan ke local
// kemudian device mengambil data melalui local
// sehingga menjadi lebih cepat ... maytod
@Singleton
public class SessionManager {

    private MediatorLiveData<AuthResource<UserModel>> mediatorLiveData = new MediatorLiveData<>();

    @Inject
    public SessionManager() {
    }

    public void initAuth(LiveData<AuthResource<UserModel>> data){
        if (data != null){
            mediatorLiveData.setValue(AuthResource.loading(null));
            mediatorLiveData.addSource(data, new Observer<AuthResource<UserModel>>() {
                @Override
                public void onChanged(AuthResource<UserModel> userModelAuthResource) {
                    // setelah itu add resource dengan livedata yang didapat dari fetch api tadi
                    // kemudian set value authresourcenya
                    mediatorLiveData.setValue(userModelAuthResource);
                    mediatorLiveData.removeSource(data);

                    // nanti setelah setvalue, observer akan mendeteksi perubahan data, kemudian meng updatenya
                }
            });
        }

    }

    public void logout(){
        mediatorLiveData.setValue(AuthResource.logout(null));
    }

    public LiveData<AuthResource<UserModel>> getLiveData(){
        return mediatorLiveData;
    }
}
