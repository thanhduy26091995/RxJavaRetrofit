package com.hbbsolution.mproduction.modules.rx_retrofit.adapter.presenter;

import android.util.Log;

import com.hbbsolution.mproduction.data.models.Home;
import com.hbbsolution.mproduction.data.networks.api.ApiFunction;
import com.hbbsolution.mproduction.data.networks.api.ApiListener;
import com.hbbsolution.mproduction.data.networks.api.ApiStatus;
import com.hbbsolution.mproduction.modules.base.BasePresenter;
import com.hbbsolution.mproduction.modules.rx_retrofit.adapter.view.HomeView;

/**
 * Created by buivu on 16/11/2017.
 */

public class HomePresenterImpl extends BasePresenter<HomeView> implements HomePresenter, ApiListener {

    public HomePresenterImpl(HomeView mView) {
        super(mView);
    }

    @Override
    public void getHome() {
        mApiMethod.getHome();
       // mApiMethod.callMultipleAPI();
    }

    @Override
    public void onResponseListener(ApiFunction apifunction, ApiStatus statusId, Object object) {
        switch (apifunction) {
            case GET_HOME: {
                switch (statusId) {
                    case CALL_API_RESULT_SUCCESS: {
                        Home home = (Home) object;
                        getView().showTestView();
                        Log.d("SIZE", "" + home.getVideos().size());
                        break;
                    }
                }
                break;
            }

            case GET_MULTIPLE_API: {
                switch (statusId) {
                    case CALL_API_RESULT_SUCCESS: {
//                        HomeResponse homeResponse = (HomeResponse) object;
//                        getView().showTestView();
//                        Log.d("SIZE", "" + homeResponse.getData().getVideos().size());
                        break;
                    }
                }
                break;
            }

        }
    }
}
