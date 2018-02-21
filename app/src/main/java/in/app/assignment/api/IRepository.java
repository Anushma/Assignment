package in.app.assignment.api;

import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.List;

import in.app.assignment.api.Api;
import in.app.assignment.api.Repository;
import in.app.assignment.apimodels.Currently;
import in.app.assignment.apimodels.Weather;
import in.app.assignment.apimodels.WeatherList;
import io.reactivex.Observable;

/**
 * Created by Papercrane on 20-02-2018.
 */

public class IRepository  implements Repository{

    private Api api;


    public IRepository(Api api) {
        this.api = api;
    }


    @Override
    public Observable<Currently> getWeatherReport(String lat, String longi) {
        return api.getWeatherDetails(lat, longi)
                .map(weather -> weather.currently)
                .doOnNext(BaseModel::save);

    }
}
