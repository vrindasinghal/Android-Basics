package com.jitsinfo.backgroundservicereceiver;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

/**
 * Created by vrinda on 23-06-2017.
 */

public class MyAlarmService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.v("Cursor", "onBind");
        return null;
    }

    @Override
    public void onCreate() {
        Log.v("Cursor", "onCreate");

        super.onCreate();
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onStart(Intent intent, int startId) {
        Log.v("Cursor", "onStart");
        Notification();
        super.onStart(intent, startId);
    }

    public void  Notification() {
        String strtitle = getString(R.string.notificationtitle);
        // Set Notification Text
        String strtext = getString(R.string.notificationtext);

        // Open NotificationView Class on Notification Click
        Intent intent = new Intent(this, NotificationView.class);
        // Send data to NotificationView Class
        intent.putExtra("title", strtitle);
        intent.putExtra("text", strtext);
        // Open NotificationView.java Activity
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        //Create Notification using NotificationCompat.Builder
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setContentTitle(getString(R.string.notificationtitle))
                // Set Text
                .setContentText(getString(R.string.notificationtext))
                // Add an Action Button below Notification
                .addAction(R.mipmap.ic_launcher, "Action Button", pIntent)
                // Set PendingIntent into Notification
                .setContentIntent(pIntent)
                // Dismiss Notification
                .setAutoCancel(true);

        // Create Notification Manager
        NotificationManager notificationmanager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // Build Notification with Notification Manager
        notificationmanager.notify(0, builder.build());
    }
}
