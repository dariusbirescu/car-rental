package com.example.darius.carrental.fragments;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.adapters.RecyclerViewAdapter;
import com.example.darius.carrental.Car;
import com.example.darius.carrental.ImageAdapter;
import com.example.darius.carrental.ImagesActivity;
import com.example.darius.carrental.R;
import com.example.darius.carrental.Upload;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class OffersFragment extends Fragment {

    List<Car> cars;
    private DatabaseReference databaseReference;
    private List<Upload> uploadList;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.activity_offers, container, false);
        super.onCreate(savedInstanceState);

        uploadList=new ArrayList<>();
        databaseReference=FirebaseDatabase.getInstance().getReference("uploads");
        databaseReference.addValueEventListener(new ValueEventListener() {


            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for(DataSnapshot postSnapshot: dataSnapshot.getChildren()){
                    Upload upload = postSnapshot.getValue(Upload.class);
                    uploadList.add(upload);
                }
                RecyclerView myrv = (RecyclerView) view.findViewById(R.id.recyclerview_id);
                RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(view.getContext(),uploadList);
                myrv.setLayoutManager(new GridLayoutManager(view.getContext(),3));
                myrv.setAdapter(myAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(view.getContext(),databaseError.getMessage(),Toast.LENGTH_LONG).show();
            }
        });


        return  view;


    }
}
