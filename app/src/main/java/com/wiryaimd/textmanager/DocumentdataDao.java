package com.wiryaimd.textmanager;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * dao = data access object
 *
 * berfungsi untuk access data
 * seperti di query sql insert, update, delete, / select from dll
 *
 */

@Dao
public interface DocumentdataDao {

    @Insert
    void insert(Documentdata documentdata);

    @Update
    void update(Documentdata documentdata);

    @Delete
    void delete(Documentdata documentdata);

    @Query("DELETE FROM document_table")
    void deleteAllDocuments();

    @Query("SELECT * FROM document_table")
    LiveData<List<Documentdata>> getDocumentdata();

}