package com.hbbsolution.mproduction.data.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by buivu on 23/11/2017.
 */

public class HomeMap {
    @SerializedName("songs")
    private List<Song> songs;

    @SerializedName("videos")
    private List<Video> videos;

    public List<Song> getSongs() {
        return songs;
    }

    public List<Video> getVideos() {
        return videos;
    }
}
