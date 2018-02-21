package in.app.assignment.services;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.Nullable;
import android.util.Log;

import in.app.assignment.models.NetworkType;

/**
 * Created by Papercrane on 16-02-2018.
 */

public class NetworkTypeService extends IntentService {

    public static final String DEBUG_TAG = "debug";

    public NetworkTypeService() {
        super("NetworkType");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        assert connMgr != null;
        NetworkInfo networkInfo = connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        boolean isWifiConn = networkInfo.isConnected();
        networkInfo = connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        boolean isMobileConn = networkInfo.isConnected();
        NetworkType networkType = new NetworkType();
        if (isWifiConn){
            networkType.wifi = true;
        }

        else {
            networkType.mobileData = true;
        }

        networkType.save();
        Log.d(DEBUG_TAG, "Wifi connected: " + isWifiConn);
        Log.d(DEBUG_TAG, "Mobile connected: " + isMobileConn);

    }
}
