package com.example.darius.carrental.fragments;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.darius.carrental.ImagesActivity;
import com.example.darius.carrental.R;
import com.example.darius.carrental.Upload;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import static android.app.Activity.RESULT_OK;

public class HomeFragment extends Fragment {

    private Button uploadButton;
    private ImageButton choosePictureButton;
    private EditText model;
    private EditText year;
    private EditText price;
    private Button seeImages;
    private ImageView imageView;
    private Uri mImgeUri;

    private StorageReference mStorageReference;
    private DatabaseReference mDatabaseReference;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.post_car, container, false);
        uploadButton = (Button) view.findViewById(R.id.upload);
        seeImages=view.findViewById(R.id.see_images_id);
        choosePictureButton = view.findViewById(R.id.choosePictureButton);
        imageView = view.findViewById(R.id.carImageView);
        model=view.findViewById(R.id.Model);
        year=view.findViewById(R.id.Year);
        price=view.findViewById(R.id.Price);
        mStorageReference=FirebaseStorage.getInstance().getReference("uploads");
        mDatabaseReference=FirebaseDatabase.getInstance().getReference("uploads");
        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadFile();
            }
        });

        choosePictureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser();
            }
        });

        /*seeImages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seeAllImages();
            }
        });*/


        return  view;
    }

    private void openFileChooser(){
        Intent intent=new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,1);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1 && resultCode==RESULT_OK && data != null && data.getData()!=null){
            mImgeUri=data.getData();
            choosePictureButton.setImageURI(mImgeUri);
        }
    }

    private String getFileExtension(Uri uri){
        ContentResolver cr=getContext().getContentResolver();
        MimeTypeMap mime=MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cr.getType(uri));
    }

    private void uploadFile(){
        if(mImgeUri!=null){
            StorageReference fileReference = mStorageReference.child(System.currentTimeMillis()
            +"."+getFileExtension(mImgeUri));
            fileReference.putFile(mImgeUri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Toast.makeText(getActivity(),"Upload done",Toast.LENGTH_LONG).show();
                            Upload upload=new Upload("FileName",taskSnapshot.getDownloadUrl().toString(),model.getText().toString(),year.getText().toString(),price.getText().toString());

                            String uploadId=mDatabaseReference.push().getKey();
                            upload.setId(uploadId);
                            mDatabaseReference.child(uploadId).setValue(upload);
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getActivity(),e.getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {

                        }
                    });


        }else{
            Toast.makeText(this.getContext(),"Noo file",Toast.LENGTH_SHORT).show();
        }

    }

    private void seeAllImages(){
        Intent intent=new Intent(getActivity(),ImagesActivity.class );
        startActivity(intent);
    }
}
