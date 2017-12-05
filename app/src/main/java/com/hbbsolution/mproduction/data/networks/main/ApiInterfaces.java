package com.hbbsolution.mproduction.data.networks.main;

import com.hbbsolution.mproduction.data.models.Home;
import com.hbbsolution.mproduction.data.response.BaseObjectResponse;
import com.hbbsolution.mproduction.data.response.ProductResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by buivu on 20/09/2017.
 */

public interface ApiInterfaces {
    @GET("api/home")
    Observable<BaseObjectResponse<Home>> register();

    Observable<String> convertJSONToList(String json);

    @GET("products/categories-parent/{category_id}")
    Observable<ProductResponse> getProductByCategory(@Path("category_id") int categoryId, @Query("text") String text, @Query("page") int page);
}
