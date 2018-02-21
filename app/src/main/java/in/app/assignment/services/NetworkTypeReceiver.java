package in.app.assignment.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Papercrane on 16-02-2018.
 */

public class NetworkTypeReceiver extends BroadcastReceiver {

    public static final int REQUEST_CODE2 = 12345;

    @Override
    public void onReceive(Context context, Intent intent) {

        Intent i = new Intent(context, NetworkTypeService.class);
        i.putExtra("network", "network");
        context.startService(i);

    }
}
