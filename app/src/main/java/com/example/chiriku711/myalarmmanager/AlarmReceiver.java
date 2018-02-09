package com.example.chiriku711.myalarmmanager;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v4.media.app.NotificationCompat;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by chiriku711 on 2/7/18.
 */

public class AlarmReceiver extends BroadcastReceiver {

    public static final String TYPE_ONE_TIME = "OneTimeAlarm";
    public static final String TYPE_REPEATING = "RepeatingAlarm";
    public static final String EXTRA_MESSAGE = "message";
    public static final String EXTRA_TYPE = "type";
    private final int NOTIF_ID_ONETIME = 100;
    private final int NOTIF_ID_REPEATING = 101;



    @Override
    public void onReceive(Context context, Intent intent) {
        String type = intent.getStringExtra(EXTRA_TYPE);
        String message = intent.getStringExtra(EXTRA_MESSAGE);
        String title = type.equalsIgnoreCase(TYPE_ONE_TIME) ? "One Time Alarm" : "Repeating Alarm";
        int notifId = type.equalsIgnoreCase(TYPE_ONE_TIME) ? NOTIF_ID_ONETIME : NOTIF_ID_REPEATING;
        showAlarmNotification(context, title, message, notifId);
    }

    public void showAlarmNotification (Context context , String Title , String Message , Integer notifId){
        NotificationManager notificationManagerCompat = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);



        android.support.v4.app.NotificationCompat.Builder builder = (android.support.v4.app.NotificationCompat.Builder) new android.support.v4.app.NotificationCompat.Builder(context, notifId.toString())
                .setSmallIcon(R.drawable.ic_alarm_black_24dp)
                .setContentTitle(Title)
                .setContentText(Message)
                .setColor(ContextCompat.getColor(context,android.R.color.transparent))
                .setVibrate(new long[]{1000,1000,1000,1000,1000})
                .setSound(alarmSound);


        notificationManagerCompat.notify(notifId,builder.build());

        }

    public void setOneTimeAlarm(Context context,String type,String date,String time ,String message){

        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context,AlarmReceiver.class);
        intent.putExtra(EXTRA_MESSAGE,message);
        intent.putExtra(EXTRA_TYPE,type);
        String dateArray[] = date.split("-");
        String timeArray[] = time.split(":");

        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.YEAR,Integer.parseInt(dateArray[0]));
        calendar.set(Calendar.MONTH,Integer.parseInt(dateArray[1])-1);
        calendar.set(Calendar.DAY_OF_MONTH,Integer.parseInt(dateArray[2]));
        calendar.set(Calendar.HOUR_OF_DAY,Integer.parseInt(timeArray[0]));
        calendar.set(Calendar.MINUTE,Integer.parseInt(timeArray[1]));
        calendar.set(Calendar.SECOND,0);

        int requestCode = NOTIF_ID_ONETIME;
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context,requestCode,intent,0);
        alarmManager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pendingIntent);
        Toast.makeText(context, "One time alarm set up", Toast.LENGTH_SHORT).show();
    }
    public void cancelAlarm(Context context, String type){
        AlarmManager alarmManager = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, AlarmReceiver.class);
        int requestCode = type.equalsIgnoreCase(TYPE_ONE_TIME) ? NOTIF_ID_ONETIME : NOTIF_ID_REPEATING;
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, requestCode, intent, 0);
        alarmManager.cancel(pendingIntent);
    }

    public  void setRepeatTime(Context context , String type , String time , String message){
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context,AlarmReceiver.class);
        intent.putExtra(EXTRA_TYPE,type);
        intent.putExtra(EXTRA_MESSAGE,message);
        String timeArray[] = time.split(":");
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.HOUR_OF_DAY,Integer.parseInt(timeArray[0]));
        calendar.set(Calendar.MINUTE,Integer.parseInt(timeArray[1]));
        calendar.set(Calendar.SECOND, 0);
        int requestCode = NOTIF_ID_REPEATING;

        PendingIntent pendingIntent = PendingIntent.getBroadcast(context,requestCode,intent,0);
        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent);

        Toast.makeText(context, "Repeating alarm set up", Toast.LENGTH_SHORT).show();
    }

}
