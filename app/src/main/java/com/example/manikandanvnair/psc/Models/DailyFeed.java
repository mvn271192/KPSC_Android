package com.example.manikandanvnair.psc.Models;

import java.util.Map;

/**
 * Created by manikandanvnair on 24/03/18.
 */

public class DailyFeed {

    Integer type = 1; // default text data
    String textData;
    String title;
    String imageURL;
    String answer;
    Integer date;
    int size = 1; // default size

    public DailyFeed(String textData, String title) {
        this.textData = textData;
        this.title = title;
    }

    public DailyFeed(Map<String, Object> dailyFeed)
    {
//        snapshot.getValue()

        this.type = ((Long) dailyFeed.get("type")).intValue();
        this.date = ((Long) dailyFeed.get("date")).intValue();
        switch (this.type)
        {
            case 1:
                this.title = (String) dailyFeed.get("title");
                this.textData = (String) dailyFeed.get("textData");
                break;
            case 2:
                this.imageURL = (String) dailyFeed.get("imageURL");
                break;
            case 3:
                this.title = (String) dailyFeed.get("title");
                this.answer = (String) dailyFeed.get("answer");
        }
    }

    public Integer getType() {
        return type;
    }

    public String getTextData() {
        return textData;
    }

    public String getTitle() {
        return title;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getAnswer() {
        return answer;
    }

    public Integer getDate() {
        return date;
    }

    public int getSize() {
        return size;
    }
}

