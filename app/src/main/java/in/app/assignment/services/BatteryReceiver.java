package in.app.assignment.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import in.app.assignment.models.Battery;

/**
 * Created by Papercrane on 15-02-2018.
 */

public class BatteryReceiver extends BroadcastReceiver {

    public static final int REQUEST_CODE1 = 12345;
    public static final String LEVEL = "level";

    public BatteryReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
        int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, 1);
        Battery batteryService = new Battery();
        batteryService.batteryLevel = level;
        batteryService.save();
        Intent i = new Intent(context, BatteryService.class);
//        i.putExtra("battery", "battery");
        i.putExtra(LEVEL, level);
        context.startService(i);


    }

    private void sendMessageToActivity(String percentage, Context context) {
        Intent intent = new Intent("BatteryService");
        Bundle b = new Bundle();
        b.putString("Battery", percentage);
        intent.putExtra("Battery", b);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }
}
