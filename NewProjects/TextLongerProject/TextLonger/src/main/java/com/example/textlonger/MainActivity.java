package com.example.textlonger;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void evalText(View view) {
        EditText firstnum = (EditText) findViewById(R.id.editText);
        int number1 = firstnum.getText().toString().length();
        EditText secondnum = (EditText) findViewById(R.id.editText2);
        int number2 = secondnum.getText().toString().length();

        if (number1>number2)
        {
            TextView t = (TextView) findViewById(R.id.textView);
            t.setText("String 1 is longer.");
        }
        else
        {
            TextView t = (TextView) findViewById(R.id.textView);
            t.setText("String 2 is longer.");
        }
    }
}
