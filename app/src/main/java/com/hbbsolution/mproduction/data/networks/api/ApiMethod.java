package com.hbbsolution.mproduction.data.networks.api;

import android.util.Log;

import com.hbbsolution.mproduction.data.models.Home;
import com.hbbsolution.mproduction.data.models.HomeMap;
import com.hbbsolution.mproduction.data.models.Video;
import com.hbbsolution.mproduction.data.networks.main.ApiClient;
import com.hbbsolution.mproduction.data.networks.main.ApiInterfaces;
import com.hbbsolution.mproduction.data.response.BaseObjectResponse;
import com.hbbsolution.mproduction.data.response.HomeResponse;
import com.hbbsolution.mproduction.data.response.ProductResponse;
import com.hbbsolution.mproduction.utils.ConvertStringToListVideo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

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

    public Observable<HomeResponse> callApi1() {
        ApiInterfaces apiInterfaces = ApiClient.getClientRx().create(ApiInterfaces.class);
        Observable observable = apiInterfaces.register()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
        return observable;
    }

    public Observable<String> getListVideo(final String json) {
        return Observable.just(json);
//        return Observable.create(new ObservableOnSubscribe<String>() {
//            @Override
//            public void subscribe(ObservableEmitter<String> e) throws Exception {
//                if (e.isDisposed()){
//                    e.onNext(json);
//                    e.onComplete();
//                }
//            }
//        });
    }

    /*
    sử dụng merge: merge sẽ gọi 2 tác vụ song song, kết quả trả về sẽ riêng lẻ theo từng observable
     */
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

    /*
    sừ dụng zip đề gọi các tác vụ đồng thời, kết quả trả về sẽ gộp chung lại
     */
    public void callMultipleAPIUsingZip() {
        Observable.zip(callApi1(), callApi1(), new BiFunction<HomeResponse, HomeResponse, List<HomeResponse>>() {
            @Override
            public List<HomeResponse> apply(HomeResponse homeResponse, HomeResponse homeResponse2) throws Exception {
                List<HomeResponse> homeResponses = new ArrayList<HomeResponse>();
                homeResponses.add(homeResponse);
                homeResponses.add(homeResponse2);
                return homeResponses;
            }
        }).subscribe(new DisposableObserver<List<HomeResponse>>() {
            @Override
            public void onNext(List<HomeResponse> value) {
                Log.d("SIZE", "" + value.size());
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    /*
    filter dùng dể lọc các kết quả
     */
    public void callApiFilter() {
        Observable.just(callApi1()).filter(new Predicate<Observable<HomeResponse>>() {
            @Override
            public boolean test(Observable<HomeResponse> homeResponseObservable) throws Exception {
                Log.d("SIZE", "test");
                return false;
            }
        }).subscribe(new DisposableObserver<Observable<HomeResponse>>() {
            @Override
            public void onNext(Observable<HomeResponse> value) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    /*
    map nhận đầu vào là 1 type, đầu ra là 1 type khác cùng kiểu hoặc khác kiểu
     */
    public void callApiUsingMap() {
        ApiInterfaces apiInterfaces = ApiClient.getClientRx().create(ApiInterfaces.class);
        apiInterfaces.register()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map(new Function<BaseObjectResponse<Home>, BaseObjectResponse<HomeMap>>() {
                    @Override
                    public BaseObjectResponse<HomeMap> apply(BaseObjectResponse<Home> homeBaseObjectResponse) throws Exception {
                        Log.d("RESULT", "map");
                        BaseObjectResponse<HomeMap> homeMapBaseObjectResponse = new BaseObjectResponse<HomeMap>();
                        homeBaseObjectResponse.setData(homeBaseObjectResponse.getData());
                        homeBaseObjectResponse.setErrorCode(homeBaseObjectResponse.getErrorCode());
                        return homeMapBaseObjectResponse;
                    }
                }).subscribe(new DisposableObserver<BaseObjectResponse<HomeMap>>() {
            @Override
            public void onNext(BaseObjectResponse<HomeMap> value) {
                Log.d("RESULT", value.getData().getVideos().size() + "/" + value.getErrorCode() + "/" + value.isSuccess());
            }

            @Override
            public void onError(Throwable e) {
                Log.d("RESULT", e.toString());
            }

            @Override
            public void onComplete() {
                Log.d("RESULT", "complete");
            }
        });
    }

    public void convertJSONToListUsingMap(String json) {
        getListVideo(json).map(new Function<String, List<Video>>() {
            @Override
            public List<Video> apply(String s) throws Exception {
                Log.d("JSON", s);
                List<Video> videoList = ConvertStringToListVideo.convert(s);
                return videoList;
            }
        }).subscribe(new DisposableObserver<List<Video>>() {
            @Override
            public void onNext(List<Video> value) {
                Log.d("RESULT", "" + value.size());
            }

            @Override
            public void onError(Throwable e) {
                Log.d("RESULT", e.toString());
            }

            @Override
            public void onComplete() {
                Log.d("RESULT", "onComplete");
            }
        });
    }

    /*
    Giống như map, nhưng flatMap phát ra 1 Obserable, chứ k phải là 1 type => linh hoạt hon
     */
    public void convertJSONToListUsingFlatMap(String json) {
        getListVideo(json).flatMap(new Function<String, ObservableSource<List<Video>>>() {
            @Override
            public ObservableSource<List<Video>> apply(String s) throws Exception {
                return Observable.just(ConvertStringToListVideo.convert(s));
            }
        }).subscribe(new DisposableObserver<List<Video>>() {
            @Override
            public void onNext(List<Video> value) {
                Log.d("RESULT", "" + value.size());
            }

            @Override
            public void onError(Throwable e) {
                Log.d("RESULT", e.toString());
            }

            @Override
            public void onComplete() {
                Log.d("RESULT", "onComplete");
            }
        });
    }

    /*
    kết hợp flatmap và filter
     */
    public void convertJSONAndFilterUsingFlatmapAndFilter(String json) {
        getListVideo(json).flatMap(new Function<String, Observable<Video>>() {
            @Override
            public Observable<Video> apply(String s) throws Exception {
                return Observable.fromIterable(ConvertStringToListVideo.convert(s));
            }
        }).filter(new Predicate<Video>() {
            @Override
            public boolean test(Video video) throws Exception {
                return video.getTotalView() > 100;

            }
        }).toList()
                .subscribe(new DisposableSingleObserver<List<Video>>() {
                    @Override
                    public void onSuccess(List<Video> value) {
                        Log.d("RESULT", "" + value.size());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    /*
    Sử dụng operator skip để không emit các item
     */
    public void demoSkipOperator() {
        Observable.just(1, 2, 3, 4, 5)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .skip(2)
                .subscribe(new DisposableObserver<Integer>() {
                    @Override
                    public void onNext(Integer value) {
                        Log.d("RESULT", "" + value);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    /*
    Sử dụng operator Interval để emit các item kiểu long sau 1 khoảng thời gian
     */

    public void demoIntervalOperator() {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        compositeDisposable.add(Observable.interval(0, 2, TimeUnit.SECONDS)
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(Schedulers.newThread())
                .subscribeWith(new DisposableObserver<Long>() {
                    @Override
                    public void onNext(Long value) {
                        Log.d("RESULT", "" + value);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                }));
    }

    /*
    Sử dụng PublishSubject để phát ra những item của nguồn Observable tại thời điểm đăng ký
     */
    public void demoPublishSubject() {
        PublishSubject<Integer> source = PublishSubject.create();
        source.subscribe(new DisposableObserver<Integer>() {
            @Override
            public void onNext(Integer value) {
                Log.d("RESULT", "" + value);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
        source.onNext(1);
        source.onNext(2);

        source.subscribe(new DisposableObserver<Integer>() {
            @Override
            public void onNext(Integer value) {
                Log.d("RESULT", "" + value);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
        source.onNext(3);
    }
    /*
    Thực hiện tính năng search sử dụng rx Java, có sử dụng
    Publish Subject: Dùng để nhận sự kiện khi searchview thay đổi
     Debounce: delay 1 khoảng thời gian trước khi gửi đi sự kiện
     DistintUntilChanged: sử dụng operator này để tránh các request trùng nhau
     */

    public Observable<ProductResponse> searchData(int categoryId, String text, int page) {
        ApiInterfaces apiInterfaces = ApiClient.getClientRx().create(ApiInterfaces.class);
        return apiInterfaces.getProductByCategory(categoryId, text, page);
    }
//    public void searchData(SearchView searchView) {
//        RxSearchObservable.fromView(searchView)
//                .debounce(300, TimeUnit.MILLISECONDS)
//                .filter(new Predicate<String>() {
//                    @Override
//                    public boolean test(String s) throws Exception {
//                        if (s.isEmpty()) {
//                            return false;
//                        }
//                        return true;
//                    }
//                })
//                .distinctUntilChanged()
//                .switchMap()
}
