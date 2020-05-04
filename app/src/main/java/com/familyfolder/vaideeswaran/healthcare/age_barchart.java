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
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VAIDEESWARAN on 06-04-2016.
 */
public class age_barchart extends AppCompatActivity {

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
        setContentView(R.layout.piechart);
        Bundle extras = getIntent().getExtras();

        spinner1 = extras.getString("spinner1");
        spinner2 = extras.getString("spinner2");
        new loginAccess1().execute();
        String spinner=spinner1;
        String spinner4=spinner2;
        Toast.makeText(getApplicationContext(),spinner,Toast.LENGTH_LONG).show();

        Toast.makeText(getApplicationContext(),spinner4,Toast.LENGTH_LONG).show();


    }

  /*  public void sex(View v) {
        new loginAccess1().execute();

    }
*/


    class loginAccess1 extends AsyncTask<String, String, String> {
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
                    Intent i = new Intent(age_barchart.this, Age.class);
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


}
