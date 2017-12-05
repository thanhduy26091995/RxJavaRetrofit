package com.hbbsolution.mproduction.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hbbsolution.mproduction.data.models.Video;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by buivu on 27/11/2017.
 */

public class ConvertStringToListVideo {
    public static List<Video> convert(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<Video>>() {
        }.getType();

        List<Video> videoList = gson.fromJson(json, type);
        return videoList;
    }
}
