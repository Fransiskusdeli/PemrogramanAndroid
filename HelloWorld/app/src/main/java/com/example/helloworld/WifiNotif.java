//package com.example.helloworld;
//
//import android.app.NotificationChannel;
//import android.app.NotificationManager;
//import android.content.Context;
//import androidx.core.app.NotificationCompat;
//
//public class WifiNotif{
//
//    public void notifOn(String message, Context context){
//        String CHANNEL_ID = "NOTIF";
//        NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, "MY channel", NotificationManager.IMPORTANCE_HIGH);
//        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
//        notificationManager.createNotificationChannel(mChannel);
//        android.app.Notification notification = new NotificationCompat.Builder(context, CHANNEL_ID)
//                .setSmallIcon(R.drawable.checklist_notif)
//                .setContentTitle("WIFI")
//                .setContentText(message)
//                .build();
//        int notificationID = 101;
//        notificationManager.notify(notificationID, notification);
//    }
//}
//
