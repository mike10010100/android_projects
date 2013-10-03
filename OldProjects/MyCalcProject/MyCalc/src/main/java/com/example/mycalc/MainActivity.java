package com.example.mycalc;

import android.content.Intent;
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

    public void evaluateNumber(View view) {
        EditText firstnum = (EditText) findViewById(R.id.num1);
        int number1 = Integer.parseInt(firstnum.getText().toString());
        EditText secondnum = (EditText) findViewById(R.id.num2);
        int number2 = Integer.parseInt(secondnum.getText().toString());

        int result = number1+number2;

        TextView t = (TextView) findViewById(R.id.result);
        t.setText(String.valueOf(result));
    }
}
