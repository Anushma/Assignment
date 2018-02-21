package in.app.assignment.ui.weather;

import android.util.Log;

import javax.inject.Inject;

import in.app.assignment.api.IRepository;
import in.app.assignment.api.Repository;
import in.app.assignment.models.base.BasePresenter;
import io.reactivex.android.schedulers.AndroidSchedulers;


/**
 * Created by Papercrane on 20-02-2018.
 */
@WeatheScope
class WaeatherPresenter extends BasePresenter<WeatherContract.View> implements WeatherContract.Presenter {

    private static final String TAG = "WeatherPresenter";

    private Repository mArticleRepository;

    @Inject
    WaeatherPresenter(Repository articlesPresenter) {
        mArticleRepository = articlesPresenter;
    }



    @Override
    public void getWeather(String lat, String longi) {
        mArticleRepository.getWeatherReport(lat, longi)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(weatherLists -> getView().show(weatherLists),
                        throwable -> {
                            Log.e(TAG, "getWeather: ", throwable);
                            getView().onError();
                        });
    }
}
