package in.app.assignment.services;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import in.app.assignment.models.Device;

/**
 * Created by Papercrane on 15-02-2018.
 */

public class DeviceService extends IntentService {


    public DeviceService() {
        super("DeviceService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        String reqString = Build.VERSION.RELEASE + "  " + Build.MANUFACTURER
                + " " + Build.MODEL + " " + Build.VERSION.RELEASE
                + " " + Build.VERSION_CODES.class.getFields()[android.os.Build.VERSION.SDK_INT].getName();

        Device device = new Device();
        device.deviceName = reqString;
        device.osVersion = reqString;
        device.save();
        Toast.makeText(this, reqString, Toast.LENGTH_LONG).show();
        Log.d("string", reqString);
        Log.d("from db", device.deviceName);
    }
}
