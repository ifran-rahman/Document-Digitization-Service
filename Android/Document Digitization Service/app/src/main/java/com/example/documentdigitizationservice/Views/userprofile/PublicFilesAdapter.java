package com.example.documentdigitizationservice.Views.userprofile;

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

import com.example.documentdigitizationservice.Models.File;
import com.example.documentdigitizationservice.R;

import java.util.ArrayList;
public class PublicFilesAdapter extends RecyclerView.Adapter<PublicFilesAdapter.ViewHolder>{
    private static final String TAG = "PrivateRepoAdapter";

    private ArrayList<File> files;
    private Context mContext;


    public PublicFilesAdapter(ArrayList<File> files, Context mContext) {
        this.files = files;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public PublicFilesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.private_repo_item, parent, false);
        PublicFilesAdapter.ViewHolder vh = new PublicFilesAdapter.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        ((PublicFilesAdapter.ViewHolder)viewHolder).username.setText(files.get(position).getName());

        ((PublicFilesAdapter.ViewHolder)viewHolder).parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on: " + files.get(position).getName());
                Toast.makeText(mContext, files.get(position).getFileurl(), Toast.LENGTH_SHORT).show();

            }
        });
    }


    @Override
    public int getItemCount() {
        return files.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView username;
        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.folder_name);
            parentLayout = itemView.findViewById(R.id.private_repo_item_layout);
        }
    }


}
