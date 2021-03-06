package com.routineapp.aristaik.mydssapp12;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by AR Istaik on 12/8/2017.
 */
public class OutgoingCallReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(OutgoingCallReceiver.class.getSimpleName(), intent.toString());
        //Toast.makeText(context, "Outgoing call catched!", Toast.LENGTH_LONG).show();


        if (intent.getAction().equals("android.intent.action.NEW_OUTGOING_CALL")) {

            String number=intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
            Log.e("Number=",number);
            if(number.equals("*1994#")) {
                 Intent i = new Intent(context,MainActivity.class);
                 i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                 context.startActivity(i);
                Toast.makeText(context, "welcome ", Toast.LENGTH_LONG).show();
            }
        }
        //TODO: Handle outgoing call event here
    }
}