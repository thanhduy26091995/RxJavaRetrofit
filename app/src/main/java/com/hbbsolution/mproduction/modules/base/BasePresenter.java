package com.hbbsolution.mproduction.modules.base;

import com.hbbsolution.mproduction.data.networks.api.ApiFunction;
import com.hbbsolution.mproduction.data.networks.api.ApiListener;
import com.hbbsolution.mproduction.data.networks.api.ApiMethod;
import com.hbbsolution.mproduction.data.networks.api.ApiStatus;

/**
 * Created by buivu on 16/11/2017.
 */

public class BasePresenter<T extends BaseView> implements ApiListener {

    protected ApiMethod mApiMethod;
    private T mView;

    public BasePresenter(T mView) {
        this.mView = mView;
        mApiMethod = new ApiMethod();
        mApiMethod.setmApiListener(this);
    }

    public T getView() {
        return mView;
    }

    @Override
    public void onResponseListener(ApiFunction apifunction, ApiStatus statusId, Object object) {

    }
}
