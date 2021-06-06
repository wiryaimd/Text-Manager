package com.wiryaimd.textmanager.viewmodels;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

public class ViewModelProviderFactory implements ViewModelProvider.Factory {

    private static final String TAG = "ViewModelProviderFactor";

    private Map<Class<? extends ViewModel>, Provider<ViewModel>> providerMap;

    @Inject
    public ViewModelProviderFactory(Map<Class<? extends ViewModel>, Provider<ViewModel>> providerMap){
        this.providerMap = providerMap;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        // check provider null
        Provider<? extends ViewModel> provider = providerMap.get(modelClass);
        if (provider == null){
            // kalo null ya cek isi dari map nya ada yang sama ga ama key nya
            for(Map.Entry<Class<? extends ViewModel>, Provider<ViewModel>> entry : providerMap.entrySet()){
                if (modelClass.isAssignableFrom(entry.getKey())){
                    provider = entry.getValue();
                }
            }
        }

        // kalo gada yg sama throw error
        if (provider == null){
            throw new IllegalArgumentException("gada viewmodel yang sesuai ama key yang diberikan");
        }

        // kalo ada ya return dengan catch karena bisa aja error yekan
        try {
            return (T) provider.get();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
