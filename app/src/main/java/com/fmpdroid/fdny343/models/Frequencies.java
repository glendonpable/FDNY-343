package com.fmpdroid.fdny343.models;

/**
 * Created by sagara213@gmail.com on 11/20/2016.
 */
public class Frequencies {
    private String feed;

    public Frequencies(){
    }

    public Frequencies(String feed){
        this.feed = feed;
    }

    public String getFeed() {
        return feed;
    }

    public void setFeed(String feed) {
        this.feed = feed;
    }
}
