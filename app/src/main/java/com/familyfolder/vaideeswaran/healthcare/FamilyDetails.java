package com.familyfolder.vaideeswaran.healthcare;




import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

public class FamilyDetails extends AppCompatActivity {
    private Context context;
    private ProgressDialog pDialog;
    int flag=0;
    private static final String TAG_SUCCESS = "success";

    SQLiteDatabase db = null;

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
    String str20;
    String str21;
    String str22;
    String str23;
    String str24;
    String str25;
    String str26;
    String str27;
    String str28;
    String str29;
    String str30;
    String str31;
    String str32;
    String str33;
    String str34;




    Spinner spinner1;
    Spinner spinner2;
    Spinner spinner8;
    Spinner spinner9;
    Spinner spinner6;
    Spinner spinner7;
    Spinner spinner4;
    Spinner spinner5;
    Spinner spinner10;
    Spinner spinner20;
    Spinner spinner16;
    String yr;
    EditText et;
    EditText et2;
    EditText et3;
    EditText et4;
    EditText et5;

    EditText et7;
    EditText et8;
    EditText et9;
    EditText et17;
    EditText et22;
    EditText et10;
    EditText et11;
    EditText et12;
    EditText et13;
    EditText et14;
    EditText et15;
    EditText et16;
    EditText et19;


    CheckBox ch;
    CheckBox ch2;
    CheckBox ch3;
    CheckBox ch4;
    CheckBox ch5;
    CheckBox ch6;


    Button b2;


    ArrayAdapter<CharSequence> adapter1;
    ArrayAdapter<CharSequence> adapter2;
    ArrayAdapter<CharSequence> adapter8;
    ArrayAdapter<CharSequence> adapter9;
    ArrayAdapter<CharSequence> adapter6;
    ArrayAdapter<CharSequence> adapter7;
    ArrayAdapter<CharSequence> adapter4;
    ArrayAdapter<CharSequence> adapter5;
    ArrayAdapter<CharSequence>adapter10;
    ArrayList<String> my_array2 = new ArrayList<String>();
    ArrayList<String> my_array = new ArrayList<String>();

    EditText tx;
  //  EditText tx1;
  String lat1="", lon1="";


        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.familydetails);


try {

    String dist1 = "erode";
    String taluk11 = "erode";
    String taluk12 = "bhavani";
    String dist2 = "coimbatore";
    String taluk21 = "mettupalayam";
    String taluk22 = "annur";
    String dist3 = "karur";
    String taluk31="karur";
    String taluk32="kulithalai";
   String dist4="madurai";
    String taluk41="melur";
    String taluk42="vadipati";
    String dist5="cuddalore";
    String taluk51="cuddalore";
    String taluk52="chidambaram";


    db = openOrCreateDatabase("place3", MODE_PRIVATE, null);
  // db.execSQL("delete from place1");
    db.execSQL("CREATE TABLE IF NOT EXISTS place1 (dist VARCHAR,taluk VARCHAR)");
    db.execSQL("INSERT INTO place1 values ('" + dist1 + "','" + taluk11 + "')");
    db.execSQL("INSERT INTO place1 values ('" + dist1 + "','" + taluk12 + "')");
    db.execSQL("INSERT INTO place1 values ('" + dist2 + "','" + taluk21 + "')");
    db.execSQL("INSERT INTO place1 values ('" + dist2 + "','" + taluk22 + "')");
    db.execSQL("INSERT INTO place1 values ('" + dist3 + "','" + taluk31 + "')");
    db.execSQL("INSERT INTO place1 values ('" + dist3 + "','" + taluk32 + "')");
    db.execSQL("INSERT INTO place1 values ('" + dist4 + "','" + taluk41 + "')");
    db.execSQL("INSERT INTO place1 values ('" + dist4 + "','" + taluk42 + "')");
    db.execSQL("INSERT INTO place1 values ('" + dist5 + "','" + taluk51 + "')");
    db.execSQL("INSERT INTO place1 values ('" + dist5 + "','" + taluk52 + "')");




}catch (SQLiteException E)
{
    Toast.makeText(getApplicationContext(),"not successfull",Toast.LENGTH_LONG).show();
}

            tx= (EditText) findViewById(R.id.editText);
new loginAccess().execute();
       // tx1= (EditText) findViewById(R.id.editText15);
        this.context = this;
        Intent alarm = new Intent(this.context, AlarmReceiver.class);
        boolean alarmRunning = (PendingIntent.getBroadcast(this.context, 0, alarm, PendingIntent.FLAG_NO_CREATE) != null);
        if(alarmRunning == false) {
            PendingIntent pendingIntent = PendingIntent.getBroadcast(this.context, 0, alarm, 0);
            AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            alarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime(), 60000, pendingIntent);
        }





        LocationManager locationManager = (LocationManager) FamilyDetails.this.getSystemService(Context.LOCATION_SERVICE);
        // Define a listener that responds to location updates
        LocationListener locationListener = new LocationListener() {
            public void onLocationChanged(Location location) {
             //   String lat="", lon="";

                // Called when a new location is found by the network location provider.
                lat1 = Double.toString(location.getLatitude());
                lon1 = Double.toString(location.getLongitude());
                TextView tv = (TextView) findViewById(R.id.textView);
               //tv.setText("Your Location is:" + lat1 + "--" + lon1);
                et8.setText(lat1);
                et9.setText(lon1);
                String ss  = GetAddress(lat1, lon1);
                if(!ss.equals("No Location"))
                et7.setText(ss);
                pDialog.dismiss();


            }

            public void onStatusChanged(String provider, int status, Bundle extras) {}
            public void onProviderEnabled(String provider) {}
            public void onProviderDisabled(String provider) {}
        };
        // Register the listener with the Location Manager to receive location updates
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);





















        final Calendar c = Calendar.getInstance();
       int yy = c.get(Calendar.YEAR);
       int mm = c.get(Calendar.MONTH);
        int dd = c.get(Calendar.DAY_OF_MONTH);

        // set current date into textview
        spinner1= (Spinner) findViewById(R.id.spinner);
        spinner2= (Spinner) findViewById(R.id.spinner2);
        spinner8= (Spinner) findViewById(R.id.spinner8);
        spinner9= (Spinner) findViewById(R.id.spinner9);
        spinner6= (Spinner) findViewById(R.id.spinner6);
        spinner7= (Spinner) findViewById(R.id.spinner7);
        spinner4= (Spinner) findViewById(R.id.spinner4);
        spinner5= (Spinner) findViewById(R.id.spinner5);
        spinner10 = (Spinner) findViewById(R.id.spinner10);
            spinner20 = (Spinner) findViewById(R.id.spinner20);

            spinner16 = (Spinner) findViewById(R.id.spinner16);


            my_array = getTableValues();

            HashSet<String> taluk1,dist1;
            //   taluk1 = new HashSet<String>(taluk);
            // taluk.clear();
            //taluk.addAll(taluk1);
            //Collections.sort(taluk);
            dist1 = new HashSet<String>(my_array);
            my_array.clear();
            my_array.addAll(dist1);
            Collections.sort(my_array);


            et= (EditText) findViewById(R.id.editText);
        et2= (EditText) findViewById(R.id.editText2);
        et3= (EditText) findViewById(R.id.editText3);
        et4= (EditText) findViewById(R.id.editText4);
        et5= (EditText) findViewById(R.id.editText5);
       // et6= (EditText) findViewById(R.id.editText6);
        et7= (EditText) findViewById(R.id.editText7);
        et8= (EditText) findViewById(R.id.editText8);
      //  et8.setText("Your Location is:" + lat1 + "--" + lon1);
        et9= (EditText) findViewById(R.id.editText9);
      //  et9.setText(lon1);
        et17= (EditText) findViewById(R.id.editText17);
       // et22= (EditText) findViewById(R.id.editText22);
        et10= (EditText) findViewById(R.id.editText10);
        et11= (EditText) findViewById(R.id.editText11);
        et12= (EditText) findViewById(R.id.editText12);
        et13= (EditText) findViewById(R.id.editText13);
        et14= (EditText) findViewById(R.id.editText14);
        et15= (EditText) findViewById(R.id.editText15);
        et16= (EditText) findViewById(R.id.editText16);
        et19= (EditText) findViewById(R.id.editText19);
       // et20= (EditText) findViewById(R.id.editText20);
        ch= (CheckBox) findViewById(R.id.checkBox);
        ch2= (CheckBox) findViewById(R.id.checkBox2);
        ch3= (CheckBox) findViewById(R.id.checkBox3);
        ch4= (CheckBox) findViewById(R.id.checkBox4);
        ch5= (CheckBox) findViewById(R.id.checkBox5);
        ch6= (CheckBox) findViewById(R.id.checkBox6);
        b2= (Button) findViewById(R.id.button2);
        et15.setText(new StringBuilder()
                // Month is 0 based, just add 1
                .append(dd).append("-").append(mm + 1).append("-")
                .append(yy));
        et.setText(new StringBuilder()
                // Month is 0 based, just add 1
                .append(dd).append("-").append(mm + 1).append("-")
                .append(yy));



        adapter1=ArrayAdapter.createFromResource(this, R.array.Family_type, R.layout.support_simple_spinner_dropdown_item);
        adapter1.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

        adapter2=ArrayAdapter.createFromResource(this,R.array.religion,R.layout.support_simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        adapter8=ArrayAdapter.createFromResource(this,R.array.house,R.layout.support_simple_spinner_dropdown_item);
        adapter8.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner8.setAdapter(adapter8);

        adapter9=ArrayAdapter.createFromResource(this,R.array.house_type,R.layout.support_simple_spinner_dropdown_item);
        adapter9.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner9.setAdapter(adapter9);

        adapter6=ArrayAdapter.createFromResource(this,R.array.water_supply,R.layout.support_simple_spinner_dropdown_item);
        adapter6.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner6.setAdapter(adapter6);

        adapter7=ArrayAdapter.createFromResource(this,R.array.toilet,R.layout.support_simple_spinner_dropdown_item);
        adapter7.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner7.setAdapter(adapter7);

        adapter4=ArrayAdapter.createFromResource(this,R.array.family_planning,R.layout.support_simple_spinner_dropdown_item);
        adapter4.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner4.setAdapter(adapter4);

        adapter5=ArrayAdapter.createFromResource(this,R.array.under_5,R.layout.support_simple_spinner_dropdown_item);
        adapter5.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner5.setAdapter(adapter5);

        adapter10=ArrayAdapter.createFromResource(this,R.array.income,R.layout.support_simple_spinner_dropdown_item);
        adapter10.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner10.setAdapter(adapter10);
            ArrayAdapter my_Adapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item,my_array);
            my_Adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            spinner20.setAdapter(my_Adapter);

            spinner20.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    str34 = spinner20.getSelectedItem().toString();
                    Toast.makeText(getApplicationContext(),str34,Toast.LENGTH_LONG).show();
                    my_array2 = getTableValues2(str34);

                    ArrayAdapter my_Adapter2 = new ArrayAdapter(FamilyDetails.this, R.layout.support_simple_spinner_dropdown_item, my_array2);
                    my_Adapter2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                    spinner16.setAdapter(my_Adapter2);


                    //  Toast.makeText(getApplicationContext(),sp1.getSelectedItem().toString(),Toast.LENGTH_LONG).show();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });










            spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                str26 = spinner1.getSelectedItem().toString();
                //Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + "selected", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                str27 = spinner2.getSelectedItem().toString();
                //  Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + "selected", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                str28 = spinner8.getSelectedItem().toString();
                //Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + "selected", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                str29 = spinner9.getSelectedItem().toString();
                // Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + "selected", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                str30 = spinner6.getSelectedItem().toString();
                // Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + "selected", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                str31 = spinner7.getSelectedItem().toString();
                //  Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + "selected", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                str32 = spinner4.getSelectedItem().toString();
                //  Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + "selected", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                str33 = spinner5.getSelectedItem().toString();
                // Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + "selected", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });



        spinner10.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                str11 = spinner10.getSelectedItem().toString();
               //  Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + "selected", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //str1 = et.getText().toString();
                str1 = et.getText().toString();
                str2 = et2.getText().toString();
                str3 = et3.getText().toString();
                str4 = et4.getText().toString();
                str5 = et5.getText().toString();
                str6 = spinner16.getSelectedItem().toString();
               // str6 = et6.getText().toString();
                str7 = et7.getText().toString();
                str8 = et8.getText().toString();
                str9 = et9.getText().toString();
                str10 = et17.getText().toString();
              //  str11 = et22.getText().toString();
                str12 = et10.getText().toString();
                str13 = et11.getText().toString();
                str14 = et12.getText().toString();
                str15 = et13.getText().toString();
                str16 = et14.getText().toString();
                str17 = et15.getText().toString();
                str18 = et16.getText().toString();
                str19 = et19.getText().toString();

              //  str34=et20.getText().toString();
           //Toast.makeText(getApplicationContext(),str34,Toast.LENGTH_LONG).show();

                //checkbox1
                if (ch.isChecked()) {
                    str20 = "ÿes";
                } else {
                    str20 = "no";
                }
                //checbox2
                if (ch2.isChecked()) {
                    str21 = "ÿes";
                } else {
                    str21 = "no";
                }
                //checbox3
                if (ch3.isChecked()) {
                    str22 = "ÿes";
                } else {
                    str22 = "no";
                }
                //checbox4
                if (ch4.isChecked()) {
                    str23 = "ÿes";
                } else {
                    str23 = "no";
                }
                //checbox5
                if (ch5.isChecked()) {
                    str24 = "ÿes";
                } else {
                    str24 = "no";
                }
                //checbox6
                if (ch6.isChecked()) {
                    str25 = "ÿes";
                } else {
                    str25 = "no";
                }




                 if(str2.matches(""))
                {

                    et2.setError("invalide folder number");
                    Toast.makeText(FamilyDetails.this, "please fill required field", Toast.LENGTH_SHORT).show();

                }

                else if(str3.matches(""))
                {

                    et3.setError("invalide emplno");
                    Toast.makeText(FamilyDetails.this, "please fill required field", Toast.LENGTH_SHORT).show();
                }
               else if(str7.matches(""))
                {

                    et7.setError("invalide pincode");
                    Toast.makeText(FamilyDetails.this, "please fill required field", Toast.LENGTH_SHORT).show();

                }

                else if(str10.matches(""))
                {

                    et17.setError("invalide family member");
                    Toast.makeText(FamilyDetails.this, "please fill required field", Toast.LENGTH_SHORT).show();

                }

                else {

                    try {
                        db = openOrCreateDatabase("pendriv1", MODE_PRIVATE, null);
                        db.execSQL("CREATE TABLE IF NOT EXISTS data2 (dos VARCHAR,ffno VARCHAR,emplyno VARCHAR,drno VARCHAR,area VARCHAR,dist VARCHAR,taluk VARCHAR,pincode VARCHAR,lat VARCHAR,long1 VARCHAR,nooffmly VARCHAR,fmlyty VARCHAR,relgn VARCHAR,fmlyinc VARCHAR,house VARCHAR,housetyp VARCHAR,watersupply VARCHAR,toilet VARCHAR,infant VARCHAR,under5 VARCHAR,adolescent VARCHAR,antenatal VARCHAR,postnatal VARCHAR,geriatric VARCHAR,rice VARCHAR,wheat VARCHAR,sugar VARCHAR,salt VARCHAR,oil VARCHAR,fp VARCHAR,under5imun VARCHAR,rcrdcrtd VARCHAR,crtdby VARCHAR,site VARCHAR);");
                        db.execSQL("INSERT INTO data2 values ('" + str1 + "','" + str2 + "','" + str3 + "','" + str4 + "','" + str5 + "','" + str34 + "','" + str6 + "','" + str7 + "','" + str8 + "','" + str9 + "','" + str10 + "','" + str26 + "','" + str27 + "','" + str11 + "','" + str28 + "','" + str29 + "','" + str30 + "','" + str31 + "','" + str20 + "','" + str21 + "','" + str22 + "','" + str23 + "','" + str24 + "','" + str25 + "','" + str12 + "','" + str13 + "','" + str14 + "','" + str15 + "','" + str16 + "','" + str32 + "','" + str33 + "','" + str17 + "','" + str18 + "','" + str19 + "');");
                        //  db.execSQL("CREATE TABLE IF NOT EXISTS udhaya1431 (dos VARCHAR,ffno VARCHAR)");
                        // db.execSQL("INSERT INTO udhaya1431 values ('" + str1 + "','" + str2 + "')");
                        Toast.makeText(getApplicationContext(), "Saved Sucessfully", Toast.LENGTH_LONG).show();
                        // new loginAccess().execute();
                        Intent intent = new Intent(getApplicationContext(), FamilyMemberDetails.class);

                        intent.putExtra("pin", str7);
                        intent.putExtra("empno", str3);
                        intent.putExtra("number", str10);
                        intent.putExtra("fld",str2);
                        startActivity(intent);


                    } catch (SQLiteException se) {
                        Toast.makeText(getApplicationContext(), "not Saved Sucessfully", Toast.LENGTH_LONG).show();
                    }
                }


               /* try {
                   // db = openOrCreateDatabase("sampleu8", MODE_PRIVATE, null);
                   // db.execSQL("CREATE TABLE IF NOT EXISTS check1 (dos VARCHAR,ffno VARCHAR,emplyno VARCHAR,drno VARCHAR,area VARCHAR,taluk VARCHAR,pincode VARCHAR,lat VARCHAR,long1 VARCHAR,nooffmly VARCHAR,fmlyty VARCHAR,relgn VARCHAR,fmlyinc VARCHAR,house VARCHAR,housetyp VARCHAR,watersupply VARCHAR,toilet VARCHAR,infant VARCHAR,under5 VARCHAR,adolescent VARCHAR,antenatal VARCHAR,postnatal VARCHAR,geriatric VARCHAR,rice VARCHAR,wheat VARCHAR,sugar VARCHAR,salt VARCHAR,oil VARCHAR,fp VARCHAR,under5imun VARCHAR,rcrdcrtd VARCHAR,crtdby VARCHAR,site VARCHAR);");
                    //  db.execSQL("INSERT INTO tb1 values ('" + str1 + "','" + str2 + "','" + str3 + "','" + str4 + "','" + str5 + "','" + str6 + "','" + str7 + "','" + str8 + "','" + str9 + "','" + str10 + "','" + str26 + "','" + str27 + "','" + str11 + "','" + str28 + "','" + str29 + "','" + str30 + "','" + str31 + "','" + str20 + "','" + str21 + "','" + str22 + "','" + str23 + "','" + str24 + "','" + str25 + "','" + str12 + "','" + str13 + "','" + str14 + "','" + str15 + "','" + str16 + "','" + str32 + "','" + str33 + "','" + str17 + "','" + str18 + "','" + str19 + "');");
                    Toast.makeText(getApplicationContext(), "Saved Sucessfully", Toast.LENGTH_LONG).show();
                    //  new loginAccess().execute();
                    Intent intent = new Intent(getApplicationContext(), trail.class);
                    //  intent.putExtra("number",str10);
                    startActivity(intent);
                } catch (SQLiteException se) {
                    Toast.makeText(getApplicationContext(), "not Saved Sucessfully", Toast.LENGTH_LONG).show();
                }*/


            }
            });

     /*   b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Saved Sucessfully", Toast.LENGTH_LONG).show();

            }
        });*/


//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);


    }


    public ArrayList<String> getTableValues() {

        ArrayList<String> my_array = new ArrayList<String>();

        SQLiteDatabase db=openOrCreateDatabase("place3",MODE_PRIVATE,null);
        //db.execSQL("CREATE TABLE IF NOT EXISTS data1 (dos VARCHAR,ffno VARCHAR,emplyno VARCHAR,drno VARCHAR,area VARCHAR,taluk VARCHAR,pincode VARCHAR,lat VARCHAR,long1 VARCHAR,nooffmly VARCHAR,fmlyty VARCHAR,relgn VARCHAR,fmlyinc VARCHAR,house VARCHAR,housetyp VARCHAR,watersupply VARCHAR,toilet VARCHAR,infant VARCHAR,under5 VARCHAR,adolescent VARCHAR,antenatal VARCHAR,postnatal VARCHAR,geriatric VARCHAR,rice VARCHAR,wheat VARCHAR,sugar VARCHAR,salt VARCHAR,oil VARCHAR,fp VARCHAR,under5imun VARCHAR,rcrdcrtd VARCHAR,crtdby VARCHAR,site VARCHAR);");
        Cursor c = db.rawQuery("select * from place1", null);
        if (c != null) {

            // looping through all rows and adding to list
            if (c.moveToFirst()) {
                do {
                    String str1 = c.getString(c.getColumnIndex("dist"));
                    String str2 = c.getString(c.getColumnIndex("taluk"));
                    String str3="dd";
                    // Toast.makeText(getApplicationContext(), str2, Toast.LENGTH_LONG).show();

                    // Toast.makeText(getApplicationContext(), str3, Toast.LENGTH_LONG).show();
                    my_array.add(c.getString((c.getColumnIndex("dist"))));
                    // my_array.add(c.getString((c.getColumnIndex("taluk"))));
                } while (c.moveToNext());
            }
        }

        // closing connection
        c.close();
        db.close();

        // returning lables
        return my_array;
    }


    public ArrayList<String> getTableValues2(String str34) {

        ArrayList<String> my_array2= new ArrayList<String>();
//Toast.makeText(getApplicationContext(),st1,Toast.LENGTH_LONG).show();
        String st4="erode";
        SQLiteDatabase db = openOrCreateDatabase("place3", MODE_PRIVATE, null);
        //db.execSQL("CREATE TABLE IF NOT EXISTS data1 (dos VARCHAR,ffno VARCHAR,emplyno VARCHAR,drno VARCHAR,area VARCHAR,taluk VARCHAR,pincode VARCHAR,lat VARCHAR,long1 VARCHAR,nooffmly VARCHAR,fmlyty VARCHAR,relgn VARCHAR,fmlyinc VARCHAR,house VARCHAR,housetyp VARCHAR,watersupply VARCHAR,toilet VARCHAR,infant VARCHAR,under5 VARCHAR,adolescent VARCHAR,antenatal VARCHAR,postnatal VARCHAR,geriatric VARCHAR,rice VARCHAR,wheat VARCHAR,sugar VARCHAR,salt VARCHAR,oil VARCHAR,fp VARCHAR,under5imun VARCHAR,rcrdcrtd VARCHAR,crtdby VARCHAR,site VARCHAR);");
        Cursor c = db.rawQuery("select * from place1 where dist='"+str34+"'", null);
        if (c != null) {

            // looping through all rows and adding to list
            if (c.moveToFirst()) {
                do {
                    //  String str1 = c.getString(c.getColumnIndex("dist"));
                    String str2 = c.getString(c.getColumnIndex("taluk"));

                 //   Toast.makeText(getApplicationContext(), str34, Toast.LENGTH_LONG).show();


                    my_array2.add(c.getString((c.getColumnIndex("taluk"))));
                    // my_array.add(c.getString((c.getColumnIndex("taluk"))));
                } while (c.moveToNext());
            }
        }

        // closing connection
        c.close();
        db.close();

        // returning lables
        return my_array2;
    }


    class loginAccess extends AsyncTask<String, String, String> {


        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(FamilyDetails.this);
            pDialog.setMessage("Fetching location...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        protected String doInBackground(String... arg0) {
            return null;
        }
    }







            public String GetAddress(String lat1, String lon1)
    {

        Geocoder geocoder = new Geocoder(this, Locale.ENGLISH);
        String ret = "";
        try {
            List<Address> addresses = geocoder.getFromLocation(Double.parseDouble(lat1), Double.parseDouble(lon1), 1);
            if(addresses != null) {
                Address returnedAddress = addresses.get(0);
                StringBuilder strReturnedAddress = new StringBuilder("");
                for(int i=0; i<returnedAddress.getMaxAddressLineIndex(); i++) {
                    strReturnedAddress.append(returnedAddress.getAddressLine(i)).append("");
                }
                ret = strReturnedAddress.toString();
                yr=ret.substring(11, 17);

            }
            else{
                yr = "No Address returned!";
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            yr = "No Location";
        }
        return yr;
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
