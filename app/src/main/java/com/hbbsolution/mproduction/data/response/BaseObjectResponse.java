package com.hbbsolution.mproduction.data.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by buivu on 17/11/2017.
 */

public class BaseObjectResponse<T> {
    @SerializedName("success")
    private boolean success;
    @SerializedName("data")
    private T data;
    @SerializedName("errorCode")
    private String errorCode;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
