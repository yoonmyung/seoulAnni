package com.example.seoulapp1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class Board extends AppCompatActivity {
    private ImageView imageView2;
    private TextView title2,description2;
    private FirebaseStorage storage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board);

        try {
            getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            getSupportActionBar().setCustomView(R.layout.activity_action_bar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Intent intentExtras = getIntent();
        final ImageDTO dto = (ImageDTO)intentExtras.getSerializableExtra("mydata");

        storage= FirebaseStorage.getInstance();
        StorageReference httpsReference = storage.getReferenceFromUrl(dto.imageUrl);

        imageView2 = (ImageView)findViewById(R.id.boimage);
        title2 = (TextView)findViewById(R.id.botitle);
        description2 = (TextView)findViewById(R.id.bodes);
        System.out.println("realllyyyyy3333333???????????????");

        title2.setText(dto.title);
        description2.setText(dto.description);
        Glide.with(this)
                .using(new FirebaseImageLoader())
                .load(httpsReference)
                .override(1000,1000)
                .centerCrop()
                .into(imageView2);

    }
}
