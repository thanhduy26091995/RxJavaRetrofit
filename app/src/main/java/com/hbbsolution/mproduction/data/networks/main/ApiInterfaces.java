package com.hbbsolution.mproduction.data.networks.main;

import com.hbbsolution.mproduction.data.models.Home;
import com.hbbsolution.mproduction.data.response.BaseObjectResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by buivu on 20/09/2017.
 */

public interface ApiInterfaces {
    @GET("api/home")
    Observable<BaseObjectResponse<Home>> register();
}
