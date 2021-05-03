package com.example.documentdigitizationservice;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.example.documentdigitizationservice.Models.File;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.HashMap;

public class UserProfile extends AppCompatActivity {

    private static final int PICK_FILE = 1;
    private DatabaseReference databaseReference;
    private String UID;
    private static String  TAG = "UserProfileActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        UID = FirebaseQueries.getInstance().getUID();
        Log.d(TAG, UID);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Users");

    }
    public void FileUpload(View view){
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");
        startActivityForResult(intent,PICK_FILE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == PICK_FILE){
            if(resultCode == RESULT_OK){
                Uri FileUri = data.getData();
                StorageReference Folder = FirebaseStorage.getInstance().getReference().child("Files");
                final StorageReference FileName = Folder.child("file"+ FileUri.getLastPathSegment());
                FileName.putFile(FileUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                     FileName.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                         @Override
                         public void onSuccess(Uri uri) {
                             String URL = String.valueOf(uri);
                             String filename =   uri.getLastPathSegment();
                             File file = new File(filename, URL, UID);
                             databaseReference.child(UID).child("PublicFiles").push().setValue(file);
                             Toast.makeText(UserProfile.this,"File Uploaded", Toast.LENGTH_SHORT).show();
                         }
                     });
                    }
                });
            }
        }
    }

//    mSendButton = (Button)view.findViewById(R.id.sendButton);
//        mSendButton.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            // TODO: Send messages on click
//            File friendlyMessage = new File("File name", "url", "18130");
//            File friendlyMessage2 = new File("File name", "url", "43042");
//            databaseReference.child(UID).child("PublicFiles").push().setValue(friendlyMessage);
//            databaseReference.child(UID).child("PublicFiles").push().setValue(friendlyMessage2);
//
//        }
//    });


}