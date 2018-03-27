package com.example.manikandanvnair.psc.Firebase;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

/**
 * Created by manikandanvnair on 25/03/18.
 */

interface OnDataReceive
        {
            void onReceiveDataSnap(DataSnapshot snapshot);
            void onReceiveList(Map<String, Object> list);

        }


public class FirebaseMethods {
    String rootPath;
    String orderBy;
    Integer limit;
    private DatabaseReference mDataRef;

    public FirebaseMethods(String rootPath, String orderBy, Integer limit) {
        this.rootPath = rootPath;
        this.orderBy = orderBy;
        this.limit = limit;
    }

    public void getDataFromFirebase(String rootPath, Integer limit, String orderBy)
    {
        mDataRef = FirebaseDatabase.getInstance().getReference().child(rootPath);
        ValueEventListener firebaseValueListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
    }


}
