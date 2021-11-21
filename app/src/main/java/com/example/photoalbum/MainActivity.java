package com.example.photoalbum;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;
    private FloatingActionButton fab;

    private MyImagesViewModel myImagesViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv=findViewById(R.id.rv);
        fab=findViewById(R.id.fab);

        rv.setLayoutManager(new LinearLayoutManager(this));

        MyImagesAdapter adapter=new MyImagesAdapter();
        rv.setAdapter(adapter);

        myImagesViewModel=new ViewModelProvider.AndroidViewModelFactory(getApplication())
                .create(MyImagesViewModel.class);
        myImagesViewModel.getAllImages().observe(MainActivity.this, new Observer<List<MyImages>>() {
            @Override
            public void onChanged(List<MyImages> myImages) {
                adapter.setImagesList(myImages);
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,AddImageActivity.class);
                startActivityForResult(intent,3);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==3&&resultCode==RESULT_OK&&data!=null)
        {
            String title= data.getStringExtra("title");
            String description=data.getStringExtra("Description");
            byte [] image=data.getByteArrayExtra("image");

            MyImages myImages=new MyImages(title,description,image);
            myImagesViewModel.insert(myImages);
        }
    }
}