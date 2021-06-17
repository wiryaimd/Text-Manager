package com.wiryaimd.textmanager.ui.main;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.wiryaimd.textmanager.SessionManager;
import com.wiryaimd.textmanager.db.TmRepository;
import com.wiryaimd.textmanager.db.models.DataModel;

import java.util.List;

import javax.inject.Inject;

public class MainViewModel extends ViewModel {

    private static final String TAG = "MainViewModel";

    private SessionManager sessionManager;
    private TmRepository tmRepository;

    @Inject
    public MainViewModel(SessionManager sessionManager, TmRepository tmRepository) {
        this.sessionManager = sessionManager;
        this.tmRepository = tmRepository;

        Log.d(TAG, "MainViewModel: asdasddasads");
    }

    public void insertData(DataModel dataModel){
        tmRepository.insert(dataModel);
    }

    public LiveData<List<DataModel>> getAllData(){
        return tmRepository.getDataList();
    }
}
