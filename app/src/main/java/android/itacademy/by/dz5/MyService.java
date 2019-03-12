package android.itacademy.by.dz5;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

public class MyService extends Service {
    private BroadcastReceiver globalReceiver;
    private Intent on = new Intent("WIFI_IS_ENABLED_NOW");
    private Intent off = new Intent("WIFI_IS_DISABLED_NOW");

    @Override
    public void onCreate() {
        Log.e("AAA", "CREATE");
        super.onCreate();
        checkAndSendState();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        globalReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                checkAndSendState();
            }
        };
        registerReceiver(globalReceiver, new IntentFilter("android.net.wifi.WIFI_STATE_CHANGED"));
        registerReceiver(globalReceiver, new IntentFilter("android.net.wifi.STATE_CHANGE"));

        Log.e("AAA", "BIND");
        return new Binder();
    }

    @Override
    public void onDestroy() {
        Log.e("AAA", "DESTROY");
        super.onDestroy();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("AAA", "UNBIND");
        unregisterReceiver(globalReceiver);
        return super.onUnbind(intent);
    }

    public void checkAndSendState() {
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);
        WifiManager wifiManager =
                (WifiManager) this.getSystemService(Context.WIFI_SERVICE);
        if (wifiManager.getWifiState() == WifiManager.WIFI_STATE_ENABLED) {
            Log.e("AAA", "WiFi Enabled");
            localBroadcastManager.sendBroadcast(on);
        } else if (wifiManager.getWifiState() == WifiManager.WIFI_STATE_DISABLED) {
            Log.e("AAA", "WiFi Disabled");
            localBroadcastManager.sendBroadcast(off);
        }
    }
}