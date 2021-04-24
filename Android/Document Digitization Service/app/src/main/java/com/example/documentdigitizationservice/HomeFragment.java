package com.example.documentdigitizationservice;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private ArrayList<String> mUserNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mUserRoles = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        initBitmaps();
        setLayout(view);
        return view;
    }

    public void initBitmaps(){
        mImageUrls.add("data:image/jpeg;base64,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");
        mUserNames.add("Moshfique Uddin");
        mUserRoles.add("Developer");
        mImageUrls.add("data:image/jpeg;base64,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");
        mUserNames.add("Anan Ghosh");
        mUserRoles.add("Developer");
        mImageUrls.add("data:image/jpeg;base64,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");
        mUserNames.add("Hasibul Hassan");
        mUserRoles.add("Developer");
        mImageUrls.add("data:image/jpeg;base64,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");
        mUserNames.add("Ifran Rahman Nijhum");
        mUserRoles.add("Developer");

    }
    public void setLayout(View view){

        RecyclerView recyclerView =  view.findViewById(R.id.home_recyler_view);
        Context context = getActivity();
        HomeViewAdapter adapter = new HomeViewAdapter(mImageUrls, mUserNames, mUserRoles, context);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
    }


}
