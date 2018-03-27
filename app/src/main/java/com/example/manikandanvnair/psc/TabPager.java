package com.example.manikandanvnair.psc;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.manikandanvnair.psc.DailyFeeds.DailyFeeds;
import com.example.manikandanvnair.psc.Notification.Notifications;

/**
 * Created by manikandanvnair on 24/03/18.
 */
public class TabPager extends FragmentStatePagerAdapter {

    String[]  titles = new String[]{"Daily Feeds","Notifications","Questions"};

    public TabPager(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    @Override
    public Fragment getItem(int position) {

        switch (position)
        {
            case 0:
                DailyFeeds dailyFeeds = new DailyFeeds();
                return  dailyFeeds;
            case 1:
                Notifications notifications = new Notifications();
                return notifications;
            case 2:
                Questions questions = new Questions();
                return questions;
        }
        return null;
    }

    @Override
    public int getCount() {
        return titles.length;
    }
}
