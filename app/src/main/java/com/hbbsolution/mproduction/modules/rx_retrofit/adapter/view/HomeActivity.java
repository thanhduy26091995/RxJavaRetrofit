package com.hbbsolution.mproduction.modules.rx_retrofit.adapter.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.hbbsolution.mproduction.R;
import com.hbbsolution.mproduction.modules.rx_retrofit.adapter.presenter.HomePresenter;
import com.hbbsolution.mproduction.modules.rx_retrofit.adapter.presenter.HomePresenterImpl;

/**
 * Created by buivu on 16/11/2017.
 */

public class HomeActivity extends AppCompatActivity implements HomeView {

    private HomePresenter homePresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        homePresenter = new HomePresenterImpl(this);
        homePresenter.getHome();
    }

    @Override
    public void showTestView() {
        Log.d("HAHAHA", "HAHAHA");
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
