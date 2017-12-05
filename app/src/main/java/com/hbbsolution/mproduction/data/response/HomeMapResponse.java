package com.hbbsolution.mproduction.data.response;

import com.google.gson.annotations.SerializedName;
import com.hbbsolution.mproduction.data.models.HomeMap;

/**
 * Created by buivu on 23/11/2017.
 */

public class HomeMapResponse {
    @SerializedName("success")
    private boolean success;
    @SerializedName("data")
    private HomeMap data;
    @SerializedName("errorCode")
    private String errorCode;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public HomeMap getData() {
        return data;
    }

    public void setData(HomeMap data) {
        this.data = data;
    }
}
