package com.example.documentdigitizationservice.Views.Home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.documentdigitizationservice.FirebaseQueries;
import com.example.documentdigitizationservice.Models.File;
import com.example.documentdigitizationservice.R;
import com.example.documentdigitizationservice.Views.userprofile.PublicFilesAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {
    private ArrayList<File> files ;
    private String UID;
    private DatabaseReference databaseReference;

    private static final String TAG = "ProfileActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);




        Log.d(TAG, "onCreate: started.");
        getIncomingIntent();


       // UID = FirebaseQueries.getInstance().getUID();

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Users").child(UID).child("PublicFiles");

        files = new ArrayList<>();
//
//        File friendlyMessage = new File("File name", "url", "18130");
//        File friendlyMessage2 = new File("File name", "url", "43042");
//        files.add(friendlyMessage);
//        files.add(friendlyMessage2);

        RecyclerView recyclerView =  findViewById(R.id.user_profile_recyler_view);
        Context context = getApplicationContext();
        final PublicFilesAdapter adapter = new PublicFilesAdapter(files,context);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    File file = dataSnapshot.getValue(File.class);
                    files.add(file);
                }
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void getIncomingIntent(){
        Log.d(TAG, "getIncomingIntent: checking for incoming intents.");
        if(getIntent().hasExtra("image_url") && getIntent().hasExtra("name_url") && getIntent().hasExtra("UID")&& getIntent().hasExtra("role_url")){
            Log.d(TAG, "getIncomingIntent: found intent extras.");
            String imageUrl =getIntent().getStringExtra("image_url");
            String imageName = getIntent().getStringExtra("name_url");
            String roleName = getIntent().getStringExtra("role_url");
            UID =  getIntent().getStringExtra("UID");
            setName(imageUrl,imageName,roleName);
        }

    }
    private void setName(String imageUrl, String imageName, String roleName){
        Log.d(TAG, "setName: setting name to widgets.");
        TextView n = findViewById(R.id.textView);
        n.setText(imageName);
        TextView r = findViewById(R.id.textView1);
        r.setText(roleName);

        ImageView imageView = findViewById(R.id.profile_image);
        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(imageView);
    }
}