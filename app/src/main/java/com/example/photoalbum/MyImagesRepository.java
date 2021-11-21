package com.example.photoalbum;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import javax.xml.transform.Result;

public class MyImagesRepository {

    private MyImagesDAO myImagesDAO;
    private LiveData<List<MyImages>> imagesList;

    public MyImagesRepository(Application application)
    {
        MyImagesDatabase database=MyImagesDatabase.getInstance(application);
        myImagesDAO=database.myImagesDAO();
        imagesList=myImagesDAO.getAllImages();
    }

    public void insert(MyImages myImages)
    {
        new InsertImageAsyncTask(myImagesDAO).execute(myImages);
    }

    public void delete(MyImages myImages)
    {
        new DeleteImageAsyncTask(myImagesDAO).execute(myImages);
    }

    public void update(MyImages myImages)
    {
        new UpdateImageAsyncTask(myImagesDAO).execute(myImages);
    }

    public LiveData<List<MyImages>> getAllImages()
    {
        return imagesList;
    }

    public static class InsertImageAsyncTask extends AsyncTask<MyImages,Void,Void>
    {
        MyImagesDAO myImagesDAO;

        public InsertImageAsyncTask(MyImagesDAO myImagesDAO) {
            this.myImagesDAO = myImagesDAO;
        }

        @Override
        protected Void doInBackground(MyImages... myImages) {
            myImagesDAO.Insert(myImages[0]);
            return null;
        }
    }

    public static class DeleteImageAsyncTask extends AsyncTask<MyImages,Void,Void>
    {
        MyImagesDAO myImagesDAO;

        public DeleteImageAsyncTask(MyImagesDAO myImagesDAO) {
            this.myImagesDAO = myImagesDAO;
        }

        @Override
        protected Void doInBackground(MyImages... myImages) {
            myImagesDAO.Delete(myImages[0]);
            return null;
        }
    }

    public static class UpdateImageAsyncTask extends AsyncTask<MyImages,Void,Void>
    {
        MyImagesDAO myImagesDAO;

        public UpdateImageAsyncTask(MyImagesDAO myImagesDAO) {
            this.myImagesDAO = myImagesDAO;
        }

        @Override
        protected Void doInBackground(MyImages... myImages) {
            myImagesDAO.Update(myImages[0]);
            return null;
        }
    }
}
