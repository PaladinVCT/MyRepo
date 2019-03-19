package android.itacademy.by.dz5;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.itacademy.by.menu.R;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.widget.ImageView;

public class Dz5Activity extends Activity {
    private ServiceConnection sConn;
    private Intent intent;
    public static ImageView imageView;
    private Intent on = new Intent("WIFI_IS_ENABLED_NOW");
    private Intent off = new Intent("WIFI_IS_DISABLED_NOW");
    private BroadcastReceiver onReceiver;
    private BroadcastReceiver offReceiver;
    private MyService myService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.services_layout);

        imageView = findViewById(R.id.wifiImageView);


        sConn = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                myService = ((MyService.MyBinder) service).getService();
                myService.checkAndSendState();
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                Log.e("AAA", "disconnected");
            }
        };

        intent = new Intent(this, MyService.class);
        intent.setPackage("android.itacademy.by");

        bindService(intent, sConn, BIND_AUTO_CREATE);
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this);

        onReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Dz5Activity.imageView.setBackground(getDrawable(R.drawable.wifion));
            }
        };
        offReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Dz5Activity.imageView.setBackground(getDrawable(R.drawable.wifioff));
            }
        };

        localBroadcastManager.registerReceiver(onReceiver, new IntentFilter("WIFI_IS_ENABLED_NOW"));
        localBroadcastManager.registerReceiver(offReceiver, new IntentFilter("WIFI_IS_DISABLED_NOW"));
    }

    @Override
    protected void onPause() {
        unbindService(sConn);
        unregisterReceiver(onReceiver);
        unregisterReceiver(offReceiver);
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        bindService(intent, sConn, BIND_AUTO_CREATE);
        registerReceiver(onReceiver, new IntentFilter("WIFI_IS_ENABLED_NOW"));
        registerReceiver(offReceiver, new IntentFilter("WIFI_IS_DISABLED_NOW"));
    }
}