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

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        Button button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), Profile.class);
                startActivity(in);
            }
        });

        mImageUrls.add("https://www.google.com/url?sa=i&url=https%3A%2F%2Ftimesofindia.indiatimes.com%2Fentertainment%2Fbengali%2Fmovies%2Fnews%2Fshakib-khan-is-controversys-favourite-child%2Farticleshow%2F59309731.cms&psig=AOvVaw1wLoe0XTveBhAte6JwtgM9&ust=1619026822309000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCKixoIavjfACFQAAAAAdAAAAABAD");
        mUserNames.add("Anan Ghosh");
        mUserRoles.add("Developer");
        mImageUrls.add("https://scontent.fzyl1-1.fna.fbcdn.net/v/t1.6435-9/43322618_486658725170587_5381512967265189888_n.jpg?_nc_cat=103&ccb=1-3&_nc_sid=174925&_nc_ohc=DMd56GrqcHgAX_BSJT_&_nc_ht=scontent.fzyl1-1.fna&oh=98f608adca6118c98551683ba9a47c43&oe=609F54E7");
        mUserNames.add("Moshfique Uddin");
        mUserRoles.add("Developer");
        mImageUrls.add("https://scontent.fzyl1-1.fna.fbcdn.net/v/t1.6435-9/29365773_10209418393335535_3763052488496775168_n.jpg?_nc_cat=106&ccb=1-3&_nc_sid=174925&_nc_ohc=jf-4vU67vJwAX-S6KVt&_nc_ht=scontent.fzyl1-1.fna&oh=72a9138197f4b3d77729980d475b91c8&oe=609FCB6A");
        mUserNames.add("Hasibul Hassan");
        mUserRoles.add("Developer");
        mImageUrls.add("https://scontent.fzyl1-1.fna.fbcdn.net/v/t1.6435-9/94614491_2624999207779215_4015548479047729152_n.jpg?_nc_cat=104&ccb=1-3&_nc_sid=174925&_nc_ohc=ma3pKkLMHUEAX83OMkI&_nc_ht=scontent.fzyl1-1.fna&oh=c87d347089be0ebe7f119c6ea1f2a99d&oe=60A11804");
        mUserNames.add("Ifran Rahman Nijhum");
        mUserRoles.add("Developer");

        RecyclerView recyclerView =  view.findViewById(R.id.recyler_view);

        HomeViewAdapter adapter = new HomeViewAdapter(mImageUrls, mUserNames, mUserRoles);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }



}
