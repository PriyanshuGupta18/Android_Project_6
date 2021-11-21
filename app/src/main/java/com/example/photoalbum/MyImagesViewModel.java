package com.example.photoalbum;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MyImagesViewModel extends AndroidViewModel {

    private MyImagesRepository myImagesRepository;
    private LiveData<List<MyImages>> imagesList;

    public MyImagesViewModel(@NonNull Application application) {
        super(application);

        myImagesRepository=new MyImagesRepository(application);
        imagesList=myImagesRepository.getAllImages();
    }

    public void insert(MyImages myImages)
    {
        myImagesRepository.insert(myImages);
    }

    public void delete(MyImages myImages)
    {
        myImagesRepository.delete(myImages);
    }

    public void update(MyImages myImages)
    {
        myImagesRepository.update(myImages);
    }

    public LiveData<List<MyImages>> getAllImages()
    {
        return imagesList;
    }
}
