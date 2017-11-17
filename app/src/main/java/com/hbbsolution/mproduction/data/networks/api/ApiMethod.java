package com.hbbsolution.mproduction.data.networks.api;

import android.util.Log;

import com.hbbsolution.mproduction.data.networks.main.ApiClient;
import com.hbbsolution.mproduction.data.networks.main.ApiInterfaces;
import com.hbbsolution.mproduction.data.response.BaseObjectResponse;
import com.hbbsolution.mproduction.data.response.HomeResponse;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by buivu on 20/09/2017.
 */

public class ApiMethod {
    ApiListener mApiListener;

    public void setmApiListener(ApiListener mApiListener) {
        this.mApiListener = mApiListener;
    }

    public void getHome() {
        ApiInterfaces apiInterfaces = ApiClient.getClientRx().create(ApiInterfaces.class);
        handleResponseObject(apiInterfaces.register(), ApiFunction.GET_HOME);
//        apiInterfaces.register()
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe(new DisposableObserver<BaseObjectResponse<Home>>() {
//                    @Override
//                    public void onNext(BaseObjectResponse<Home> value) {
//                        if (value.isSuccess()) {
//                            mApiListener.onResponseListener(ApiFunction.GET_HOME, ApiStatus.CALL_API_RESULT_SUCCESS, value.getData());
//                        } else {
//                            mApiListener.onResponseListener(ApiFunction.GET_HOME, ApiStatus.CALL_API_RESULT_NO_DATA, value);
//                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        mApiListener.onResponseListener(ApiFunction.GET_HOME, ApiStatus.CALL_API_RESULT_FAILURE, e.getMessage());
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d("COMPLETE", "TRUE");
//                    }
//                });

    }

    private <T> void handleResponseObject(Observable<BaseObjectResponse<T>> observable, final ApiFunction apiFunction) {
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new DisposableObserver<BaseObjectResponse<T>>() {
                    @Override
                    public void onNext(BaseObjectResponse<T> value) {
                        if (value.isSuccess()) {
                            mApiListener.onResponseListener(apiFunction, ApiStatus.CALL_API_RESULT_SUCCESS, value.getData());
                        } else {
                            mApiListener.onResponseListener(apiFunction, ApiStatus.CALL_API_RESULT_NO_DATA, value);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public Observable callApi1() {
        ApiInterfaces apiInterfaces = ApiClient.getClientRx().create(ApiInterfaces.class);
        Observable observable = apiInterfaces.register()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
        return observable;
    }

    public void callMultipleAPI() {
        Observable.merge(callApi1(), callApi1()).subscribe(new DisposableObserver<HomeResponse>() {
            @Override
            public void onNext(HomeResponse value) {
                Log.d("SIZE", "" + value.getData().getVideos().size());
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.d("COMPLETE", "TRUE");
            }
        });
    }

}
