package com.rnvega.RCTModule;

import com.rnvega.R;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import androidx.annotation.NonNull;
import android.app.NotificationManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.content.Context;
import android.os.Build;
import android.content.Intent;
import android.app.PendingIntent;
import androidx.core.app.NotificationCompat;
import android.graphics.BitmapFactory;
import android.graphics.Color;

public class NotificationModule extends ReactContextBaseJavaModule  {
    private static ReactApplicationContext reactContext;
    private NotificationManager manager;
    private Notification notification;

    public NotificationModule(ReactApplicationContext context) {
        super(context);
        reactContext = context;
    }

    @Override
    public String getName() {
        return "VegaNotificationModule";
    }

    @ReactMethod
    public void init() {
        manager = (NotificationManager) getCurrentActivity().getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("RCT", "notification", NotificationManager.IMPORTANCE_HIGH);
            manager.createNotificationChannel(channel);
        }
    }

    @ReactMethod
    public void send(String title, String context, Integer channelId) {
        Intent intent = new Intent(getCurrentActivity(), NotificationActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(getCurrentActivity(), 0, intent, PendingIntent.FLAG_IMMUTABLE);

        notification = new NotificationCompat.Builder(getCurrentActivity(), "RCT")
                .setContentTitle(title)
                .setContentText(context)
                .setSmallIcon(R.drawable.ic_notifications)
                .setColor(Color.parseColor("#000000"))
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .build();

        manager.notify(channelId, notification);
    }

    @ReactMethod
    public void cancel(Integer channelId) {
        manager.cancel(channelId);
    }

    @ReactMethod
    public void cancelAll() {
        manager.cancelAll();
    }
}