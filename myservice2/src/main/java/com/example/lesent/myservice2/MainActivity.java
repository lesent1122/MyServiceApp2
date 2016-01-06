package com.example.lesent.myservice2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import com.example.lesent.myserviceapp1.IMyAidlInterface1;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnStart;
    private Button btnStop;
    private Button btnBind;
    private Button btnUnBind;
    private Button btnSync;
    private EditText etInput;
    private Intent serveintent;
    private IMyAidlInterface1 mybinder = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etInput = (EditText) findViewById(R.id.text);
        btnStart = (Button) findViewById(R.id.button0);
        btnStop = (Button) findViewById(R.id.button1);
        btnBind = (Button) findViewById(R.id.button2);
        btnUnBind = (Button) findViewById(R.id.button3);
        btnSync = (Button) findViewById(R.id.button4);
        serveintent = new Intent();
        serveintent.setComponent(new ComponentName("com.example.lesent.myserviceapp1","com.example.lesent.myserviceapp1.MyService1"));
        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);
        btnBind.setOnClickListener(this);
        btnUnBind.setOnClickListener(this);
        btnSync.setOnClickListener(this);

    }
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mybinder = IMyAidlInterface1.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button0:
                startService(serveintent);
                break;
            case R.id.button1:
                stopService(serveintent);
                break;
            case R.id.button2:
                bindService(serveintent,connection, Context.BIND_AUTO_CREATE);
                break;
            case R.id.button3:
                unbindService(connection);
                break;
            case R.id.button4:
                if (mybinder != null) {
                    try {
                        mybinder.setData(etInput.getText().toString());
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
    }
}
