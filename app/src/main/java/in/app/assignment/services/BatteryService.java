package in.app.assignment.services;

import android.app.IntentService;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import in.app.assignment.models.Battery;

/**
 * Created by Papercrane on 15-02-2018.
 */

public class BatteryService extends IntentService {

    public BatteryService() {
        super("Battery");
    }



    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        assert intent != null;
        int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
        int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, 1);

//        Battery batteryService = new Battery();
//        batteryService.batteryLevel = level;
//        batteryService.save();

    }






}
