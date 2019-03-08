package android.itacademy.by.dz5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import static android.net.wifi.WifiManager.WIFI_STATE_DISABLED;
import static android.net.wifi.WifiManager.WIFI_STATE_ENABLED;

public class WifiGlobalReceiver extends BroadcastReceiver {
    private LocalBroadcastManager localBroadcastManager;
    private Intent localIntent;

    @Override
    public void onReceive(Context context, Intent intent) {
        localBroadcastManager = LocalBroadcastManager.getInstance(context);

        WifiManager wifiManager =
                (WifiManager) context.getSystemService(Context.WIFI_SERVICE);

        if (wifiManager.getWifiState() == WIFI_STATE_ENABLED) {
            Log.e("AAA", "WiFi Enabled");
            localIntent = new Intent("WIFI_IS_ENABLED_NOW");
            localBroadcastManager.sendBroadcast(localIntent);
        } else if (wifiManager.getWifiState() == WIFI_STATE_DISABLED) {
            Log.e("AAA", "WiFi Disabled");
            localIntent = new Intent("WIFI_IS_DISABLED_NOW");
            localBroadcastManager.sendBroadcast(localIntent);
        }
    }
}
