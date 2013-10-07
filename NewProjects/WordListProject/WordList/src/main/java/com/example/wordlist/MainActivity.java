package com.example.wordlist;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Stack;

public class MainActivity extends Activity {

    Stack mystack = new Stack();
    ArrayList array = new ArrayList();

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
        String text = firstnum.getText().toString();

        TextView t = (TextView) findViewById(R.id.textView);

        if (text.length() == 0) {
            if (array.isEmpty()) {
                t.setText("Nothing in the stack!");
            } else {
                int randnum = (int) Math.random();
                firstnum.setText((String) array.get(randnum));
                array.remove(randnum);
            }
        }
        else
        {
            mystack.push(text);
            t.setText("Pushed to the Stack!");
            firstnum.setText("");
        }
    }
}
