package com.hbbsolution.mproduction.data.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by buivu on 22/08/2017.
 */

public class Product implements Serializable {
    @SerializedName("id")
    private int id;
    @SerializedName("user_id")
    private Integer userId;
    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private String description;
    @SerializedName("supplier_id")
    private int supplierId;
    @SerializedName("price_old")
    private float priceOld;
    @SerializedName("saving")
    private int saving;
    @SerializedName("photos")
    private List<String> photos;
    @SerializedName("category_id")
    private int categoryId;
    @SerializedName("price_per_item")
    private int pricePerItem;
    @SerializedName("quantity")
    private int quantity;
    @SerializedName("unit_id")
    private int unitId;
    @SerializedName("currency_id")
    private int currencyId;
    @SerializedName("location")
    private String location;
    @SerializedName("info")
    private String info;
    @SerializedName("info_packaging")
    private String infoPackaging;

    private String unitCurrency;
    private String unitNumber;

    public String getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }

    public String getUnitCurrency() {
        return unitCurrency;
    }

    public void setUnitCurrency(String unitCurrency) {
        this.unitCurrency = unitCurrency;
    }



    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public float getPriceOld() {
        return priceOld;
    }

    public void setPriceOld(float priceOld) {
        this.priceOld = priceOld;
    }

    public int getSaving() {
        return saving;
    }

    public void setSaving(int saving) {
        this.saving = saving;
    }


    public Product() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfoPackaging() {
        return infoPackaging;
    }

    public void setInfoPackaging(String infoPackaging) {
        this.infoPackaging = infoPackaging;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getPricePerItem() {
        return pricePerItem;
    }

    public void setPricePerItem(int pricePerItem) {
        this.pricePerItem = pricePerItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }

    public int getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(int currencyId) {
        this.currencyId = currencyId;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
