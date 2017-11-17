package com.hbbsolution.mproduction.data.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by buivu on 21/09/2017.
 */

public class Video implements Serializable{
   @SerializedName("_id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("youtubeId")
    private String youtubeId;
    @SerializedName("slug")
    private String slug;
    @SerializedName("image")
    private String image;
    @SerializedName("updated_at")
    private String updatedAt;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("duration")
    private String duration;
    @SerializedName("totalView")
    private int totalView;
    @SerializedName("totalLike")
    private int totalLike;
    @SerializedName("totalComment")
    private int totalComment;
    @SerializedName("islike")
    private boolean isLike;

    public boolean isLike() {
        return isLike;
    }

    public Video() {
    }

    public int getTotalView() {
        return totalView;
    }

    public int getTotalLike() {
        return totalLike;
    }

    public int getTotalComment() {
        return totalComment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYoutubeId() {
        return youtubeId;
    }

    public void setYoutubeId(String youtubeId) {
        this.youtubeId = youtubeId;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
