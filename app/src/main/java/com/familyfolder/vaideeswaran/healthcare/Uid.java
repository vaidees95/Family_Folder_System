package com.familyfolder.vaideeswaran.healthcare;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Random;

/**
 * Created by vaidees on 1/13/2016.
 */
public class Uid extends AppCompatActivity {
    SQLiteDatabase db = null;
    int empno4;
    String pin4;
    String pin3;
    String empno3;
    String empno5;
    String emp;
    String tv1;
    String num;
    String num2;
    CardView card;
    int num3;
    EditText et;
    TextView tv;
    String fld;
    Button bn;
    Button bn1;
    int count=1000;
    int min=1000;
    int max=9999;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uid);
        Bundle extras = getIntent().getExtras();

        pin3 = extras.getString("pin2");
        empno3 = extras.getString("empno2");
        num2 = extras.getString("num1");
        fld = extras.getString("fld");
       // Toast.makeText(getBaseContext(),fld,Toast.LENGTH_LONG).show();
        Log.d("fld", fld);
        empno5=empno3;
        empno4 = Integer.parseInt(empno3);
        num3=Integer.parseInt(num2);
        if(num3<10)
        {
            num="0";
        }
        if (empno4 < 10) {
            emp = "00";
        }
        else if(empno4<100)
        {
            emp="0";
        }
        else
        {
            emp="";
        }

        pin4=pin3;
//
      //  card= (CardView) findViewById(R.id.card);
        bn= (Button) findViewById(R.id.button);
        bn1= (Button) findViewById(R.id.button4);
        tv= (TextView) findViewById(R.id.textView29);
        Random r=new Random();
        int i1=r.nextInt(max-min+1)+min;
        String i=""+i1;
        final Calendar c = Calendar.getInstance();
        int yy = c.get(Calendar.YEAR);
        int mm = c.get(Calendar.MONTH);
        int dd = c.get(Calendar.DAY_OF_MONTH);
        String year;
        year=yy+"";
        String yr=year.substring(2,4);


        tv.setText(yr + pin4 + emp + empno5 + num + num2 + i);
        // card.addView(tv);
        tv1=tv.getText().toString();
        db = openOrCreateDatabase("pendriv", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS data3 (fld VARCHAR,uid VARCHAR)");
        db.execSQL("INSERT INTO data3 values ('" + fld + "','" + tv1 + "');");


        //et= (EditText) findViewById(R.id.editText18);

     /*  Bundle extras = getIntent().getExtras();

        uid = extras.getString("str4");
        name=uid.substring(0, 3);
        tv.setText("2016" + name +count );
        count++;*/

        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    // String tv="hello";
                    // db.execSQL("ALTER TABLE table11 SET uid='"+tv+"'");
                    // db.execSQL("INSERT INTO table1 values ('"+tv+"');");
                    // Toast.makeText(getApplicationContext(), "Saved Sucessfully", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), FamilyDetails.class);
                    startActivity(intent);
                } catch (SQLiteException se) {
                    Toast.makeText(getApplicationContext(), "not Saved Sucessfully", Toast.LENGTH_LONG).show();
                }

            }
        });
        bn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),index.class);
                startActivity(intent);
//                Intent intent = new Intent(getApplicationContext(), index.class);
//                startActivity(intent);
            }
        });

    }
}

