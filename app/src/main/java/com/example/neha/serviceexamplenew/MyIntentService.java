package com.example.neha.serviceexamplenew;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;
import android.widget.Toast;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class MyIntentService extends IntentService {


    private Handler myHandler;

    public MyIntentService() {
        super("MyIntentService");
        myHandler = new Handler();
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
         long endTime = System.currentTimeMillis()+ 20*1000;
            while(System.currentTimeMillis() < endTime)
            {
                //display a Toast message
                myHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MyIntentService.this, "Running A Service", Toast.LENGTH_SHORT).show();
                    }
                });



                try {
                    Thread.sleep(2 * 1000);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }


        }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionFoo(String param1, String param2) {
        // TODO: Handle action Foo
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private void handleActionBaz(String param1, String param2) {
        // TODO: Handle action Baz
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
