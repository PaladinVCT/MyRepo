package android.itacademy.by.dz5;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.itacademy.by.menu.R;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;

public class dz5Activity extends Activity implements View.OnClickListener {
    private ServiceConnection sConn;
    private Intent intent;
    public static ImageView imageView;
    private Button wifiBtnOn;
    private Button wifiBtnOff;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.services_layout);

        imageView = findViewById(R.id.wifiImageView);
        wifiBtnOn = findViewById(R.id.turnWifiBtnOn);
        wifiBtnOff = findViewById(R.id.turnWifiBtnOff);
        wifiBtnOn.setOnClickListener(this);
        wifiBtnOff.setOnClickListener(this);

        sConn = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                Log.e("AAA", "connected");
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                Log.e("AAA", "disconnected");
            }
        };
        intent = new Intent(this, MyService.class);
        intent.setPackage("android.itacademy.by");
        bindService(intent, sConn, BIND_AUTO_CREATE);
    }

    @Override
    protected void onPause() {
        unbindService(sConn);
        super.onPause();
        Log.e("AAA", "PAUSE");
    }

    @Override
    protected void onResume() {
        super.onResume();
        bindService(intent, sConn, BIND_AUTO_CREATE);
        Log.e("AAA", "RESUME");
    }

    @Override
    public void onClick(View v) {
        WifiManager wifiManager = (WifiManager) this.getSystemService(WIFI_SERVICE);

        switch (v.getId()) {
            case R.id.turnWifiBtnOn:
                wifiManager.setWifiEnabled(true);
                break;
            case R.id.turnWifiBtnOff:
                wifiManager.setWifiEnabled(false);
        }
    }
}
