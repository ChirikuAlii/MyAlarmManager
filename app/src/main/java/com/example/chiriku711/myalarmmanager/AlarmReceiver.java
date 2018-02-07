package com.example.chiriku711.myalarmmanager;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v4.media.app.NotificationCompat;

/**
 * Created by chiriku711 on 2/7/18.
 */

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

    }

    public void setAlarmNotification (Context context , String Title , String Message , int notifId){
        NotificationManager notificationManagerCompat = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        android.support.v4.app.NotificationCompat.Builder builder = new android.support.v4.app.NotificationCompat.Builder(context,String.valueOf(notifId))
                .setSmallIcon(R.drawable.ic_alarm_black_24dp)
                .setContentTitle(Title)
                .setContentText(Message)
                .setColor(ContextCompat.getColor(context,android.R.color.transparent))
                .setVibrate(new long[]{1000,1000,1000,1000,1000})
                .setSound(alarmSound);
        notificationManagerCompat.notify(notifId,builder.build());
    }

}
