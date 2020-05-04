package com.familyfolder.vaideeswaran.healthcare;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * Created by VAIDEESWARAN on 28-03-2016.
 */
public class Report_location1 extends AppCompatActivity {
    Spinner sp;
    Spinner sp1;
    Button bn;
    private static String url = "http://ffs.kongu.edu/report/spinner.php";
    private static String url1 = "http://ffs.kongu.edu/healthcare/join.php";
    private static String url2 = "http://ffs.kongu.edu/healthcare/join1.php";

    private static final String TAG_SUCCESS = "success";

    private static final String TAG_TALUK = "taluk";
    private static final String TAG_PRODUCTS = "products";
    private static final String TAG_BATCH = "gender";
    private static final String TAG_BRANCH = "Branch";
    private static final String TAG_DEGREE = "male";
    private static final String TAG_SECTION = "female";

    JSONParser jParser = new JSONParser();

    JSONArray products = null;

    JSONArray taluk1 = null;

    String sip,sip1;


    ArrayList<String> taluk,dist;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report_location1);
        //  sp = (Spinner) findViewById(R.id.spinner10);
        sp1= (Spinner) findViewById(R.id.spinner11);
        bn= (Button) findViewById(R.id.button11);

        // JSONArray products = null;

        String username;
        taluk = new ArrayList<>();
        //new LoadAllProducts().execute();
        dist = new ArrayList<>();
        new LoadAllProducts().execute();
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // String spinner1= sp.getSelectedItem().toString();
                String spinner2=sp1.getSelectedItem().toString();
                if(spinner2.matches(""))
                {

                    //et2.setError("invalide folder number");
                    Toast.makeText(Report_location1.this, "please wait to fetch district", Toast.LENGTH_SHORT).show();

                }
                else {

                    Intent intent = new Intent(getApplicationContext(), Report_location2.class);

                    //  intent.putExtra("spinner1",spinner1);
                    intent.putExtra("spinner2", spinner2);
                    startActivity(intent);
                }


            }
        });
    }

    class LoadAllProducts extends AsyncTask<String, String, String> {


        protected String doInBackground(String... args) {
            String str="hello";
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            // params.add(new BasicNameValuePair("user", str));
            JSONObject json = jParser.makeHttpRequest(url, "POST", params);

            JSONObject json1= jParser.makeHttpRequest(url1, "POST", params);

            JSONObject json2= jParser.makeHttpRequest(url2, "POST", params);
            Log.d("All Subjects: ", json.toString());
            try {
                int success = json.getInt(TAG_SUCCESS);

                if (success == 1) {
                    products = json.getJSONArray(TAG_PRODUCTS);
                    //  taluk1=json.getJSONArray(TAG_TALUK);

                    int i;
                    for (i = 0; i < products.length(); i++) {
                        JSONObject c = products.getJSONObject(i);
                        //dist.add(c.getString("taluk").toUpperCase());
                        dist.add(c.getString("dist").toUpperCase());
                    }
/*                        String gen=json.getString("gender");
                        male.add(gen);*/
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }
        protected void onPostExecute(String file_url) {

            runOnUiThread(new Runnable() {
                public void run() {

                    HashSet<String> taluk1,dist1;
                    //   taluk1 = new HashSet<String>(taluk);
                    // taluk.clear();
                    //taluk.addAll(taluk1);
                    //Collections.sort(taluk);
                    dist1 = new HashSet<String>(dist);
                    dist.clear();
                    dist.addAll(dist1);
                    Collections.sort(dist);

                    ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(Report_location1.this, android.R.layout.simple_spinner_item,dist);
                    adapter1.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                    sp1.setAdapter(adapter1);
                }
            });
        }





    }
}


