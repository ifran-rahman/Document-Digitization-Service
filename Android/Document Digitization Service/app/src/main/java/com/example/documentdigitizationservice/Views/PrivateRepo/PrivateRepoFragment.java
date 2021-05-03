package com.example.documentdigitizationservice.Views.PrivateRepo;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.documentdigitizationservice.Models.File;
import com.example.documentdigitizationservice.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class PrivateRepoFragment extends Fragment {

    private ArrayList<File> files ;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private ChildEventListener childEventListener;
    private Button mSendButton;
    private String UID;

    private FirebaseAuth fAuth;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_private_repo, container, false);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("Users");

        files = new ArrayList<>();
        mSendButton = (Button)view.findViewById(R.id.sendButton);
        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: Send messages on click
                File friendlyMessage = new File("File name", "url", "18130");
                File friendlyMessage2 = new File("File name", "url", "43042");
                databaseReference.child(UID).child("PublicFIles").push().setValue(friendlyMessage);
                databaseReference.push().setValue(friendlyMessage2);

            }
        });

        RecyclerView recyclerView =  view.findViewById(R.id.private_repo_recyler_view);
        Context context = getActivity();
        final PrivateRepoAdapter adapter = new PrivateRepoAdapter(files,context);
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


        return view;
    }
    //
//    public void initBitmaps(){
//        File f = new File("file 4", "55555555555555");
//        files.add(f);
//        f = new File("file 5", "55555555555555");
//        files.add(f);
//        f = new File("file 5", "55555555555555");
//        files.add(f);
//
//    }
    public void setLayout(View view){

        RecyclerView recyclerView =  view.findViewById(R.id.private_repo_recyler_view);
        Context context = getActivity();
        PrivateRepoAdapter adapter = new PrivateRepoAdapter(files,context);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
    }


}
