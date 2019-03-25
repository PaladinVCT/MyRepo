package android.itacademy.by.dz5;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.itacademy.by.menu.R;
import android.net.wifi.WifiManager;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import static android.net.wifi.WifiManager.WIFI_STATE_DISABLED;
import static android.net.wifi.WifiManager.WIFI_STATE_ENABLED;

public class MyService extends Service {
    private BroadcastReceiver listenerOn;
    private BroadcastReceiver listenerOff;
    private LocalBroadcastManager localBroadcastManager;

    @Override
    public void onCreate() {
        Log.e("AAA", "CREATE");
        super.onCreate();

        WifiManager wifiManager =
                (WifiManager) this.getSystemService(Context.WIFI_SERVICE);
        if (wifiManager.getWifiState() == WIFI_STATE_ENABLED) {
            Log.e("AAA", "WiFi Enabled");
            Dz5Activity.imageView.setBackground(getDrawable(R.drawable.wifion));
        } else if (wifiManager.getWifiState() == WIFI_STATE_DISABLED) {
            Log.e("AAA", "WiFi Disabled");
            Dz5Activity.imageView.setBackground(getDrawable(R.drawable.wifioff));
        }

        listenerOn = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Dz5Activity.imageView.setBackground(getDrawable(R.drawable.wifion));
            }
        };
        listenerOff = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Dz5Activity.imageView.setBackground(getDrawable(R.drawable.wifioff));
            }
        };
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        IntentFilter myFilterOn = new IntentFilter("WIFI_IS_ENABLED_NOW");
        IntentFilter myFilterOff = new IntentFilter("WIFI_IS_DISABLED_NOW");
        localBroadcastManager.registerReceiver(listenerOn,myFilterOn);
        localBroadcastManager.registerReceiver(listenerOff,myFilterOff);
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
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        localBroadcastManager.unregisterReceiver(listenerOn);
        localBroadcastManager.unregisterReceiver(listenerOff);
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        Log.e("AAA", "REBIND");
        super.onRebind(intent);
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("AAA", "START");
        return super.onStartCommand(intent, flags, startId);

    }

}