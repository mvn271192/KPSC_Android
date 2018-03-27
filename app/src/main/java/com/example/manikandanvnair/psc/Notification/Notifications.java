package com.example.manikandanvnair.psc.Notification;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.manikandanvnair.psc.Models.NotificationData;
import com.example.manikandanvnair.psc.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class Notifications extends Fragment {

    RecyclerView recyclerView;
    NotificationPageAdapter notificationPageAdapter;
    List<NotificationData> notificationDataList;
    private DatabaseReference mNotificationRef;
    public static final String mNotificationKey = "Notifications";

    public Notifications() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        mNotificationRef = FirebaseDatabase.getInstance().getReference().child(mNotificationKey);

        notificationDataList = new ArrayList<>();
        View view = inflater.inflate(R.layout.fragment_notfications, container, false);
        recyclerView = view.findViewById(R.id.re_notifications);
        final Context mContext = getActivity();
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));




        ValueEventListener notficationEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Log.e("Count " ,""+dataSnapshot.getChildrenCount());
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    Map<String, Object> noti = (HashMap<String,Object>) postSnapshot.getValue();
                    NotificationData notificationData = new NotificationData(noti);
                    notificationDataList.add(notificationData);


                }
                notificationPageAdapter = new NotificationPageAdapter(mContext,notificationDataList);
                recyclerView.setAdapter(notificationPageAdapter);
                //dailyFeedList.add(dailyFeed);
                //  Log.println(Log.INFO,"PSC", dailyFeed.toString());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }


        };
        mNotificationRef.addListenerForSingleValueEvent(notficationEventListener);

        return view;
    }

}
