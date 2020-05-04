package com.familyfolder.vaideeswaran.healthcare;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class FamilyMemberDetails extends AppCompatActivity {

    int n=0;
    int n1=0;
    String num1;
    String pin1;
    String pin2;
    String empno;
    String empno1;
    String empno2;
    SQLiteDatabase db = null;
    String name;
    String str1;
    String str2;
    String str3;
    String str4;
    String str5;
    String str6;
    String str7;
    String str8;
    String str9;
    String str10;
    String str11;
    String str12;
    String str13;
    String str14;
    String str15;
    String str16;
    String str17;
    String str18;
    String str19;
    String bmi2;
    Button bn;
    Button bn1;
    EditText et;
    EditText et1;
    EditText et2;
    EditText et3;
    EditText et4;
    EditText et5;
    EditText et6;
    EditText et7;
    EditText et8;
    EditText et9;
    EditText et10;
    EditText et11;
    EditText et12;
    EditText et13;
    EditText et19;

    Spinner spinner;
    Spinner spinner4;
    Spinner spinner2;
    Spinner spinner3;
    Spinner spinner5;

    String num;
    String ffno;

    String fld;
    int si=1;
    String fld1;

    ArrayAdapter<CharSequence> adapter1;
    ArrayAdapter<CharSequence> adapter2;
    ArrayAdapter<CharSequence> adapter3;
    ArrayAdapter<CharSequence> adapter4;
    ArrayAdapter<CharSequence> adapter5;

    JSONParser jsonParser = new JSONParser();
    String url = "http://192.168.43.234/run/register.php";


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.familymemberdetails);
        Bundle extras = getIntent().getExtras();

        num = extras.getString("number");
        pin1=extras.getString("pin");
        empno1=extras.getString("empno");
        fld=extras.getString("fld");
       // et2.setText();
        n = Integer.parseInt(num);
        fld1=fld;
        pin2=pin1;
        empno2=empno1;
        num1=num;
        //   n1 = Integer.parseInt(num);

        bn = (Button) findViewById(R.id.button2);
        bn1= (Button) findViewById(R.id.button3);
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner3 = (Spinner) findViewById(R.id.spinner3);
        spinner4 = (Spinner) findViewById(R.id.spinner4);
        spinner5= (Spinner) findViewById(R.id.spinner5);

        et = (EditText) findViewById(R.id.editText);
        et2 = (EditText) findViewById(R.id.editText2);
        et3 = (EditText) findViewById(R.id.editText3);

        et3.setText(si+"");
        et4 = (EditText) findViewById(R.id.editText4);
        et5 = (EditText) findViewById(R.id.editText5);
        et6 = (EditText) findViewById(R.id.editText6);
        et7 = (EditText) findViewById(R.id.editText7);
        et8 = (EditText) findViewById(R.id.editText8);
        et9 = (EditText) findViewById(R.id.editText9);
        et10 = (EditText) findViewById(R.id.editText10);
        et11 = (EditText) findViewById(R.id.editText11);
        et12 = (EditText) findViewById(R.id.editText12);
        et13 = (EditText) findViewById(R.id.editText13);
        et19 = (EditText) findViewById(R.id.editText19);
        // et19 = (EditText) findViewById(R.id.editText2);


        //et.setText(num);
        et2.setText(fld1);



        adapter1 = ArrayAdapter.createFromResource(this, R.array.gender, R.layout.support_simple_spinner_dropdown_item);
        adapter1.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter1);
        adapter2 = ArrayAdapter.createFromResource(this, R.array.marital_status, R.layout.support_simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        adapter3 = ArrayAdapter.createFromResource(this, R.array.smoking, R.layout.support_simple_spinner_dropdown_item);
        adapter3.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);
        adapter4 = ArrayAdapter.createFromResource(this, R.array.alcohol, R.layout.support_simple_spinner_dropdown_item);
        adapter4.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner4.setAdapter(adapter4);
        adapter5 = ArrayAdapter.createFromResource(this, R.array.occupation, R.layout.support_simple_spinner_dropdown_item);
        adapter5.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner5.setAdapter(adapter5);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                str15 = spinner.getSelectedItem().toString();
                //   Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + "selected abc", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                str16 = spinner2.getSelectedItem().toString();
                //Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + "selected", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                str17 = spinner3.getSelectedItem().toString();
                //Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + "selected", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                str18 = spinner4.getSelectedItem().toString();
                // Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + "selected", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                str19 = spinner5.getSelectedItem().toString();
                // Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + "selected", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
        bn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                str9 = et9.getText().toString();
                str8 = et8.getText().toString();
                float ht = Float.parseFloat(str9);
                float htd = ht / 100;
                float wt = Float.parseFloat(str8);
                float htm = htd * htd;
                float bmi1 = wt / htm;
                String bmi2 = Float.toString(bmi1);
                et10.setText(bmi2);
                et2.setText(pin2);
            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);




        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (n > 0) {
                    et3.setText(si+"");
                    //str1 = et.getText().toString();
                    str2 = et2.getText().toString();
                    str3 = et3.getText().toString();
                    str4 = et4.getText().toString();
                    str5 = et5.getText().toString();
                    str6 = et6.getText().toString();
                    str7 = et7.getText().toString();
                    str8 = et8.getText().toString();
                    str9 = et9.getText().toString();
                    str10 = bmi2;
                    str11 = et11.getText().toString();
                    str12 = et12.getText().toString();
                    str13 = et13.getText().toString();
                    str14 = et19.getText().toString();
                    si++;
                  /*  if (n == n1) {
                        name = str4;
                    }*/
                    if (n == 1) {
                        et3.setText("");
                        et2.setText("");

                        bn.setText("Generate UID");
                    }
                    else
                    {
                        et3.setText(si+"");
                        et2.setText(fld1);
                    }


                    try {
                        db = openOrCreateDatabase("pendrive1", MODE_PRIVATE, null);
                        db.execSQL("CREATE TABLE IF NOT EXISTS data2 (ffno VARCHAR,sino VARCHAR,name VARCHAR,relationtohead VARCHAR,dob VARCHAR,occupation VARCHAR,gender VARCHAR,maritalstatus VARCHAR,education VARCHAR,wt VARCHAR,hght VARCHAR,bmi VARCHAR,sysbp VARCHAR,diastbp VARCHAR,chronicill VARCHAR,smoking VARCHAR,alcohol VARCHAR,aadhar VARCHAR);");
                        db.execSQL("INSERT INTO data2 values ('" + str2 + "','" + str3 + "','" + str4 + "','" + str5 + "','" + str6 + "','" + str19 + "','" + str15 + "','" + str16 + "','" + str7 + "','" + str8 + "','" + str9 + "','" + str10 + "','" + str11 + "','" + str12 + "','" + str13 + "','" + str17 + "','" + str18 + "','" + str14 + "');");
                        Toast.makeText(getApplicationContext(), "Saved Sucessfully", Toast.LENGTH_LONG).show();
                        //  new loginAccess().execute();
                    } catch (SQLiteException se) {
                        Toast.makeText(getApplicationContext(), "not Saved Sucessfully", Toast.LENGTH_LONG).show();
                    }
                    n--;

                    et4.setText("");
                    et5.setText("");
                    et6.setText("");
                    et7.setText("");
                    et8.setText("");
                    et9.setText("");
                    et10.setText("");
                    et11.setText("");
                    et12.setText("");
                    et13.setText("");
                    et19.setText("");


                } else {
                    // String uid1=name.substring(0,3);
                    Intent intent = new Intent(FamilyMemberDetails.this, Uid.class);
                    intent.putExtra("pin2", pin2);
                    intent.putExtra("empno2", empno2);
                    intent.putExtra("num1", num1);
                    intent.putExtra("fld", fld);

                    startActivity(intent);
                }


            }

        });

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);



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


}


