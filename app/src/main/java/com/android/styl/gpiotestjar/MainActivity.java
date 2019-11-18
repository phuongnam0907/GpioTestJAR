package com.android.styl.gpiotestjar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.styl.GpioServiceManager;

public class MainActivity extends AppCompatActivity {

    static final boolean ACTIVE_HIGH = true;
    static final boolean ACTIVE_LOW = false;
    Button get_in_1;
    Button get_in_2;
    Button get_in_3;
    Button get_in_4;
    Button set_out_1_on;
    Button set_out_1_off;
    Button set_out_2_on;
    Button set_out_2_off;
    TextView view;

    private GpioServiceManager gpioService = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        get_in_1 = findViewById(R.id.getin1);
        get_in_2 = findViewById(R.id.getin2);
        get_in_3 = findViewById(R.id.getin3);
        get_in_4 = findViewById(R.id.getin4);

        set_out_1_on = findViewById(R.id.setout1on);
        set_out_1_off = findViewById(R.id.setout1off);
        set_out_2_on = findViewById(R.id.setout2on);
        set_out_2_off = findViewById(R.id.setout2off);

        view = findViewById(R.id.show);

        gpioService = new GpioServiceManager(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        get_in_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setText("Get IN_1 value: " + String.valueOf(gpioService.get_IN1()));
            }
        });

        get_in_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setText("Get IN_1 value: " + String.valueOf(gpioService.get_IN2()));
            }
        });

        get_in_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setText("Get IN_1 value: " + String.valueOf(gpioService.get_IN3()));
            }
        });

        get_in_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setText("Get IN_1 value: " + String.valueOf(gpioService.get_IN4()));
            }
        });

        set_out_1_on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gpioService.set_OUT1(ACTIVE_HIGH);
                view.setText("Set OUT_1 active HIGH");
            }
        });

        set_out_1_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gpioService.set_OUT1(ACTIVE_LOW);
                view.setText("Set OUT_1 active LOW");
            }
        });

        set_out_2_on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gpioService.set_OUT2(ACTIVE_HIGH);
                view.setText("Set OUT_2 active HIGH");
            }
        });

        set_out_2_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gpioService.set_OUT2(ACTIVE_LOW);
                view.setText("Set OUT_2 active LOW");
            }
        });
    }
}
