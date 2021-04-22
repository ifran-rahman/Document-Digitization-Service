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
                Intent in = new Intent(getActivity(), ProfileActivity.class);
                startActivity(in);
            }
        });


        initBitmaps();
        setLayout(view);
        return view;
    }

    public void initBitmaps(){
        mImageUrls.add("https://scontent.fzyl1-1.fna.fbcdn.net/v/t1.6435-9/43322618_486658725170587_5381512967265189888_n.jpg?_nc_cat=103&ccb=1-3&_nc_sid=174925&_nc_ohc=DMd56GrqcHgAX_BSJT_&_nc_ht=scontent.fzyl1-1.fna&oh=98f608adca6118c98551683ba9a47c43&oe=609F54E7");
        mUserNames.add("Moshfique Uddin");
        mUserRoles.add("Developer");
        mImageUrls.add("https://scontent.fzyl1-1.fna.fbcdn.net/v/t1.6435-9/158900688_2019518771524579_9061371679276739948_n.jpg?_nc_cat=105&ccb=1-3&_nc_sid=174925&_nc_ohc=d70bLeGK97MAX8US1F5&_nc_ht=scontent.fzyl1-1.fna&oh=9588540ad4141ece406310ba89999a86&oe=60A42193");
        mUserNames.add("Anan Ghosh");
        mUserRoles.add("Developer");
        mImageUrls.add("https://scontent.fzyl1-1.fna.fbcdn.net/v/t1.6435-9/29365773_10209418393335535_3763052488496775168_n.jpg?_nc_cat=106&ccb=1-3&_nc_sid=174925&_nc_ohc=jf-4vU67vJwAX-S6KVt&_nc_ht=scontent.fzyl1-1.fna&oh=72a9138197f4b3d77729980d475b91c8&oe=609FCB6A");
        mUserNames.add("Hasibul Hassan");
        mUserRoles.add("Developer");
        mImageUrls.add("https://scontent.fdac37-1.fna.fbcdn.net/v/t1.6435-9/126514380_2802414473371020_8451433866813751474_n.jpg?_nc_cat=109&ccb=1-3&_nc_sid=09cbfe&_nc_ohc=Dn2mVFk4IFAAX_dEOZh&_nc_ht=scontent.fdac37-1.fna&oh=7fcf70f1ef3e4b741b3bf23c6a76cf8e&oe=60A7C8B8");
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
