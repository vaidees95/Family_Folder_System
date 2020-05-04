package com.familyfolder.vaideeswaran.healthcare;

import android.app.ProgressDialog;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class BackgroundService extends Service {
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
    String str26;
    String str27;
    String str11;
    String str28;
    String str29;
    String str30;
    String str31;
    String str20;
    String str21;
    String str22;
    String str23;
    String str24;
    String str25;
    String str12;
    String str13;
    String str14;
    String str15;
    String str16;
    String str32;
    String str33;
    String str17;
    String str18;
    String str19;
    String str40;
    String str41;
    String str42;
    String str43;
    String str44;
    String str45;
    String str46;
    String str47;
    String str48;
    String str49;
    String str50;
    String str51;
    String str52;
    String str53;
    String str54;
    String str55;
    String str56;
    String str90;
    String str57;
    String str58;




    private boolean isRunning;
    private Context context;
    private  Thread backgroundThread;
    JSONParser jsonParser = new JSONParser();
    private static String url = "http://ffs.kongu.edu/healthcare/familydetails.php";
    private static String url1 = "http://ffs.kongu.edu/healthcare/familymember.php";
     String url2 = "http://ffs.kongu.edu/healthcare/uid.php";
    private static final String TAG_SUCCESS = "success";
    private ProgressDialog pDialog;
    int flag=0;
    SQLiteDatabase db=null;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        this.context = this;
        this.isRunning = false;
        this.backgroundThread = new Thread(myTask);
    }

    private Runnable myTask = new Runnable() {
        public void run() {

            // Toast.makeText(this,"service started",Toast.LENGTH_LONG).show();
            // Do something here
            stopSelf();
        }
    };

    @Override
    public void onDestroy() {
        this.isRunning = false;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(!this.isRunning) {
            this.isRunning = true;
            this.backgroundThread.start();
        }




        // get Connectivity Manager object to check connection
        ConnectivityManager connec =
                (ConnectivityManager)getSystemService(getBaseContext().CONNECTIVITY_SERVICE);

        // Check for network connections
        if ( connec.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTED ||
                connec.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTED ) {

            // if connected with internet

            new loginAccess().execute();
          //  Toast.makeText(this, "Information stored in cloud storage", Toast.LENGTH_LONG).show();




        } else if (
                connec.getNetworkInfo(0).getState() == NetworkInfo.State.DISCONNECTED ||
                        connec.getNetworkInfo(1).getState() == NetworkInfo.State.DISCONNECTED  ) {

         //   Toast.makeText(this, "Connect to internet ", Toast.LENGTH_LONG).show();


            // return false;
        }
        // return false;





        //Toast.makeText(this,"service started",Toast.LENGTH_SHORT).show();

        return START_STICKY;
    }






    class loginAccess extends AsyncTask<String, String, String> {

      /* protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(BackgroundService.this);
            pDialog.setMessage("processing...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }*/

        @Override
        protected String doInBackground(String... arg0) {
            List<NameValuePair> params = new ArrayList<NameValuePair>();
           try {
                db=openOrCreateDatabase("pendriv1",MODE_PRIVATE,null);
                //db.execSQL("CREATE TABLE IF NOT EXISTS data1 (dos VARCHAR,ffno VARCHAR,emplyno VARCHAR,drno VARCHAR,area VARCHAR,taluk VARCHAR,pincode VARCHAR,lat VARCHAR,long1 VARCHAR,nooffmly VARCHAR,fmlyty VARCHAR,relgn VARCHAR,fmlyinc VARCHAR,house VARCHAR,housetyp VARCHAR,watersupply VARCHAR,toilet VARCHAR,infant VARCHAR,under5 VARCHAR,adolescent VARCHAR,antenatal VARCHAR,postnatal VARCHAR,geriatric VARCHAR,rice VARCHAR,wheat VARCHAR,sugar VARCHAR,salt VARCHAR,oil VARCHAR,fp VARCHAR,under5imun VARCHAR,rcrdcrtd VARCHAR,crtdby VARCHAR,site VARCHAR);");
                Cursor c = db.rawQuery("select * from data2", null);
                if (c != null) {
                    if (c.moveToFirst()) {
                        do {
                            str1 = c.getString(c.getColumnIndex("dos"));
                            str2 = c.getString(c.getColumnIndex("ffno"));
                            str3 = c.getString(c.getColumnIndex("emplyno"));
                            str4 = c.getString(c.getColumnIndex("drno"));
                            str5 = c.getString(c.getColumnIndex("area"));

                            str58 = c.getString(c.getColumnIndex("dist"));
                            str6 = c.getString(c.getColumnIndex("taluk"));
                            str7 = c.getString(c.getColumnIndex("pincode"));
                            str8 = c.getString(c.getColumnIndex("lat"));
                            str9 = c.getString(c.getColumnIndex("long1"));
                            str10 = c.getString(c.getColumnIndex("nooffmly"));
                            str26 = c.getString(c.getColumnIndex("fmlyty"));
                            str27 = c.getString(c.getColumnIndex("relgn"));
                            str11 = c.getString(c.getColumnIndex("fmlyinc"));
                            str28 = c.getString(c.getColumnIndex("house"));
                            str29 = c.getString(c.getColumnIndex("housetyp"));
                            str30 = c.getString(c.getColumnIndex("watersupply"));
                            str31 = c.getString(c.getColumnIndex("toilet"));
                            str20 = c.getString(c.getColumnIndex("infant"));
                            str21 = c.getString(c.getColumnIndex("under5"));
                            str22 = c.getString(c.getColumnIndex("adolescent"));
                            str23 = c.getString(c.getColumnIndex("antenatal"));
                            str24 = c.getString(c.getColumnIndex("postnatal"));
                            str25 = c.getString(c.getColumnIndex("geriatric"));
                            str12 = c.getString(c.getColumnIndex("rice"));
                            str13 = c.getString(c.getColumnIndex("wheat"));
                            str14 = c.getString(c.getColumnIndex("sugar"));
                            str15 = c.getString(c.getColumnIndex("salt"));
                            str16 = c.getString(c.getColumnIndex("oil"));
                            str32 = c.getString(c.getColumnIndex("fp"));
                            str33 = c.getString(c.getColumnIndex("under5imun"));
                            str17 = c.getString(c.getColumnIndex("rcrdcrtd"));
                            str18 = c.getString(c.getColumnIndex("crtdby"));
                            str19 = c.getString(c.getColumnIndex("site"));


                            params.add(new BasicNameValuePair("dos",str1));
                            params.add(new BasicNameValuePair("ffno",str2));
                            params.add(new BasicNameValuePair("emplyno",str3));
                            params.add(new BasicNameValuePair("drno",str4));
                            params.add(new BasicNameValuePair("area",str5));
                            params.add(new BasicNameValuePair("dist",str58));
                            params.add(new BasicNameValuePair("taluk",str6));
                            params.add(new BasicNameValuePair("pincode",str7));
                            params.add(new BasicNameValuePair("lat",str8));
                            params.add(new BasicNameValuePair("long1",str9));
                            params.add(new BasicNameValuePair("nooffmly",str10));
                            params.add(new BasicNameValuePair("fmlyty",str26));
                            params.add(new BasicNameValuePair("relgn",str27));
                            params.add(new BasicNameValuePair("fmlyinc",str11));
                            params.add(new BasicNameValuePair("house",str28));
                            params.add(new BasicNameValuePair("housetyp",str29));
                            params.add(new BasicNameValuePair("watersupply",str30));
                            params.add(new BasicNameValuePair("toilet",str31));
                            params.add(new BasicNameValuePair("infant",str20));
                            params.add(new BasicNameValuePair("under5",str21));
                            params.add(new BasicNameValuePair("adolescent",str22));
                            params.add(new BasicNameValuePair("antenatal",str23));
                            params.add(new BasicNameValuePair("postnatal",str24));
                            params.add(new BasicNameValuePair("geriatric",str25));
                            params.add(new BasicNameValuePair("rice",str12));
                            params.add(new BasicNameValuePair("wheat",str13));
                            params.add(new BasicNameValuePair("sugar",str14));
                            params.add(new BasicNameValuePair("salt",str15));
                            params.add(new BasicNameValuePair("oil",str16));
                            params.add(new BasicNameValuePair("fp",str32));
                            params.add(new BasicNameValuePair("under5imun",str33));
                            params.add(new BasicNameValuePair("rcrdcrtd",str17));
                            params.add(new BasicNameValuePair("crtdby",str18));
                            params.add(new BasicNameValuePair("site",str19));


                               // Toast.makeText(getApplicationContext(),"table deleted",Toast.LENGTH_LONG).show();

                            JSONObject json = jsonParser.makeHttpRequest(url, "POST", params);
                          Log.d("Create Response", json.toString());

                            try {

                                int success = json.getInt(TAG_SUCCESS);
                                if (success == 1) {
                                   // db = openOrCreateDatabase("database", MODE_PRIVATE, null);
                                   db.execSQL("delete from data2");
                                    flag = 0;
                     /*   Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    i.putExtra("email", email);
                    i.putExtra("pass", pass);
                    startActivity(i);
                    finish();*/
                               } else {
                                    // failed to Sign in
                                    flag = 1;
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


                        } while (c.moveToNext());
                    }
                }
               /* else
                {
                    Toast.makeText(getApplicationContext(),"else part",Toast.LENGTH_LONG).show();
                   // db = openOrCreateDatabase("database", MODE_PRIVATE, null);
                    //db.execSQL("delete * from udhaya");
                }*/
            }catch (SQLiteException se) {
//                Toast.makeText(getApplicationContext(),"couldn't create or open the database",Toast.LENGTH_LONG).show();
            }






        try {


                db = openOrCreateDatabase("pendrive1", MODE_PRIVATE, null);
             //   db.execSQL("CREATE TABLE IF NOT EXISTS data2 (dos VARCHAR,ffno VARCHAR)");
                Cursor c = db.rawQuery("select * from data2", null);
                if (c != null) {
                    if (c.moveToFirst()) {
                        do {
                            str40 = c.getString(c.getColumnIndex("ffno"));
                            str41 = c.getString(c.getColumnIndex("sino"));
                            str42 = c.getString(c.getColumnIndex("name"));
                            str43 = c.getString(c.getColumnIndex("relationtohead"));
                            str44 = c.getString(c.getColumnIndex("dob"));
                            str57 = c.getString(c.getColumnIndex("occupation"));
                            str45 = c.getString(c.getColumnIndex("gender"));
                            str46 = c.getString(c.getColumnIndex("maritalstatus"));
                            str47 = c.getString(c.getColumnIndex("education"));
                            str48 = c.getString(c.getColumnIndex("wt"));
                            str49 = c.getString(c.getColumnIndex("hght"));
                            str50 = c.getString(c.getColumnIndex("bmi"));
                            str51 = c.getString(c.getColumnIndex("sysbp"));
                            str52 = c.getString(c.getColumnIndex("diastbp"));
                            str53 = c.getString(c.getColumnIndex("chronicill"));
                            str54 = c.getString(c.getColumnIndex("smoking"));
                            str55 = c.getString(c.getColumnIndex("alcohol"));
                            str56 = c.getString(c.getColumnIndex("aadhar"));





                            params.add(new BasicNameValuePair("ffno",str40));
                            params.add(new BasicNameValuePair("sino",str41));
                            params.add(new BasicNameValuePair("name",str42));
                            params.add(new BasicNameValuePair("relationtohead",str43));
                            params.add(new BasicNameValuePair("dob",str44));
                            params.add(new BasicNameValuePair("occupation",str57));
                            params.add(new BasicNameValuePair("gender",str45));
                            params.add(new BasicNameValuePair("maritalstatus",str46));
                            params.add(new BasicNameValuePair("education",str47));
                            params.add(new BasicNameValuePair("wt",str48));
                            params.add(new BasicNameValuePair("hght",str49));
                            params.add(new BasicNameValuePair("bmi",str50));
                            params.add(new BasicNameValuePair("sysbp",str51));
                            params.add(new BasicNameValuePair("diastbp",str52));
                            params.add(new BasicNameValuePair("chronicill",str53));
                            params.add(new BasicNameValuePair("smoking",str54));
                            params.add(new BasicNameValuePair("alcohol",str55));
                            params.add(new BasicNameValuePair("aadhar",str56));





                            // Toast.makeText(getApplicationContext(),"table deleted",Toast.LENGTH_LONG).show();

                            JSONObject json = jsonParser.makeHttpRequest(url1, "POST", params);
                            Log.d("Create Response", json.toString());

                            try {

                                int success = json.getInt(TAG_SUCCESS);
                                if (success == 1) {
                                    // db = openOrCreateDatabase("database", MODE_PRIVATE, null);
                                    db.execSQL("delete from data2");
                                    flag = 0;
                 /*   Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    i.putExtra("email", email);
                    i.putExtra("pass", pass);
                    startActivity(i);
                    finish();*/
                                } else {
                                    // failed to Sign in
                                    flag = 1;
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


                        } while (c.moveToNext());
                    }
                }


            }
            catch (SQLiteException se) {
//                Toast.makeText(getApplicationContext(),"couldn't create or open the database",Toast.LENGTH_LONG).show();

            }



            try {

                String str91;
                db = openOrCreateDatabase("pendriv", MODE_PRIVATE, null);
               // db.execSQL("CREATE TABLE IF NOT EXISTS data3 (dos VARCHAR,ffno VARCHAR)");
                Cursor c = db.rawQuery("select * from data3", null);
                if (c != null) {
                    if (c.moveToFirst()) {
                        do {
                            str90 = c.getString(c.getColumnIndex("uid"));
                            str91 = c.getString(c.getColumnIndex("fld"));
                            params.add(new BasicNameValuePair("uid",str90));
                            params.add(new BasicNameValuePair("fld",str91));


                            // Toast.makeText(getApplicationContext(),"table deleted",Toast.LENGTH_LONG).show();

                            JSONObject json = jsonParser.makeHttpRequest(url2, "POST", params);
                            Log.d("Create Response", json.toString());

                            try {

                                int success = json.getInt(TAG_SUCCESS);
                                if (success == 1) {
                                    // db = openOrCreateDatabase("database", MODE_PRIVATE, null);
                                    db.execSQL("delete from data3");
                                    flag = 0;
                 /*   Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    i.putExtra("email", email);
                    i.putExtra("pass", pass);
                    startActivity(i);
                    finish();*/
                                } else {
                                    // failed to Sign in
                                    flag = 1;
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


                        } while (c.moveToNext());
                    }
                }


            }
            catch (SQLiteException se) {
//                Toast.makeText(getApplicationContext(),"couldn't create or open the database",Toast.LENGTH_LONG).show();

            }























            return null;
        }


     /*   protected void onPostExecute(String file_url) {
            pDialog.dismiss();
            if (flag == 1)
                Toast.makeText(BackgroundService.this, "Please Enter Correct informations", Toast.LENGTH_LONG).show();

        }*/
    }

}