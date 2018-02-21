package in.app.assignment.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Papercrane on 15-02-2018.
 */

public class DeviceReceiver extends BroadcastReceiver {

    public static final int REQUEST_CODE = 12345;
    public static final String ACTION = "com.codepath.example.servicesdemo.alarm";
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i = new Intent(context, DeviceService.class);
        i.putExtra("foo", "bar");
        context.startService(i);

    }
}
