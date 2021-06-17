package com.wiryaimd.textmanager.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.wiryaimd.textmanager.db.models.DataModel;

import java.util.List;

@Dao
public interface DataDao {

    @Insert
    void insert(DataModel dataModel);

    @Update
    void update(DataModel dataModel);

    @Delete
    void delete(DataModel dataModel);

    @Query("DELETE FROM data_model")
    void deleteAllData();

    @Query("SELECT * FROM data_model")
    LiveData<List<DataModel>> getAllData();

}
