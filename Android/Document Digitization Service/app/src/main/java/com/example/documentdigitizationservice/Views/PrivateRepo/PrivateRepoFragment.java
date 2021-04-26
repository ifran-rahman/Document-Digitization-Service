package com.example.documentdigitizationservice.Views.PrivateRepo;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.documentdigitizationservice.R;

import java.util.ArrayList;

public class PrivateRepoFragment extends Fragment {

    private ArrayList<String> mFolderNames = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_private_repo, container, false);

        initBitmaps();
        setLayout(view);
        return view;
    }

    public void initBitmaps(){
        mFolderNames.add("New folder");
        mFolderNames.add("Management folder");
        mFolderNames.add("Employe salary");
        mFolderNames.add("habi jabi");
        mFolderNames.add("lsjfj");

    }
    public void setLayout(View view){

        RecyclerView recyclerView =  view.findViewById(R.id.private_repo_recyler_view);
        Context context = getActivity();
        PrivateRepoAdapter adapter = new PrivateRepoAdapter(mFolderNames,context);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
    }


}
