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

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


public class NotificationViewAdapter extends RecyclerView.Adapter<NotificationViewAdapter.ViewHolder>{

    private static final String TAG = "NotificationViewAdapter";

    private ArrayList<String> mUserNames = new ArrayList<>();
    private ArrayList<String> mUserRoles = new ArrayList<>();
    private Context mContext;

    public NotificationViewAdapter(ArrayList<String> mImagenames, ArrayList<String> mUserRoles, Context mContext) {

        this.mUserNames = mImagenames;
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

        ((ViewHolder)viewHolder).NotificationName.setText(mUserNames.get(position));
        ((ViewHolder)viewHolder).NotificationDetails.setText(mUserRoles.get(position));

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
        TextView NotificationName;
        TextView NotificationDetails;
        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            NotificationName = itemView.findViewById(R.id.NotificationName);
            NotificationDetails = itemView.findViewById(R.id.NotificationName);
            parentLayout = itemView.findViewById(R.id.notification_item_layout);
        }
    }


}
