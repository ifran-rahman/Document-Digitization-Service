package com.example.documentdigitizationservice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ProfileActivity extends AppCompatActivity {

    private static final String TAG = "ProfileActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Log.d(TAG, "onCreate: started.");
        getIncomingIntent();
    }
    private void getIncomingIntent(){
        Log.d(TAG, "getIncomingIntent: checking for incoming intents.");
        if(getIntent().hasExtra("image_url") && getIntent().hasExtra("name_url") && getIntent().hasExtra("role_url")){
            Log.d(TAG, "getIncomingIntent: found intent extras.");
            String imageUrl =getIntent().getStringExtra("image_url");
            String imageName = getIntent().getStringExtra("name_url");
            String roleName = getIntent().getStringExtra("role_url");
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