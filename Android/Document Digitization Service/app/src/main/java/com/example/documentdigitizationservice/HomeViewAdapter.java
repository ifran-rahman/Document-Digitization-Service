package com.example.documentdigitizationservice;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.documentdigitizationservice.R;


import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeViewAdapter extends RecyclerView.Adapter<HomeViewAdapter.ViewHolder>{

    private static final String TAG = "RecyclerviewAdapter";

    private ArrayList<String> mImages = new ArrayList<>();
    private ArrayList<String> mUserNames = new ArrayList<>();
    private ArrayList<String> mUserRoles = new ArrayList<>();
    private Context mContext;

    public HomeViewAdapter(ArrayList<String> mImages, ArrayList<String> mUserNames, ArrayList<String> mUserRoles, Context mContext) {
        this.mImages = mImages;
        this.mUserNames = mUserNames;
        this.mUserRoles = mUserRoles;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {

        Glide.with(mContext)
                .asBitmap()
                .load(mImages.get(position))
                .into(viewHolder.image);
        Log.d(TAG, "onBindviewholder");

        // Set the name of the 'user'
        ((ViewHolder)viewHolder).username.setText(mUserNames.get(position));
        ((ViewHolder)viewHolder).userrole.setText(mUserRoles.get(position));

        viewHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on: " + mUserNames.get(position));
                Toast.makeText(mContext, mUserNames.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mUserNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView image;
        TextView username;
        TextView userrole;
        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.HomeItemImage);
            username = itemView.findViewById(R.id.username);
            userrole = itemView.findViewById(R.id.userrole);
            parentLayout = itemView.findViewById(R.id.home_item_layout);
        }
    }


}
