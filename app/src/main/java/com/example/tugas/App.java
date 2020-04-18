package com.example.tugas;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class App extends Application {

    public static final String hidup = "WiFi di Aktifkan";
    public static final String mati = "WiFi di Nonaktifkan";

    @Override
    public void onCreate() {
        super.onCreate();
        createNotification();
    }

    private void createNotification() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel wifiOn = new NotificationChannel(
                    hidup,
                    "WiFi di Aktifkan",
                    NotificationManager.IMPORTANCE_HIGH);
                    wifiOn.setDescription("WiFi di Aktifkan");

            NotificationChannel wifiOff = new NotificationChannel(
                    mati,
                    "WiFi di Nonaktifkan",
                    NotificationManager.IMPORTANCE_LOW);
                    wifiOff.setDescription("WiFi di Nonaktifkan");

            NotificationManager manager = getSystemService(NotificationManager.class);
            assert manager != null;
            manager.createNotificationChannel(wifiOn);
            manager.createNotificationChannel(wifiOff);
        }
    }
}
