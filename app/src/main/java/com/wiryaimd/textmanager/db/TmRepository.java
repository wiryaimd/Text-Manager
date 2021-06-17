package com.wiryaimd.textmanager.db;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.wiryaimd.textmanager.db.dao.DataDao;
import com.wiryaimd.textmanager.db.models.DataModel;

import java.util.List;

import javax.inject.Inject;

public class TmRepository {

    private static final String TAG = "TmRepository";

    private Application application;
    private DataModel dataModel;

    private DataDao dataDao;
    private LiveData<List<DataModel>> dataList;

    @Inject
    public TmRepository(Application application) {
        this.application = application;

        TmDatabase database = TmDatabase.getInstance(application);
        dataDao = database.getDataDao();
        dataList = dataDao.getAllData();
    }

    public void insert(DataModel dataModel){
        TmDatabase.asyncExecutor.execute(new Runnable() {
            @Override
            public void run() {
                dataDao.insert(dataModel);
            }
        });
    }

    public void update(DataModel dataModel){
        TmDatabase.asyncExecutor.execute(new Runnable() {
            @Override
            public void run() {
                dataDao.update(dataModel);
            }
        });
    }

    public void delete(DataModel dataModel){
        TmDatabase.asyncExecutor.execute(new Runnable() {
            @Override
            public void run() {
                dataDao.delete(dataModel);
            }
        });
    }

    public LiveData<List<DataModel>> getDataList() {
        return dataList;
    }
}
