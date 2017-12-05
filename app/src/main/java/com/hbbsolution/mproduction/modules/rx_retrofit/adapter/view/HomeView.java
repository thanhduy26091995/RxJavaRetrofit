package com.hbbsolution.mproduction.modules.rx_retrofit.adapter.view;

import com.hbbsolution.mproduction.data.models.Product;
import com.hbbsolution.mproduction.modules.base.BaseView;

import java.util.List;

/**
 * Created by buivu on 16/11/2017.
 */

public interface HomeView extends BaseView {
    void showTestView();

    void showDataSearch(List<Product> productList);
}
