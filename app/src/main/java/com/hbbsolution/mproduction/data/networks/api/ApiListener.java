package com.hbbsolution.mproduction.data.networks.api;

/**
 * Created by Administrator on 18/07/2017.
 */

public interface ApiListener {
    void onResponseListener(ApiFunction apifunction, ApiStatus statusId, Object object);
}
