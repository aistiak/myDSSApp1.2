package com.routineapp.aristaik.mydssapp12;

import android.app.IntentService;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button Startbutton ;
    private Button StopButton ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Startbutton =  (Button) findViewById(R.id.start_button);
        StopButton = (Button) findViewById(R.id.stop_button);
    }


    public void StartMethod(View v){

        Intent i = new Intent(this,myService.class);
        startService(i);
    }
    public void StopMethod(View v){
        Intent i = new Intent(this,myService.class);
        stopService(i);
    }
}
