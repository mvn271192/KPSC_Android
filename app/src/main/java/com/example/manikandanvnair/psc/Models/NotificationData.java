package com.example.manikandanvnair.psc.Models;

import java.util.Map;

/**
 * Created by manikandanvnair on 26/03/18.
 */

public class NotificationData {

    String title;
    String content;
    String link;
    String imageUrl;
    Integer dateStamp;

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getLink() {
        return link;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Integer getDateStamp() {
        return dateStamp;
    }

    public NotificationData(Map<String, Object> notification)
    {
        this.dateStamp = ((Long) notification.get("date")).intValue();
        this.title = (String) notification.get("title");
        this.content = (String) notification.get("textData");
        this.imageUrl = (String) notification.get("imageURL");
        this.link = (String) notification.get("url");

    }
}
