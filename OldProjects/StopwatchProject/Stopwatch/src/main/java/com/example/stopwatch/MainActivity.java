package com.example.stopwatch;

import android.os.Bundle;
import android.app.Activity;
import android.os.SystemClock;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    Chronometer mChronometer;
    boolean started = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mChronometer = (Chronometer) findViewById(R.id.chronometer);

        // Set the initial value
        mChronometer.setText("00:00");

        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private void showElapsedTime() {
        long elapsedMillis = SystemClock.elapsedRealtime() - mChronometer.getBase();
        Toast.makeText(MainActivity.this, "Elapsed milliseconds: " + elapsedMillis,
                Toast.LENGTH_SHORT).show();
    }

    public void startStop(View v){
        if (!started)
        {
            started = true;
            start(v);
        }
        else
        {
            started = false;
            stop(v);
        }
    }

    public void start(View v) {
        int stoppedMilliseconds = 0;

        String chronoText = mChronometer.getText().toString();
        String array[] = chronoText.split(":");
        if (array.length == 2) {
            stoppedMilliseconds = Integer.parseInt(array[0]) * 60 * 1000
                    + Integer.parseInt(array[1]) * 1000;
        } else if (array.length == 3) {
            stoppedMilliseconds = Integer.parseInt(array[0]) * 60 * 60 * 1000
                    + Integer.parseInt(array[1]) * 60 * 1000
                    + Integer.parseInt(array[2]) * 1000;
        }

        mChronometer.setBase(SystemClock.elapsedRealtime() - stoppedMilliseconds);
        mChronometer.start();
    }

    public void stop(View v) {
        mChronometer.stop();
        showElapsedTime();
    }



    public void reset(View v) {
        mChronometer.setBase(SystemClock.elapsedRealtime());
        showElapsedTime();
    }

}
