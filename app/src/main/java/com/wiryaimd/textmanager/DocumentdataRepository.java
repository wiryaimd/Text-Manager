package com.wiryaimd.textmanager;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

public class DocumentdataRepository {

    private DocumentdataDao documentdataDao;
    private LiveData<List<Documentdata>> allDocumentdata;

    public DocumentdataRepository(Context context){
        DocumentdataDatabase database = DocumentdataDatabase.getInstance(context);
        documentdataDao = database.documentdataDao();
        allDocumentdata = documentdataDao.getDocumentdata();
    }

}
