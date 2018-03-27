package com.example.manikandanvnair.psc.DailyFeeds;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.manikandanvnair.psc.Models.DailyFeed;
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
public class DailyFeeds extends Fragment {

    RecyclerView recyclerView;
    DailyFeedsPageAdapter dailyFeedsPageAdapter;
    List<DailyFeed> dailyFeedList;
    private DatabaseReference mDailyFeedRef;
    public static final String mDailyFeedKey = "DailyFeeds";



    public DailyFeeds() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment



        mDailyFeedRef = FirebaseDatabase.getInstance().getReference().child(mDailyFeedKey);

        dailyFeedList = new ArrayList<>();
        View view = inflater.inflate(R.layout.fragment_daily_feeds, container, false);
        recyclerView = view.findViewById(R.id.re_DailyFeeds);
        final Context  mContext = getActivity();
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));




        ValueEventListener dailyFeedListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Log.e("Count " ,""+dataSnapshot.getChildrenCount());
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    Map<String, Object> feeds = (HashMap<String,Object>) postSnapshot.getValue();
                    DailyFeed dailyFeed = new DailyFeed(feeds);
                    dailyFeedList.add(dailyFeed);


                }
                dailyFeedsPageAdapter = new DailyFeedsPageAdapter(mContext,dailyFeedList);
                recyclerView.setAdapter(dailyFeedsPageAdapter);
                //dailyFeedList.add(dailyFeed);
              //  Log.println(Log.INFO,"PSC", dailyFeed.toString());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }


        };
        mDailyFeedRef.addListenerForSingleValueEvent(dailyFeedListener);





        return view;


    }

}
