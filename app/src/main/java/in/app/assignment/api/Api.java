package in.app.assignment.api;


import in.app.assignment.apimodels.Weather;

import in.app.assignment.apimodels.WeatherList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Papercrane on 17-02-2018.
 */

public interface Api {


    @GET( "/forecast/6c1f11fe8a63438cd821904f5ff872f4/{latitude},{longitude}")
    io.reactivex.Observable<Weather> getWeatherDetails(@Path("latitude") String latitude, @Path("longitude") String longitude);



}
