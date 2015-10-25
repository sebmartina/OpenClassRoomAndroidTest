package com.example.sebastien.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView text = null;
    private String hello = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /* Exercice sans Layout  */
        /*
        super.onCreate(savedInstanceState);

        hello = getResources().getString(R.string.hello_world);

        hello = hello.replace("world", "contry");

        TextView text = new TextView(this);
        text.setText(hello);

        setContentView(text);
        */

        /* Premier exercice avec Layout  */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
