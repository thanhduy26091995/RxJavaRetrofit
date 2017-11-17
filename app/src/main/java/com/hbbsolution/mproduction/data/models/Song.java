package com.hbbsolution.mproduction.data.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by buivu on 21/09/2017.
 */

public class Song implements Serializable{
    @SerializedName("_id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("composer")
    private String composer;
    @SerializedName("slug")
    private String slug;
    @SerializedName("lyrics")
    private String lyrics;
    @SerializedName("link")
    private String link;
    @SerializedName("updated_at")
    private String updatedAt;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("view")
    private Integer view;
    @SerializedName("like")
    private Integer like;
    @SerializedName("singer")
    private String singer;
    @SerializedName("image")
    private String image;
//    @SerializedName("albumId")
//    private AlbumDataInSong albumDataInSong;

    public Song() {
    }

    public Song(String name, String lyrics, Integer view) {
        this.name = name;
        this.lyrics = lyrics;
        this.view = view;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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

    public Integer getView() {
        return view;
    }

    public void setView(Integer view) {
        this.view = view;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

//    public AlbumDataInSong getAlbumDataInSong() {
//        return albumDataInSong;
//    }
//
//    public void setAlbumDataInSong(AlbumDataInSong albumDataInSong) {
//        this.albumDataInSong = albumDataInSong;
//    }
}
