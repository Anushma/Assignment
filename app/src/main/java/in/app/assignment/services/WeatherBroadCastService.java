package in.app.assignment.services;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

import in.app.assignment.ui.weather.WeatherActivity;

/**
 * Created by Papercrane on 20-02-2018.
 */

public class WeatherBroadCastService extends IntentService {
    public WeatherBroadCastService() {
        super("weather");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        assert intent != null;
        WeatherActivity.start(this);

    }
}
