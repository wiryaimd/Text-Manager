package com.wiryaimd.textmanager;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

/**
 * repository seperti / sebagai tempat manage data
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

    /**
     * room tidak mengijinkan melakukan insert, update dll pada thread utama
     * oleh karena itu kita melakukan nya di thread asinkron background
     *
     */

    /**
     * menggunakan ExecutorServices class sebagai threads asinkronus
     */
    void insert(Documentdata documentdata){
        DocumentdataDatabase.asyncEx.execute(new Runnable() {
            @Override
            public void run() {
                documentdataDao.insert(documentdata);
            }
        });
    }

    void update(Documentdata documentdata){
        DocumentdataDatabase.asyncEx.execute(new Runnable() {
            @Override
            public void run() {
                documentdataDao.update(documentdata);
            }
        });
    }

    void delete(Documentdata documentdata){
        DocumentdataDatabase.asyncEx.execute(() -> documentdataDao.delete(documentdata));
    }

    void deleteAll(){
        DocumentdataDatabase.asyncEx.execute(() -> documentdataDao.deleteAllDocuments());
    }

    // getter nih
    public LiveData<List<Documentdata>> getAllDocumentdata() {
        return allDocumentdata;
    }

    /**
     * menggunakan AsyncTask class
     */
//    public void insert(Documentdata documentdata){
//        new InsertDoc(documentdataDao).execute(documentdata);
//    }
//
//    public void update(Documentdata documentdata){
//        new UpdateDoc(documentdataDao).execute(documentdata);
//    }
//
//    public void delete(Documentdata documentdata){
//        new DeleteDoc(documentdataDao).execute(documentdata);
//    }
//
//    public void deleteAll(){
//        new DeleteAllDoc(documentdataDao).execute();
//    }

    /**
     * nih bos
     */
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
