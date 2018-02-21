package in.app.assignment.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.util.Log;

/**
 * Created by Papercrane on 16-02-2018.
 */

public class MemoryReceiver extends BroadcastReceiver {
    public static final int REQUEST_CODE3 = 12345;

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i = new Intent(context, MemoryService.class);
        i.putExtra("memory", "memory");
        context.startService(i);

    }
}
