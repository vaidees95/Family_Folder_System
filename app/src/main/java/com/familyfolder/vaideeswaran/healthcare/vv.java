package com.familyfolder.vaideeswaran.healthcare;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by VAIDEESWARAN on 14-04-2016.
 */
public class vv extends AppCompatActivity {
    TextView tv;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        tv = (TextView) findViewById(R.id.textView14);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "font/Bradley.ttf");

        tv.setTypeface(custom_font);

    }
}