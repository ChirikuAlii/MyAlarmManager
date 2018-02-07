package com.example.chiriku711.myalarmmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;

/**
 * Created by chiriku711 on 2/7/18.
 */

public class AlarmPreference {

    private final String PREF_NAME = "AlarmPreference";
    private final String KEY_ONE_TIME_DATE = "oneTimeDate";
    private final String KEY_ONE_TIME_TIME = "oneTimeTime";
    private final  String KEY_ONE_TIME_MESSAGE = "oneTimeMEssage";
    private final String KEY_REPEAT_TIME = "repeatTime";
    private final String KEY_REPEAT_MESSAGE = "repeatMessage";



    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor editor;

    public AlarmPreference(Context context) {
        mSharedPreferences = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
    }


    public void setOneTimeDate(String date){
        editor.putString(KEY_ONE_TIME_DATE,date);
        editor.commit();
    }

    public String getOneTimeDate(){
        return mSharedPreferences.getString(KEY_ONE_TIME_DATE,null);
    }

    public String getOneTimeTime() {
        return mSharedPreferences.getString(KEY_ONE_TIME_TIME,null);
    }

    public void setOneTimeTime(String Time) {
        editor.putString(KEY_ONE_TIME_TIME,Time);
        editor.commit();
    }

    public String getRepeatTime() {
        return mSharedPreferences.getString(KEY_REPEAT_TIME,null);
    }

    public void setRepeatTime(String Time) {
        editor.putString(KEY_REPEAT_TIME,Time);
        editor.commit();
    }

    public String getOneTimeMessage() {
        return mSharedPreferences.getString(KEY_ONE_TIME_MESSAGE,null);
    }

    public void setOneTimeMessage(String Message) {
        editor.putString(KEY_ONE_TIME_MESSAGE,Message);
        editor.commit();
    }

    public String getRepeatMessage() {
        return mSharedPreferences.getString(KEY_REPEAT_MESSAGE,null);
    }

    public void setRepeatMessage(String Message) {
        editor.putString(KEY_REPEAT_MESSAGE,Message);
    }

    public  void clear(){
        editor.clear();
        editor.commit();
    }
}
