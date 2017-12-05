package com.hbbsolution.mproduction.data.response;

import com.google.gson.annotations.SerializedName;
import com.hbbsolution.mproduction.data.models.Products;

/**
 * Created by buivu on 22/08/2017.
 */

public class ProductResponse {
    @SerializedName("success")
    private boolean success;
    @SerializedName("errorCode")
    private int errorCode;
    @SerializedName("data")
    private Products products;

    public ProductResponse() {
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }
}
