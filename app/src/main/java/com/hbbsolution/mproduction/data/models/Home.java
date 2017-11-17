package com.hbbsolution.mproduction.data.models;

import com.google.gson.annotations.SerializedName;
import com.hbbsolution.mproduction.modules.base.BaseModel;

import java.util.List;

/**
 * Created by buivu on 27/09/2017.
 */

public class Home extends BaseModel{
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
