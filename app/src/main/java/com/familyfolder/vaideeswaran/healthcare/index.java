package com.familyfolder.vaideeswaran.healthcare;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewAnimator;

public class index extends AppCompatActivity {
    ImageView v1;
    ImageView v2;
    ImageView v3;
    ImageView v4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        v1= (ImageView) findViewById(R.id.imageView);
        v2= (ImageView) findViewById(R.id.imageView2);
        v3= (ImageView) findViewById(R.id.imageView3);
        v4= (ImageView) findViewById(R.id.imageView4);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       // TextView tv = (TextView) findViewById(R.id.textView14);
        //Typeface custom_font = Typeface.createFromAsset(getAssets(),  "font/Bradley.ttf");

        //tv.setTypeface(custom_font);
       TextView tv = (TextView) findViewById(R.id.textView14);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "font/Bradley.ttf");

        tv.setTypeface(custom_font);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
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
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void report(View view) {
        ConnectivityManager connec =
                (ConnectivityManager) getSystemService(getBaseContext().CONNECTIVITY_SERVICE);

        // Check for network connections
        if (connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.CONNECTED ||
                connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTED) {

            // if connected with internet

            Intent i = new Intent(getApplicationContext(), Report_location1.class);
            startActivity(i);


        } else if (
                connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.DISCONNECTED ||
                        connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.DISCONNECTED) {

            Toast.makeText(this, "Check internet connection", Toast.LENGTH_LONG).show();


            // return false;
        }

    }
    public void survey(View view) {
        Intent i = new Intent(getApplicationContext(),FamilyDetails.class);
        startActivity(i);
    }
    public  void contact(View view)
    {
        Intent out = new Intent();
        out.setAction(Intent.ACTION_DIAL);
        out.setData(Uri.parse("tel:" + Uri.encode("+919688566646")));
        startActivity(out);

    }

    public void chart(View view) {
        ConnectivityManager connec =
                (ConnectivityManager) getSystemService(getBaseContext().CONNECTIVITY_SERVICE);

        // Check for network connections
        if (connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.CONNECTED ||
                connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTED) {

            // if connected with internet

            Intent i = new Intent(getApplicationContext(), Chart_location1.class);
            startActivity(i);


        } else if (
                connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.DISCONNECTED ||
                        connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.DISCONNECTED) {

            Toast.makeText(this, "Check internet connection", Toast.LENGTH_LONG).show();


            // return false;
        }

    }
}
