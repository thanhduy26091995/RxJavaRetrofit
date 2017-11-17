package com.hbbsolution.mproduction.data.response;

import com.google.gson.annotations.SerializedName;
import com.hbbsolution.mproduction.data.models.Home;

/**
 * Created by buivu on 27/09/2017.
 */

public class HomeResponse {
    @SerializedName("success")
    private boolean success;
    @SerializedName("data")
    private Home data;
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

    public Home getData() {
        return data;
    }

    public void setData(Home data) {
        this.data = data;
    }
}
