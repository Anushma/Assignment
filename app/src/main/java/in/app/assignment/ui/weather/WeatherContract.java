package in.app.assignment.ui.weather;

import android.icu.util.Currency;
import android.support.v7.widget.LinearLayoutManager;

import java.util.List;

import in.app.assignment.apimodels.Currently;
import in.app.assignment.apimodels.WeatherList;
import in.app.assignment.models.base.BaseView;

/**
 * Created by Papercrane on 20-02-2018.
 */

public interface WeatherContract {


    interface Presenter {

        void getWeather(String lat, String longi);
    }

    interface View extends BaseView {

        void show(Currently currently);

        void onError();

    }

}