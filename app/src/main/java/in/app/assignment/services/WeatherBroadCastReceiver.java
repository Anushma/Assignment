package in.app.assignment.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;

import in.app.assignment.ui.weather.WeatherActivity;

/**
 * Created by Papercrane on 20-02-2018.
 */

public class WeatherBroadCastReceiver extends BroadcastReceiver {

    public static final int REQUEST_CODE5 = 12345;

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i = new Intent(context, WeatherBroadCastService.class);
        context.startService(i);

        sendMessageToActivity(context);

    }

    private void sendMessageToActivity(Context context) {

        Intent intent = new Intent("WeatherReport");
        Bundle b = new Bundle();
        b.putString("Weather", "Weather");
        intent.putExtra("Weather", b);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);


    }
}
