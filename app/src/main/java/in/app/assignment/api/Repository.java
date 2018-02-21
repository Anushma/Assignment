package in.app.assignment.api;

import java.util.List;

import in.app.assignment.apimodels.Currently;
import in.app.assignment.apimodels.Weather;
import in.app.assignment.apimodels.WeatherList;
import io.reactivex.Observable;

/**
 * Created by Papercrane on 20-02-2018.
 */

public interface Repository {

    Observable<Currently> getWeatherReport(String lat, String longi);
}
