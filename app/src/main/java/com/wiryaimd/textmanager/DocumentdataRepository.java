package com.wiryaimd.textmanager;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

/**
 *  repository seperti / sebagai tempat manage data
 *
 */

public class DocumentdataRepository {

    private DocumentdataDao documentdataDao;
    private LiveData<List<Documentdata>> allDocumentdata;

    public DocumentdataRepository(Context context){
        DocumentdataDatabase database = DocumentdataDatabase.getInstance(context);
        documentdataDao = database.documentdataDao();
        allDocumentdata = documentdataDao.getDocumentdata();
    }

    public void insert(Documentdata documentdata){
        new InsertDoc(documentdataDao).execute(documentdata);
    }

    public void update(Documentdata documentdata){
        new UpdateDoc(documentdataDao).execute(documentdata);
    }

    public void delete(Documentdata documentdata){
        new DeleteDoc(documentdataDao).execute(documentdata);
    }

    public void deleteAll(){
        new DeleteAllDoc(documentdataDao).execute();
    }

    public LiveData<List<Documentdata>> getAllDocumentdata() {
        return allDocumentdata;
    }

    private static class InsertDoc extends AsyncTask<Documentdata, Void, Void>{

        private DocumentdataDao dao;

        public InsertDoc(DocumentdataDao documentdataDao){
            this.dao = documentdataDao;
        }

        @Override
        protected Void doInBackground(Documentdata... documentdata) {
            dao.insert(documentdata[0]);
            return null;
        }
    }

    private static class UpdateDoc extends AsyncTask<Documentdata, Void, Void>{

        private DocumentdataDao dao;

        public UpdateDoc(DocumentdataDao documentdataDao){
            this.dao = documentdataDao;
        }

        @Override
        protected Void doInBackground(Documentdata... documentdata) {
            dao.update(documentdata[0]);
            return null;
        }
    }

    private static class DeleteDoc extends AsyncTask<Documentdata, Void, Void>{

        private DocumentdataDao dao;

        public DeleteDoc(DocumentdataDao documentdataDao){
            this.dao = documentdataDao;
        }

        @Override
        protected Void doInBackground(Documentdata... documentdata) {
            dao.delete(documentdata[0]);
            return null;
        }
    }

    private static class DeleteAllDoc extends AsyncTask<Void, Void, Void>{

        private DocumentdataDao dao;

        public DeleteAllDoc(DocumentdataDao documentdataDao){
            this.dao = documentdataDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            dao.deleteAllDocuments();
            return null;
        }
    }


}
