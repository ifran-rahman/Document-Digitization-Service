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
        if(getIntent().hasExtra("image") && getIntent().hasExtra("name_url")){
            Log.d(TAG, "getIncomingIntent: found intent extras.");
            String imageUrl =getIntent().getStringExtra("image");
            String imagename = getIntent().getStringExtra("name_url");
            setName(imageUrl,imagename);
        }

    }
    private void setName(String imagename, String image){
        Log.d(TAG, "setName: setting name to widgets.");
        TextView n = findViewById(R.id.name);
        n.setText(imagename);

        ImageView imagev = findViewById(R.id.image1);
        Glide.with(this)
                .asBitmap()
                .load(image)
                .into(imagev);
    }
}