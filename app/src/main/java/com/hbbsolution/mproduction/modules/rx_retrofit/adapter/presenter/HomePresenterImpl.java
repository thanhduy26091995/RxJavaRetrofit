package com.hbbsolution.mproduction.modules.rx_retrofit.adapter.presenter;

import android.util.Log;

import com.hbbsolution.mproduction.data.models.Home;
import com.hbbsolution.mproduction.data.networks.api.ApiFunction;
import com.hbbsolution.mproduction.data.networks.api.ApiListener;
import com.hbbsolution.mproduction.data.networks.api.ApiStatus;
import com.hbbsolution.mproduction.data.response.ProductResponse;
import com.hbbsolution.mproduction.modules.base.BasePresenter;
import com.hbbsolution.mproduction.modules.rx_retrofit.adapter.view.HomeView;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by buivu on 16/11/2017.
 */

public class HomePresenterImpl extends BasePresenter<HomeView> implements HomePresenter, ApiListener {

    public HomePresenterImpl(HomeView mView) {
        super(mView);
    }

    @Override
    public void getHome() {
        // mApiMethod.getHome();
        //   mApiMethod.callMultipleAPIUsingZip();
        // mApiMethod.callApiFilter();
        //   mApiMethod.callMultipleAPI();
        // mApiMethod.callMultipleAPI();
        String json = " [\n" +
                "      {\n" +
                "        \"_id\": \"59f2e36bd3443828abc93105\",\n" +
                "        \"name\": \"VTV3 - Chuyện Bên Ly Cafe - Vượt Qua Định Kiến - Thu Hương\",\n" +
                "        \"image\": \"https://img.youtube.com/vi/LbJed37nZq8/0.jpg\",\n" +
                "        \"youtubeId\": \"LbJed37nZq8\",\n" +
                "        \"view\": 175,\n" +
                "        \"slug\": \"vtv3-chuyen-ben-ly-cafe-vuot-qua-dinh-kien-thu-huong\",\n" +
                "        \"duration\": \"699\",\n" +
                "        \"created_at\": \"2017-10-27T07:42:35.017Z\",\n" +
                "        \"updated_at\": \"2017-10-27T07:42:35.017Z\",\n" +
                "        \"totalView\": 175,\n" +
                "        \"totalLike\": 5,\n" +
                "        \"totalComment\": 12,\n" +
                "        \"commentInVideo\": {\n" +
                "          \"_id\": \"5a00363a34f60a1bb940fc5d\",\n" +
                "          \"fromId\": \"59f2e36bd3443828abc93105\",\n" +
                "          \"comment\": \"Đặc biệt, ở thời điểm gần cuối chương trình, một khán giả đã đứng lên đặt câu hỏi về suy nghĩ của Jack Ma về Việt Nam ở thời điểm hiện tại cũng như các cơ hội trong tương lai. Ở đây, vị Chủ tịch Tập đoàn Alibaba đã không ngần ngại lấy chính ‘giới trẻ Việt Nam’ ra để làm keyword cho câu trả lời của mình.\",\n" +
                "          \"userId\": \"5a00350f34f60a1bb940fc51\",\n" +
                "          \"userName\": \"Ly chau\",\n" +
                "          \"__v\": 0,\n" +
                "          \"created_at\": \"2017-11-06T10:15:22.691Z\"\n" +
                "        },\n" +
                "        \"islike\": false\n" +
                "      },\n" +
                "      {\n" +
                "        \"_id\": \"59f2e353d3443828abc93104\",\n" +
                "        \"name\": \"Vẻ Đẹp Cuộc Sống : Á hậu Nguyễn Thu Hương\",\n" +
                "        \"image\": \"https://img.youtube.com/vi/yDskpSVqdH0/0.jpg\",\n" +
                "        \"youtubeId\": \"yDskpSVqdH0\",\n" +
                "        \"view\": 53,\n" +
                "        \"slug\": \"ve-dep-cuoc-song-a-hau-nguyen-thu-huong\",\n" +
                "        \"duration\": \"899\",\n" +
                "        \"created_at\": \"2017-10-27T07:42:11.202Z\",\n" +
                "        \"updated_at\": \"2017-10-27T07:42:11.202Z\",\n" +
                "        \"totalView\": 53,\n" +
                "        \"totalLike\": 3,\n" +
                "        \"totalComment\": 3,\n" +
                "        \"commentInVideo\": {\n" +
                "          \"_id\": \"59faf144ac56a91f7ef7d3ea\",\n" +
                "          \"fromId\": \"59f2e353d3443828abc93104\",\n" +
                "          \"comment\": \"Hay\",\n" +
                "          \"userId\": \"59f9717bac56a91f7ef7d3d0\",\n" +
                "          \"userName\": \"Fan thu huong\",\n" +
                "          \"__v\": 0,\n" +
                "          \"created_at\": \"2017-11-02T10:19:48.104Z\"\n" +
                "        },\n" +
                "        \"islike\": false\n" +
                "      }\n" +
                "    ]";
        // mApiMethod.callApiUsingMap();
        //mApiMethod.convertJSONToListUsingMap(json);
        // mApiMethod.convertJSONToListUsingFlatMap(json);
        //mApiMethod.convertJSONAndFilterUsingFlatmapAndFilter(json);
        //mApiMethod.demoSkipOperator();
        mApiMethod.demoIntervalOperator();
    }

    @Override
    public Observable<ProductResponse> searchData(String text) {
        return mApiMethod.searchData(10, text, 1);
    }

    @Override
    public void searchText(Observable<String> observable, final int categoryId, final int page) {
        observable.debounce(300, TimeUnit.MILLISECONDS)
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(String s) throws Exception {
                        Log.d("RESULT", "filter");
                        if (s.isEmpty()) {
                            return false;
                        }
                        return true;
                    }
                })
                .distinctUntilChanged()
                .switchMap(new Function<String, ObservableSource<ProductResponse>>() {
                    @Override
                    public ObservableSource<ProductResponse> apply(String s) throws Exception {
                        Log.d("RESULT", "switchMap");
                        return mApiMethod.searchData(categoryId, s, page);
                    }
                }).subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(Schedulers.io())
                .subscribe(new Consumer<ProductResponse>() {
                    @Override
                    public void accept(ProductResponse productResponse) throws Exception {
                        getView().showDataSearch(productResponse.getProducts().getProducts());
//                        Log.d("RESULT", "" + productResponse.getProducts().getProducts().size());
                    }
                });
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
