package com.example.seoulapp1;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.CursorLoader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;

public class upload_view extends AppCompatActivity {
    private ImageView imageView;
    private EditText title;
    private EditText description;
    private Button uploadbutton,pickbutton;
    private FirebaseStorage storage;
    private FirebaseDatabase database;
    private String imagePath;

    private static final int GALLERY_CODE = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("annananannn??????????????");
        super.onCreate(savedInstanceState);
        System.out.println("funck???????");
        setContentView(R.layout.app_bar_home);
        System.out.println("why????????");
        storage= FirebaseStorage.getInstance();
        database=FirebaseDatabase.getInstance();

        imageView = (ImageView)findViewById(R.id.imageViewupload);
        title = (EditText)findViewById(R.id.title);
        description = (EditText)findViewById(R.id.description);
        uploadbutton = (Button)findViewById(R.id.uploadbutton);
        pickbutton = (Button)findViewById(R.id.pickbutton);

        pickbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
                startActivityForResult(intent , GALLERY_CODE);
            }
        });

        uploadbutton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                upload(imagePath);
            }
        });

    }//onCreate

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        //photo pick form gallery
        if(requestCode==GALLERY_CODE) {
            imagePath = getPath(data.getData());
            File f =new File(imagePath);
            imageView.setImageURI(Uri.fromFile(f));

        }

    }//onActivityResult

    public String getPath(Uri uri){
        String [] proj = {MediaStore.Images.Media.DATA};
        CursorLoader cursorLoader = new CursorLoader(this,uri,proj,null,null,null);
        Cursor cursor = cursorLoader.loadInBackground();
        int index =cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);

        cursor.moveToFirst();
        return cursor.getString(index);
    }

    private void upload(String uri){
        StorageReference storageRef = storage.getReferenceFromUrl("gs://test-seuol-1.appspot.com");

        Uri file = Uri.fromFile(new File(uri));
        StorageReference riversRef = storageRef.child("images/"+file.getLastPathSegment());
        UploadTask uploadTask = riversRef.putFile(file);

// Register observers to listen for when the download is done or if it fails
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle unsuccessful uploads
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                // taskSnapshot.getMetadata() contains file metadata such as size, content-type, etc.
                @SuppressWarnings("VisibleForTests")
                Task<Uri> result = taskSnapshot.getMetadata().getReference().getDownloadUrl();
                result.addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        String photoStringLink = uri.toString();
                        ImageDTO imageDTO = new ImageDTO();
                        imageDTO.imageUrl=photoStringLink;
                        imageDTO.title=title.getText().toString();
                        imageDTO.description=description.getText().toString();
                        database.getReference().child("images").push().setValue(imageDTO);

                    }
                });
                //System.out.println(taskSnapshot.getMetadata().getReference().getDownloadUrl().toString());
            }
        });
    }
}
