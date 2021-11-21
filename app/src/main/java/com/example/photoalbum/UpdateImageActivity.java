package com.example.photoalbum;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class UpdateImageActivity extends AppCompatActivity {

    private ImageView imageViewUpdateImage;
    private EditText editTextUpdateTitle,editTextUpdateDescription;
    private Button buttonUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Update Image");
        setContentView(R.layout.activity_update_image);

        imageViewUpdateImage=findViewById(R.id.imageViewAddImage);
        editTextUpdateTitle=findViewById(R.id.editTextAddTitle);
        editTextUpdateDescription=findViewById(R.id.editTextAddDescription);
        buttonUpdate=findViewById(R.id.buttonUpdate);

        imageViewUpdateImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}