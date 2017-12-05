package com.hbbsolution.mproduction.data.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by buivu on 22/08/2017.
 */

public class Products {
    @SerializedName("current_page")
    private int currentPage;
    @SerializedName("data")
    private List<Product> products;
    @SerializedName("from")
    private int from;
    @SerializedName("last_page")
    private int last_page;
    @SerializedName("next_page_url")
    private String nextPageUrl;
    @SerializedName("path")
    private String path;
    @SerializedName("per_page")
    private int perPage;
    @SerializedName("prev_page_url")
    private String prevPageUrl;
    @SerializedName("to")
    private int to;
    @SerializedName("total")
    private int total;

    public Products() {
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getLast_page() {
        return last_page;
    }

    public void setLast_page(int last_page) {
        this.last_page = last_page;
    }

    public String getNextPageUrl() {
        return nextPageUrl;
    }

    public void setNextPageUrl(String nextPageUrl) {
        this.nextPageUrl = nextPageUrl;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public String getPrevPageUrl() {
        return prevPageUrl;
    }

    public void setPrevPageUrl(String prevPageUrl) {
        this.prevPageUrl = prevPageUrl;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
