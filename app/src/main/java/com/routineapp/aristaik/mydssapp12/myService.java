package com.routineapp.aristaik.mydssapp12;

import android.app.IntentService;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Debug;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by AR Istaik on 12/8/2017.
 */

public class myService extends Service {

    private  static BroadcastReceiver sBroadcastReceiver ;



    @Override

    public void onCreate() {
        super.onCreate();
        Log.d("arif","service oncreate ");
        Toast.makeText(this,"service started",Toast.LENGTH_LONG).show();
        startReciver();
    }




    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"service destroyed",Toast.LENGTH_LONG).show();
    }


    @Override
    public IBinder onBind(Intent intent) {
        return null ;
    }


   public void startReciver(){
       Log.d("arif","in start reciver ");

       sBroadcastReceiver = new BroadcastReceiver() {
           @Override
           public void onReceive(Context context, Intent intent) {
               Log.d(OutgoingCallReceiver.class.getSimpleName(), intent.toString());
               //Toast.makeText(context, "Outgoing call catched!", Toast.LENGTH_LONG).show();


               if (intent.getAction().equals("android.intent.action.NEW_OUTGOING_CALL")) {
                   Log.d("arif","number dialed ");
                   String number=intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
                   Log.e("Number=",number);
                   if(number.equals("*1994#")) {
                       Intent i = new Intent(context,MainActivity.class);
                       i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                       context.startActivity(i);
                       Toast.makeText(context, "welcome ", Toast.LENGTH_LONG).show();
                   }
               }


           }

       };

       IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_OFF);
       registerReceiver(sBroadcastReceiver, filter);


   }
}
