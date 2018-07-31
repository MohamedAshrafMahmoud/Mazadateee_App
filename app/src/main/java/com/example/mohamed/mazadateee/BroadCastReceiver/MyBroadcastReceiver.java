package com.example.mohamed.mazadateee.BroadCastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.mohamed.mazadateee.Notifications.openMazad;

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        final openMazad notification = new openMazad();
        notification.notify(context, "", 0);





    }

}