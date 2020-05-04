package com.familyfolder.vaideeswaran.healthcare;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VAIDEESWARAN on 27-03-2016.
 */
public class Chart extends AppCompatActivity {

    ArrayAdapter<CharSequence> adapter1;
    String str1;
    Button bn;
    int total;
    public static int success;
    int student;
    ArrayList<Integer> suc;
    LinearLayout lout;
    String msg;
    String spinner1;
    String spinner2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chart);
        Bundle extras = getIntent().getExtras();

        spinner1 = extras.getString("spinner1");
        spinner2 = extras.getString("spinner2");

    }

    public void occupation(View v) {
        new loginAccess().execute();

    }

    public void income(View v) {
        new loginAccess1().execute();
    }
    public void age(View v) {
       /* Intent i = new Intent(Chart.this, age_barchart.class);
        i.putExtra("spinner1",spinner1);
        i.putExtra("spinner2",spinner2);
        startActivity(i);*/
        new loginAccess18().execute();


    }

    public void sexratio(View v) {
       // Toast.makeText(getApplicationContext(),"inside age1",Toast.LENGTH_LONG).show();
     /*  Intent i = new Intent(Chart.this, piechart.class);
        i.putExtra("spinner1",spinner1);
        i.putExtra("spinner2",spinner2);
        startActivity(i);*/
        new loginAccess28().execute();

    }

    class loginAccess extends AsyncTask<String, String, String> {
        JSONParser jsonParser = new JSONParser();

        String url = "http://ffs.kongu.edu/document/occupation.php";
        private static final String TAG_SUCCESS = "success";
        String tag = "VS";
        private ProgressDialog pDialog;
        int flag = 0;
        String str2;
        SQLiteDatabase db = null;

        @Override
        protected String doInBackground(String... arg0) {
            Log.d(tag, "Inside");
            List<NameValuePair> params = new ArrayList<NameValuePair>();

            params.add(new BasicNameValuePair("spinner1", spinner1));

            params.add(new BasicNameValuePair("spinner2", spinner2));
            JSONObject json = jsonParser.makeHttpRequest(url, "POST", params);
            Log.d(tag, json.toString());
            try {
                success = json.getInt(TAG_SUCCESS);
                Log.d(tag, "Success=" + success);
                msg = json.getString("message");
                Log.d(tag, msg);
                // int success=json.getInt(TAG_SUCCESS);
                int child = json.getInt("child");
                Log.d(tag, "" + child);
                int student = json.getInt("student");
                Log.d(tag, "" + student);
                int employed = json.getInt("employed");
                Log.d(tag, "" + employed);
                int unemployed = json.getInt("unemployed");
                Log.d(tag, "" + unemployed);
                int selfemployed = json.getInt("selfemployed");
                Log.d(tag, "" + selfemployed);

       /*         */
                //  student = json.getInt("student");
                //     suc.add(success);
                if (success == 1) {
                    Log.d(tag, "Inside Success");
                    // db.execSQL("delete from t1");
                    flag = 0;
                    Intent i = new Intent(Chart.this, Occupation.class);
                    i.putExtra("child", child);
                    i.putExtra("employed", employed);
                    i.putExtra("student", student);
                    i.putExtra("unemployed", unemployed);
                    i.putExtra("selfemployed", selfemployed);
                    //   i.putExtra("success",success);
                    startActivity(i);
                    finish();
                } else {
                    Log.d(tag, "Inside Failure");
                    Intent i = new Intent(getApplicationContext(), Chart.class);
                    startActivity(i);
                    // failed to Sign in
                    flag = 1;
                }
            } catch (JSONException e) {
                Log.d(tag, "Inside Exception");
                e.printStackTrace();
            }


            return null;


        }
    }

   class loginAccess1 extends AsyncTask<String, String, String> {
        JSONParser jsonParser = new JSONParser();

        String url = "http://ffs.kongu.edu/document/income.php";
        private static final String TAG_SUCCESS = "success";
        private ProgressDialog pDialog;
        int flag = 0;
        String str2;
        SQLiteDatabase db = null;

        @Override
        protected String doInBackground(String... arg0) {
            List<NameValuePair> params = new ArrayList<NameValuePair>();

            params.add(new BasicNameValuePair("spinner1", spinner1));

            params.add(new BasicNameValuePair("spinner2", spinner2));
            JSONObject json = jsonParser.makeHttpRequest(url, "POST", params);
            Log.d("Create Response", json.toString());
            try {
                success = json.getInt(TAG_SUCCESS);

                msg = json.getString("message");
                // int success=json.getInt(TAG_SUCCESS);
                int child = json.getInt("child");
                int student = json.getInt("student");
                int employed = json.getInt("employed");
                int unemployed = json.getInt("unemployed");

       /*         */
                //  student = json.getInt("student");
                //  suc.add(success);
                if (success == 1) {
                    // db.execSQL("delete from t1");
                    flag = 0;
                    Intent i = new Intent(Chart.this, Income.class);
                    i.putExtra("child", child);
                    i.putExtra("employed", employed);
                    i.putExtra("student", student);
                    i.putExtra("unemployed", unemployed);
                    //   i.putExtra("success",success);
                    startActivity(i);
                    finish();
                } else {
                    Intent i = new Intent(getApplicationContext(), Chart.class);
                    startActivity(i);
                    // failed to Sign in
                    flag = 1;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }


            return null;


        }
    }

    class loginAccess2 extends AsyncTask<String, String, String> {
        JSONParser jsonParser = new JSONParser();

        String url = "http://192.168.43.234//yet//birth.php";
        private static final String TAG_SUCCESS = "success";
        private ProgressDialog pDialog;
        int flag = 0;
        String str2;
        SQLiteDatabase db = null;

        @Override
        protected String doInBackground(String... arg0) {
            List<NameValuePair> params = new ArrayList<NameValuePair>();

            params.add(new BasicNameValuePair("ffno", str1));
            JSONObject json = jsonParser.makeHttpRequest(url, "POST", params);
            Log.d("Create Response", json.toString());
            try {
                success = json.getInt(TAG_SUCCESS);

                //  msg=json.getString("message");
                // int success=json.getInt(TAG_SUCCESS);
                int child = json.getInt("eighteen");
                int student=json.getInt("fifty");
                int employed=json.getInt("sixty");

       /*         */
                //  student = json.getInt("student");
                //     suc.add(success);
                if (success == 1) {
                    // db.execSQL("delete from t1");
                    flag = 0;
                    Intent i = new Intent(Chart.this, Age.class);
                    i.putExtra("child", child);
                    i.putExtra("employed", employed);
                    i.putExtra("student",student);
                    //   i.putExtra("success",success);
                    startActivity(i);
                    finish();
                } else {
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                    // failed to Sign in
                    flag = 1;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }


            return null;


        }
    }

    class loginAccess18 extends AsyncTask<String, String, String> {
        JSONParser jsonParser = new JSONParser();

        //String url = "http://192.168.43.234/yet/salary.php";
        String url = "http://ffs.kongu.edu/document/salary.php";
        private static final String TAG_SUCCESS = "success";
        private ProgressDialog pDialog;
        int flag = 0;
        String str2;
        SQLiteDatabase db = null;

        @Override
        protected String doInBackground(String... arg0) {
            List<NameValuePair> params = new ArrayList<NameValuePair>();

            params.add(new BasicNameValuePair("spinner1", spinner1));

            params.add(new BasicNameValuePair("spinner2", spinner2));
            JSONObject json = jsonParser.makeHttpRequest(url, "POST", params);
            Log.d("Create Response", json.toString());
            try {
                success = json.getInt(TAG_SUCCESS);

                msg = json.getString("message");
                // int success=json.getInt(TAG_SUCCESS);
                int child = json.getInt("child");
                int student = json.getInt("student");
                int employed = json.getInt("employed");
                int unemployed = json.getInt("unemployed");
                int selfemployed = json.getInt("selfemployed");

       /*         */
                //  student = json.getInt("student");
                //  suc.add(success);
                if (success == 1) {
                    // db.execSQL("delete from t1");
                    flag = 0;
                    Intent i = new Intent(Chart.this, Age.class);
                    i.putExtra("child", child);
                    i.putExtra("employed", employed);
                    i.putExtra("student", student);
                    // i.putExtra("unemployed", unemployed);
                    //  i.putExtra("selfemployed", selfemployed);
                    //   i.putExtra("success",success);
                    startActivity(i);
                    finish();
                } else {
                    Intent i = new Intent(getApplicationContext(), FamilyDetails.class);
                    startActivity(i);
                    // failed to Sign in
                    flag = 1;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }


            return null;


        }
    }









































    class sexratio1 extends AsyncTask<String, String, String> {
        JSONParser jsonParser = new JSONParser();

        String url1 = "http://ffs.kongu.edu/report/sexratio.php";
        private static final String TAG_SUCCESS = "success";
        private ProgressDialog pDialog;
        int flag = 0;
        String str2;
        SQLiteDatabase db = null;

        @Override
        protected String doInBackground(String... arg0) {
            List<NameValuePair> params = new ArrayList<NameValuePair>();

            params.add(new BasicNameValuePair("spinner1", spinner1));

            params.add(new BasicNameValuePair("spinner2", spinner2));
            JSONObject json = jsonParser.makeHttpRequest(url1, "POST", params);
            Log.d("Create Response", json.toString());
            try {
                success = json.getInt(TAG_SUCCESS);

                msg = json.getString("message");
                // int success=json.getInt(TAG_SUCCESS);
                int child = json.getInt("child");
                int student = json.getInt("student");
                int employed = json.getInt("employed");
                int unemployed = json.getInt("unemployed");
                int selfemployed = json.getInt("selfemployed");

       /*         */
                //  student = json.getInt("student");
                //  suc.add(success);
                if (success == 1) {
                    // db.execSQL("delete from t1");
                    flag = 0;
                    Intent i = new Intent(Chart.this, Sexratio.class);
                    i.putExtra("child", child);
                    i.putExtra("employed", employed);
                    i.putExtra("student", student);
                    // i.putExtra("unemployed", unemployed);
                    //  i.putExtra("selfemployed", selfemployed);
                    //   i.putExtra("success",success);
                    startActivity(i);
                    finish();
                } else {
                    Intent i = new Intent(getApplicationContext(), FamilyDetails.class);
                    startActivity(i);
                    // failed to Sign in
                    flag = 1;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }


            return null;


        }
    }














    class loginAccess28 extends AsyncTask<String, String, String> {
        JSONParser jsonParser = new JSONParser();

        //String url = "http://192.168.43.234/yet/salary.php";
        String url34 = "http://ffs.kongu.edu/document/age.php";
        private static final String TAG_SUCCESS = "success";
        private ProgressDialog pDialog;
        int flag = 0;
        String str2;
        SQLiteDatabase db = null;

        @Override
        protected String doInBackground(String... arg0) {
            List<NameValuePair> params = new ArrayList<NameValuePair>();

            params.add(new BasicNameValuePair("spinner1", spinner1));

            params.add(new BasicNameValuePair("spinner2", spinner2));
            JSONObject json = jsonParser.makeHttpRequest(url34, "POST", params);
            Log.d("Create Response", json.toString());
            try {
                success = json.getInt(TAG_SUCCESS);
                msg = json.getString("message");
                // int success=json.getInt(TAG_SUCCESS);
                int child = json.getInt("child");
                int student = json.getInt("student");
                //  int employed = json.getInt("employed");
                // int unemployed = json.getInt("unemployed");
                // int selfemployed = json.getInt("selfemployed");

       /*         */
                //  student = json.getInt("student");
                //  suc.add(success);
                if (success == 1) {
                    // db.execSQL("delete from t1");
                    flag = 0;
                    Intent i = new Intent(Chart.this,Sexratio.class);
                    i.putExtra("child", child);
                    // i.putExtra("employed", employed);
                    i.putExtra("student", student);
                    //i.putExtra("unemployed", unemployed);
                    //  i.putExtra("selfemployed", selfemployed);
                    //   i.putExtra("success",success);
                    startActivity(i);
                    finish();
                } else {
                    Intent i = new Intent(getApplicationContext(), FamilyDetails.class);
                    startActivity(i);
                    // failed to Sign in
                    flag = 1;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }


            return null;


        }
    }


}
