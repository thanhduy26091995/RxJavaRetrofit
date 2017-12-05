package com.hbbsolution.mproduction.modules.rx_retrofit.adapter.presenter;

import com.hbbsolution.mproduction.data.response.ProductResponse;

import io.reactivex.Observable;

/**
 * Created by buivu on 16/11/2017.
 */

public interface HomePresenter {
    void getHome();

    Observable<ProductResponse> searchData(String text);

    void searchText(Observable<String> observable, int categoryId, int page);
}
