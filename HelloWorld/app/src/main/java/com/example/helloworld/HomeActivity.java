package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;


public class HomeActivity extends AppCompatActivity {
    private Switch WifiSwi;
    private WifiManager WifiManager;
//    private WifiNotif wifiNotif;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        //kosong
        TabLayout tabLayout = findViewById(R.id.tabBar);
        @SuppressLint("WrongViewCast") TabItem tabFragmentsatu = findViewById(R.id.Fragment1);
        @SuppressLint("WrongViewCast") TabItem tabFragmentdua = findViewById(R.id.Fragment2);

        final ViewPager viewPager = findViewById(R.id.viewPager);
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(),
                tabLayout.getTabCount());


        viewPager.setAdapter(pagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
//
//        WifiSwi = findViewById(R.id.switchwifi);
//        wifiNotif = new WifiNotif();
//        WifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
//        WifiSwi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    WifiManager.setWifiEnabled(true);
//                    WifiSwi.setText("Wifi ON");
//
//                }else {
//                    WifiManager.setWifiEnabled(false);
//                    WifiSwi.setText("Wifi OFF");
//                }
//            }
//        });
//        inisialisasiBroadcastRec();

    }

//
//        protected void onStart(){
//        super.onStart();
//            IntentFilter intentFilter = new IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION);
//            registerReceiver(WifiStateRec, intentFilter);
//        }
//
//        @Override
//        protected void onStop() {
//            super.onStop();
//            unregisterReceiver(WifiStateRec);
//        }

//    private BroadcastReceiver WifiStateRec = new BroadcastReceiver() {
//
//        @Override
//
//            public void onReceive(Context context, Intent intent) {
//                int extra = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, WifiManager.WIFI_STATE_UNKNOWN);
//
//                switch (extra){
//                    case android.net.wifi.WifiManager.WIFI_STATE_ENABLED:
//                        WifiSwi.setChecked(true);
//                        WifiSwi.setText("Wifi ON");
//                        //notif on
//                        wifiNotif.notifOn("Sudah terkoneksi", context);
//                        break;
//                    case android.net.wifi.WifiManager.WIFI_STATE_DISABLED:
//                        WifiSwi.setChecked(false);
//                        WifiSwi.setText("Wifi OFF");
//                        //notif off
//                        wifiNotif.notifOn("Tidak terkoneksi", context);
//                        break;
//                }
//

//            }
//        };


    private void inisialisasiBroadcastRec(){
        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        WifiSwi.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked && !wifiManager.isWifiEnabled()){
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    Intent panelIntent = new Intent(Settings.Panel.ACTION_WIFI);
                    startActivityForResult(panelIntent, 1);
                } else {
                    wifiManager.setWifiEnabled(true);
                }
            }

            else if(!isChecked && wifiManager.isWifiEnabled()){
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    Intent panelIntent = new Intent(Settings.Panel.ACTION_WIFI);
                    startActivityForResult(panelIntent, 1);
                } else {
                    wifiManager.setWifiEnabled(false);
                }
            }
        });
    }
}