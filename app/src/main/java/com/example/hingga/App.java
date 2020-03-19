package com.example.hingga;

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
            NotificationChannel nyala = new NotificationChannel(
                    hidup,
                    "WiFi di Aktifkan",
                    NotificationManager.IMPORTANCE_HIGH);
                    nyala.setDescription("WiFi di Aktifkan");

            NotificationChannel nyali = new NotificationChannel(
                    mati,
                    "WiFi di Nonaktifkan",
                    NotificationManager.IMPORTANCE_HIGH);
            nyali.setDescription("WiFi di Nonaktifkan");

            NotificationManager manager = getSystemService(NotificationManager.class);
            assert manager != null;
            manager.createNotificationChannel(nyala);
            manager.createNotificationChannel(nyali);
        }
    }
}
