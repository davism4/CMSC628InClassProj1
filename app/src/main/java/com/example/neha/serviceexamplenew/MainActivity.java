package com.example.neha.serviceexamplenew;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements View.OnClickListener{

    Button myButtonSS, myButtonBS, myButtonComm;
    private MyService serviceobj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        myButtonSS = (Button)findViewById(R.id.buttonSS);
        myButtonBS = (Button)findViewById(R.id.buttonBS);
        myButtonComm = (Button) findViewById(R.id.buttonComm);

        myButtonBS.setOnClickListener(this);
        myButtonSS.setOnClickListener(this);
        myButtonComm.setOnClickListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.buttonSS:
                Intent myIntent = new Intent(this, MyIntentService.class);
                startService(myIntent);
                break;
            case R.id.buttonBS:
                Intent myIntent2 = new Intent(this, MyService.class);

                bindService(myIntent2,mConnection, Context.BIND_AUTO_CREATE);
                break;
            case R.id.buttonComm:
                String junkstring = serviceobj.sendJunk();
                Toast.makeText(this, "String: "+junkstring, Toast.LENGTH_LONG).show();
                break;

        }

    }


    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyService.myBinder binder = (MyService.myBinder) service;
            serviceobj = binder.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
}