package com.hbbsolution.mproduction.modules.rx_retrofit.adapter.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;

import com.hbbsolution.mproduction.R;
import com.hbbsolution.mproduction.data.models.Product;
import com.hbbsolution.mproduction.modules.base.BaseActivity;
import com.hbbsolution.mproduction.modules.rx_retrofit.adapter.DataAdapter;
import com.hbbsolution.mproduction.modules.rx_retrofit.adapter.presenter.HomePresenter;
import com.hbbsolution.mproduction.modules.rx_retrofit.adapter.presenter.HomePresenterImpl;
import com.hbbsolution.mproduction.utils.components.RxSearchObservable;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by buivu on 16/11/2017.
 */

public class HomeActivity extends BaseActivity implements HomeView {

    private HomePresenter homePresenter;
    @BindView(R.id.sv_search)
    SearchView mSearchView;
    @BindView(R.id.recycler_view)
    RecyclerView mRecycler;

    private DataAdapter mDataAdapter;
    private List<Product> mProducts;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSearchView = (SearchView) findViewById(R.id.sv_search);
        mRecycler = (RecyclerView) findViewById(R.id.recycler_view);
        //  ButterKnife.bind(this);
        homePresenter = new HomePresenterImpl(this);
        // homePresenter.getHome();
        handleSearchFeature();
        mProducts = new ArrayList<>();
        mDataAdapter = new DataAdapter(mProducts, this);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        mRecycler.setAdapter(mDataAdapter);
    }

    private void handleSearchFeature() {
        homePresenter.searchText(RxSearchObservable.fromView(mSearchView), 10, 1);
    }

    @Override
    public void showTestView() {
        Log.d("HAHAHA", "HAHAHA");
    }

    @Override
    public void showDataSearch(List<Product> productList) {
        mProducts.clear();
        mProducts.addAll(productList);
        mDataAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean isNetworkConnect() {
        return false;
    }

    @Override
    public void networkConnectError() {

    }

    @Override
    public void showDialogLoading() {

    }

    @Override
    public void hideDialogLoading() {

    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void hideProgressDialog() {

    }

    @Override
    public void showDialogError(int resId) {

    }
}
