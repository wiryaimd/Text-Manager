package com.wiryaimd.textmanager;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

/**
 *
 * kaya controller dimana bisa kontrol kek insert update dll
 *
 * ini ya viewmodel nya
 */

public class DocumentdataViewModel extends AndroidViewModel {

    private DocumentdataRepository repository;
    private LiveData<List<Documentdata>> allDocumentdata;

    public DocumentdataViewModel(@NonNull Application application) {
        super(application);

        repository = new DocumentdataRepository(application);
        allDocumentdata = repository.getAllDocumentdata();

    }

    /**
     * membuat viewmodel tidak terhubung langsung dengan database
     *
     * makanya kita gunakan Repository untuk melaluinya
     *
     * jadi ui tidak sama sekali berhubungan lansgung dengan
     * repository karena adanya viewmodel
     */
    public void insert(Documentdata documentdata){
        repository.insert(documentdata);
    }

    public void update(Documentdata documentdata){
        repository.update(documentdata);
    }

    public void delete(Documentdata documentdata){
        repository.delete(documentdata);
    }

    public void deleteAll(){
        repository.deleteAll();
    }

    // getter
    public LiveData<List<Documentdata>> getAllDocumentdata() {
        return allDocumentdata;
    }
}
