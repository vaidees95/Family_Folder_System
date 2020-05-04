package com.familyfolder.vaideeswaran.healthcare;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * Created by VAIDEESWARAN on 14-04-2016.
 */
public class try_spinner extends AppCompatActivity {

    ArrayList<String> my_array2 = new ArrayList<String>();
    ArrayList<String> my_array = new ArrayList<String>();

    public void insertLabel(String label){} // will insert a new label into labels table
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.try_spinner);
        final Spinner sp1;
        final Spinner sp2;

            String st1;
            String st2;
        sp1 = (Spinner) findViewById(R.id.spinner12);

        sp2 = (Spinner) findViewById(R.id.spinner13);


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

            // Spinner My_spinner = (Spinner) findViewById(R.id.spinner1);
            ArrayAdapter my_Adapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item,my_array);
            my_Adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            sp1.setAdapter(my_Adapter);

            sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String st1 = sp1.getSelectedItem().toString();
                    my_array2 = getTableValues2(st1);

                    ArrayAdapter my_Adapter2 = new ArrayAdapter(try_spinner.this, R.layout.support_simple_spinner_dropdown_item, my_array2);
                    my_Adapter2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                    sp2.setAdapter(my_Adapter2);


                    //  Toast.makeText(getApplicationContext(),sp1.getSelectedItem().toString(),Toast.LENGTH_LONG).show();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });


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


    public ArrayList<String> getTableValues2(String st1) {

        ArrayList<String> my_array2= new ArrayList<String>();
//Toast.makeText(getApplicationContext(),st1,Toast.LENGTH_LONG).show();
        String st4="erode";
        SQLiteDatabase db = openOrCreateDatabase("place3", MODE_PRIVATE, null);
        //db.execSQL("CREATE TABLE IF NOT EXISTS data1 (dos VARCHAR,ffno VARCHAR,emplyno VARCHAR,drno VARCHAR,area VARCHAR,taluk VARCHAR,pincode VARCHAR,lat VARCHAR,long1 VARCHAR,nooffmly VARCHAR,fmlyty VARCHAR,relgn VARCHAR,fmlyinc VARCHAR,house VARCHAR,housetyp VARCHAR,watersupply VARCHAR,toilet VARCHAR,infant VARCHAR,under5 VARCHAR,adolescent VARCHAR,antenatal VARCHAR,postnatal VARCHAR,geriatric VARCHAR,rice VARCHAR,wheat VARCHAR,sugar VARCHAR,salt VARCHAR,oil VARCHAR,fp VARCHAR,under5imun VARCHAR,rcrdcrtd VARCHAR,crtdby VARCHAR,site VARCHAR);");
        Cursor c = db.rawQuery("select * from place1 where dist='"+st1+"'", null);
        if (c != null) {

            // looping through all rows and adding to list
            if (c.moveToFirst()) {
                do {
                  //  String str1 = c.getString(c.getColumnIndex("dist"));
                    String str2 = c.getString(c.getColumnIndex("taluk"));

                  //  Toast.makeText(getApplicationContext(), str2, Toast.LENGTH_LONG).show();


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

    }
