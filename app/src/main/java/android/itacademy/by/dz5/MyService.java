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

public class MyService extends Service {
    private BroadcastReceiver globalReceiver;
    private Intent on = new Intent("WIFI_IS_ENABLED_NOW");
    private Intent off = new Intent("WIFI_IS_DISABLED_NOW");

    @Override
    public void onCreate() {
        globalReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                checkAndSendState();
            }
        };
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        registerReceiver(globalReceiver, new IntentFilter("android.net.wifi.WIFI_STATE_CHANGED"));
        registerReceiver(globalReceiver, new IntentFilter("android.net.wifi.STATE_CHANGE"));
        return new MyBinder();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        unregisterReceiver(globalReceiver);
        return super.onUnbind(intent);
    }

    public void checkAndSendState() {
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);
        WifiManager wifiManager =
                (WifiManager) this.getSystemService(Context.WIFI_SERVICE);
        if (wifiManager.getWifiState() == WifiManager.WIFI_STATE_ENABLED) {
            localBroadcastManager.sendBroadcast(on);
        } else if (wifiManager.getWifiState() == WifiManager.WIFI_STATE_DISABLED) {
            localBroadcastManager.sendBroadcast(off);
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    class MyBinder extends Binder {
        public MyService getService() {
            return MyService.this;
        }
    }
}