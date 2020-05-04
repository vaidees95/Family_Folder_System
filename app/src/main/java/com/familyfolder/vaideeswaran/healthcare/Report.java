package com.familyfolder.vaideeswaran.healthcare;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VAIDEESWARAN on 27-03-2016.
 */
public class Report extends AppCompatActivity {
    static JSONArray products = null;
    int flag;
String spinner1;
    String spinner2;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.document);
        Bundle extras = getIntent().getExtras();

        spinner1 = extras.getString("spinner1");
        spinner2=extras.getString("spinner2");



    }

    public void excel(View view) {
        String god = "Healthcare";
        new loginAccess1().execute();
        if (flag == 0) {
            Toast.makeText(getApplicationContext(), god + ".xls created", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "I/O error",
                    Toast.LENGTH_SHORT).show();
        }
        File file = new File(Environment.getExternalStorageDirectory(), "Healthcare/healtcare.xls");
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("application/Excel");
        Uri uri = Uri.fromFile(file);
        intent.putExtra(Intent.EXTRA_STREAM, uri);
        startActivity(intent);


    }

    public void pdf(View view) {
        String filename = "Healthcare";
        String filecontent = "Contenido";
        // Metodos fop = new Metodos();
        // String t= fop.str1;
//Toast.makeText(getApplicationContext(), t, Toast.LENGTH_LONG);
        //fop.write(filename, filecontent);
        new loginAccess().execute();
        File sdcard = Environment.getExternalStorageDirectory();
        File file = new File(Environment.getExternalStorageDirectory(), "Healthcare/healtcare.pdf");
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("application/pdf");
        Uri uri = Uri.fromFile(file);
        intent.putExtra(Intent.EXTRA_STREAM, uri);
        startActivity(intent);


        if (flag == 0) {
            Toast.makeText(getApplicationContext(), filename + ".pdf created", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "I/O error",
                    Toast.LENGTH_SHORT).show();
        }


       // Toast.makeText(getApplicationContext(), "hello pdf", Toast.LENGTH_LONG).show();

    }

    public void text(View view) {
        new loginAccess3().execute();
        File file = new File(Environment.getExternalStorageDirectory(), "Healthcare/healtcare.docx");
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("application/plain");
        Uri uri = Uri.fromFile(file);
        intent.putExtra(Intent.EXTRA_STREAM, uri);
        startActivity(intent);

    }

    class loginAccess1 extends AsyncTask<String, String, String> {
        // @Override
        // String god = "parents";
        int j;
        private static final String TAG_PRODUCTS = "products";
        private static final String TAG_USER = "username";
        private static final String TAG_PASS = "password";
        // products JSONArray
        // static JSONArray products = null;
        String god = "Healthcare";


        EditText et1;

        private static final String LOG_TAG = "GeneratePDF";


        JSONParser jsonParser = new JSONParser();
        String srt;
        int numrows;
        String url1 = "http://ffs.kongu.edu/document/document.php";
        private ProgressDialog pDialog;
        int flag;
        SQLiteDatabase db = null;
        String TAG_SUCCESS = "success";
        String TAG_SUCCESS1 = "message";
        String str1 = "login";
        String str2 = "pass";


        protected String doInBackground(String... arg0) {

            List<NameValuePair> params = new ArrayList<NameValuePair>();
            try {
                int log = 1;
                params.add(new BasicNameValuePair("spinner1", spinner1));
                params.add(new BasicNameValuePair("spinner2", spinner2));
                JSONObject json = jsonParser.makeHttpRequest(url1, "POST", params);
                Log.d("Create Response", json.toString());
                try {

                    int success = json.getInt(TAG_SUCCESS);
                    products = json.getJSONArray(TAG_PRODUCTS);


    /* private static boolean saveExcelFile(Context context, String fileName) {

        // check if available and not read only
        if (!isExternalStorageAvailable() || isExternalStorageReadOnly()) {
            Log.e(TAG, "Storage not available or read only");
            return false;
        }*/

                    //  boolean success = false;

                    //New Workbook
                    Workbook wb = new HSSFWorkbook();

                    Cell c = null;

                    //Cell style for header row
                    CellStyle cs = wb.createCellStyle();
                    cs.setFillForegroundColor(HSSFColor.LIME.index);
                    cs.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

                    //New Sheet
                    Sheet sheet1 = null;
                    sheet1 = wb.createSheet("Healthcare");

                    // Generate column headings
                    Row row = sheet1.createRow(0);

                    c = row.createCell(0);
                    c.setCellValue("family_folder_no");
                    c.setCellStyle(cs);

                    c = row.createCell(1);
                    c.setCellValue("date_of_survey");
                    c.setCellStyle(cs);

                    c = row.createCell(2);
                    c.setCellValue("employee_no");
                    c.setCellStyle(cs);


                    c = row.createCell(3);
                    c.setCellValue("door_no");
                    c.setCellStyle(cs);


                    c = row.createCell(4);
                    c.setCellValue("area");
                    c.setCellStyle(cs);


                    c = row.createCell(5);
                    c.setCellValue("dist");
                    c.setCellStyle(cs);


                    c = row.createCell(6);
                    c.setCellValue("taluk");
                    c.setCellStyle(cs);


                    c = row.createCell(7);
                    c.setCellValue("pincode");
                    c.setCellStyle(cs);


                    c = row.createCell(8);
                    c.setCellValue("latitude");
                    c.setCellStyle(cs);


                    c = row.createCell(9);
                    c.setCellValue("longitude");
                    c.setCellStyle(cs);


                    c = row.createCell(10);
                    c.setCellValue("total_no_family");
                    c.setCellStyle(cs);



                    c = row.createCell(11);
                    c.setCellValue("family_type");
                    c.setCellStyle(cs);


                    c = row.createCell(12);
                    c.setCellValue("religion");
                    c.setCellStyle(cs);


                    c = row.createCell(13);
                    c.setCellValue("family_inc");
                    c.setCellStyle(cs);



                    c = row.createCell(14);
                    c.setCellValue("house");
                    c.setCellStyle(cs);



                    c = row.createCell(15);
                    c.setCellValue("house_type");
                    c.setCellStyle(cs);



                    c = row.createCell(16);
                    c.setCellValue("source_of_water");
                    c.setCellStyle(cs);



                    c = row.createCell(17);
                    c.setCellValue("type_of_toilet");
                    c.setCellStyle(cs);



                    c = row.createCell(18);
                    c.setCellValue("infant");
                    c.setCellStyle(cs);



                    c = row.createCell(19);
                    c.setCellValue("under5");
                    c.setCellStyle(cs);


                    c = row.createCell(20);
                    c.setCellValue("adolescent");
                    c.setCellStyle(cs);


                    c = row.createCell(21);
                    c.setCellValue("antenatal");
                    c.setCellStyle(cs);


                    c = row.createCell(22);
                    c.setCellValue("postnatal");
                    c.setCellStyle(cs);


                    c = row.createCell(23);
                    c.setCellValue("geriatric");
                    c.setCellStyle(cs);


                    c = row.createCell(24);
                    c.setCellValue("rice");
                    c.setCellStyle(cs);


                    c = row.createCell(25);
                    c.setCellValue("wheat");
                    c.setCellStyle(cs);


                    c = row.createCell(26);
                    c.setCellValue("sugar");
                    c.setCellStyle(cs);


                    c = row.createCell(27);
                    c.setCellValue("salt");
                    c.setCellStyle(cs);


                    c = row.createCell(28);
                    c.setCellValue("oil");
                    c.setCellStyle(cs);


                    c = row.createCell(29);
                    c.setCellValue("family_planing");
                    c.setCellStyle(cs);


                    c = row.createCell(30);
                    c.setCellValue("under5_immunization");
                    c.setCellStyle(cs);


                    c = row.createCell(31);
                    c.setCellValue("rcrd_crct_dt");
                    c.setCellStyle(cs);


                    c = row.createCell(32);
                    c.setCellValue("created_by");
                    c.setCellStyle(cs);


                    c = row.createCell(33);
                    c.setCellValue("site_clinic");
                    c.setCellStyle(cs);


                    c = row.createCell(34);
                    c.setCellValue("sl_no");
                    c.setCellStyle(cs);


                    c = row.createCell(35);
                    c.setCellValue("name");
                    c.setCellStyle(cs);


                    c = row.createCell(36);
                    c.setCellValue("relation_to_head");
                    c.setCellStyle(cs);


                    c = row.createCell(37);
                    c.setCellValue("date_of_birth");
                    c.setCellStyle(cs);


                    c = row.createCell(38);
                    c.setCellValue("occupation");
                    c.setCellStyle(cs);


                    c = row.createCell(39);
                    c.setCellValue("gender");
                    c.setCellStyle(cs);


                    c = row.createCell(40);
                    c.setCellValue("mariatal_status");
                    c.setCellStyle(cs);



                    c = row.createCell(41);
                    c.setCellValue("education");
                    c.setCellStyle(cs);


                    c = row.createCell(42);
                    c.setCellValue("weight");
                    c.setCellStyle(cs);


                    c = row.createCell(43);
                    c.setCellValue("height");
                    c.setCellStyle(cs);


                    c = row.createCell(44);
                    c.setCellValue("bmi");
                    c.setCellStyle(cs);


                    c = row.createCell(45);
                    c.setCellValue("sysbp");
                    c.setCellStyle(cs);


                    c = row.createCell(46);
                    c.setCellValue("diastbp");
                    c.setCellStyle(cs);


                    c = row.createCell(47);
                    c.setCellValue("chronic_illness");
                    c.setCellStyle(cs);


                    c = row.createCell(48);
                    c.setCellValue("smoking");
                    c.setCellStyle(cs);


                    c = row.createCell(49);
                    c.setCellValue("alcohol");
                    c.setCellStyle(cs);


                    c = row.createCell(50);
                    c.setCellValue("aadhar number");
                    c.setCellStyle(cs);


                    c = row.createCell(51);
                    c.setCellValue("uid");
                    c.setCellStyle(cs);


                    for (int i = 0, j = 1; i < products.length(); i++, j++) {


                        JSONObject d = products.getJSONObject(i);

                        // Storing each json item in variable
                        String fno=d.getString("ffno");
                        String dos   =d.getString("dos");
                        String   eno =d.getString("eno");

                        String    dnp=d.getString("dno");
                        String    area=d.getString("area");
                        String    dis=d.getString("dist");
                        String    tal=d.getString("taluk");
                        String    pin=d.getString("pincode");
                        String    lat=d.getString("lat");
                        String    lon=d.getString("lon");
                        String    tnof=d.getString("nofam");
                        String    ft=d.getString("ftyp");
                        String    rel=d.getString("reg");
                        String    fi=d.getString("finc");
                        String    hou=d.getString("house");
                        String    ht=d.getString("htyp");
                        String    sow=d.getString("water");
                        String    tot=d.getString("ttoilet");
                        String    in=d.getString("inf");
                        String    und=d.getString("under5");
                        String    ado=d.getString("adol");
                        String    ant=d.getString("ant");
                        String    pos=d.getString("post");
                        String    ger=d.getString("gerc");
                        String    ri=d.getString("rice");




                        String    whe=d.getString("wheat");
                        String    sug=d.getString("sug");
                        String    sal=d.getString("salt");
                        String    oi=d.getString("oil");
                        String    fp=d.getString("family_planing");
                        String    undr=d.getString("under5_immunization");
                        String    rcr=d.getString("rcrd_crct_dt");
                        String    cb=d.getString("created_by");
                        String    sc=d.getString("site_clinic");
                        String    sln=d.getString("sl_no");
                        String    nam=d.getString("name");
                        String    rth=d.getString("relation_to_head");
                        String    dob=d.getString("date_of_birth");
                        String    occ=d.getString("occupation");
                        String    gen=d.getString("gender");
                        String    ms=d.getString("mariatal_status");
                        String    edu=d.getString("education");
                        String    wei=d.getString("weight");
                        String    hei=d.getString("height");
                        String    bm=d.getString("bmi");
                        String    sb=d.getString("sys_bp");
                        String    db=d.getString("diast_bp");
                        String    ci=d.getString("chronic_illness");
                        String    smo=d.getString("smoking");
                        String    alc=d.getString("alcohol");
                        String    an=d.getString("aadhar_no");
                        String    ui=d.getString("uid");




                        Row row1 = sheet1.createRow(j);

                        c = row1.createCell(0);
                        c.setCellValue(fno);
                        c.setCellStyle(cs);

                        c = row1.createCell(1);
                        c.setCellValue(dos);
                        c.setCellStyle(cs);

                        c = row1.createCell(2);
                        c.setCellValue(eno);
                        c.setCellStyle(cs);


                        c = row1.createCell(3);
                        c.setCellValue(dnp);
                        c.setCellStyle(cs);


                        c = row1.createCell(4);
                        c.setCellValue(area);
                        c.setCellStyle(cs);



                        c = row1.createCell(5);
                        c.setCellValue(dis);
                        c.setCellStyle(cs);



                        c = row1.createCell(6);
                        c.setCellValue(tal);
                        c.setCellStyle(cs);



                        c = row1.createCell(7);
                        c.setCellValue(pin);
                        c.setCellStyle(cs);



                        c = row1.createCell(8);
                        c.setCellValue(lat);
                        c.setCellStyle(cs);


                        c = row1.createCell(9);
                        c.setCellValue(lon);
                        c.setCellStyle(cs);


                        c = row1.createCell(10);
                        c.setCellValue(tnof);
                        c.setCellStyle(cs);


                        c = row1.createCell(11);
                        c.setCellValue(ft);
                        c.setCellStyle(cs);


                        c = row1.createCell(12);
                        c.setCellValue(rel);
                        c.setCellStyle(cs);


                        c = row1.createCell(13);
                        c.setCellValue(fi);
                        c.setCellStyle(cs);


                        c = row1.createCell(14);
                        c.setCellValue(hou);
                        c.setCellStyle(cs);


                        c = row1.createCell(15);
                        c.setCellValue(ht);
                        c.setCellStyle(cs);


                        c = row1.createCell(16);
                        c.setCellValue(sow);
                        c.setCellStyle(cs);


                        c = row1.createCell(17);
                        c.setCellValue(tot);
                        c.setCellStyle(cs);


                        c = row1.createCell(18);
                        c.setCellValue(in);
                        c.setCellStyle(cs);


                        c = row1.createCell(19);
                        c.setCellValue(und);
                        c.setCellStyle(cs);


                        c = row1.createCell(20);
                        c.setCellValue(ado);
                        c.setCellStyle(cs);


                        c = row1.createCell(21);
                        c.setCellValue(ant);
                        c.setCellStyle(cs);


                        c = row1.createCell(22);
                        c.setCellValue(pos);
                        c.setCellStyle(cs);


                        c = row1.createCell(23);
                        c.setCellValue(ger);
                        c.setCellStyle(cs);


                        c = row1.createCell(24);
                        c.setCellValue(ri);
                        c.setCellStyle(cs);



                        c = row1.createCell(25);
                        c.setCellValue(whe);
                        c.setCellStyle(cs);


                        c = row1.createCell(26);
                        c.setCellValue(sug);
                        c.setCellStyle(cs);


                        c = row1.createCell(27);
                        c.setCellValue(sal);
                        c.setCellStyle(cs);


                        c = row1.createCell(28);
                        c.setCellValue(oi);
                        c.setCellStyle(cs);



                        c = row1.createCell(29);
                        c.setCellValue(fp);
                        c.setCellStyle(cs);


                        c = row1.createCell(30);
                        c.setCellValue(undr);
                        c.setCellStyle(cs);


                        c = row1.createCell(31);
                        c.setCellValue(rcr);
                        c.setCellStyle(cs);


                        c = row1.createCell(32);
                        c.setCellValue(cb);
                        c.setCellStyle(cs);


                        c = row1.createCell(33);
                        c.setCellValue(sc);
                        c.setCellStyle(cs);


                        c = row1.createCell(34);
                        c.setCellValue(sln);
                        c.setCellStyle(cs);


                        c = row1.createCell(35);
                        c.setCellValue(nam);
                        c.setCellStyle(cs);


                        c = row1.createCell(36);
                        c.setCellValue(rth);
                        c.setCellStyle(cs);


                        c = row1.createCell(37);
                        c.setCellValue(dob);
                        c.setCellStyle(cs);


                        c = row1.createCell(38);
                        c.setCellValue(occ);
                        c.setCellStyle(cs);


                        c = row1.createCell(39);
                        c.setCellValue(gen);
                        c.setCellStyle(cs);


                        c = row1.createCell(40);
                        c.setCellValue(ms);
                        c.setCellStyle(cs);


                        c = row1.createCell(41);
                        c.setCellValue(edu);
                        c.setCellStyle(cs);


                        c = row1.createCell(42);
                        c.setCellValue(wei);
                        c.setCellStyle(cs);


                        c = row1.createCell(43);
                        c.setCellValue(hei);
                        c.setCellStyle(cs);


                        c = row1.createCell(44);
                        c.setCellValue(bm);
                        c.setCellStyle(cs);


                        c = row1.createCell(45);
                        c.setCellValue(sb);
                        c.setCellStyle(cs);


                        c = row1.createCell(46);
                        c.setCellValue(db);
                        c.setCellStyle(cs);


                        c = row1.createCell(47);
                        c.setCellValue(ci);
                        c.setCellStyle(cs);


                        c = row1.createCell(48);
                        c.setCellValue(smo);
                        c.setCellStyle(cs);


                        c = row1.createCell(49);
                        c.setCellValue(alc);
                        c.setCellStyle(cs);


                        c = row1.createCell(50);
                        c.setCellValue(an);
                        c.setCellStyle(cs);


                        c = row1.createCell(51);
                        c.setCellValue(ui);
                        c.setCellStyle(cs);
























                    }


                    sheet1.setColumnWidth(0, (15 * 500));
                    sheet1.setColumnWidth(1, (15 * 500));
                    sheet1.setColumnWidth(2, (15 * 500));

                    // Create a path where we will place our List of objects on external storage
                    // File file = new File(context.getExternalFilesDir(null), fileName);


                    FileOutputStream os = null;

                    try {
                        File f = new File("/sdcard/Healthcare/");
                        if (!f.exists())
                            f.mkdir();
                        File file = new File(Environment.getExternalStorageDirectory(), "Healthcare/healtcare.xls");
                        if (!file.exists()) {
                            file.createNewFile();
                        }


                        os = new FileOutputStream(file);
                        wb.write(os);
                        Log.w("FileUtils", "Writing file" + file);
                        //success = true;
                    } catch (IOException e) {
                        //  Log.w("FileUtils", "Error writing " +file, e);
                    } catch (Exception e) {
                        Log.w("FileUtils", "Failed to save file", e);
                    } finally {
                        try {
                            if (null != os)
                                os.close();
                        } catch (Exception ex) {
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } catch (SQLiteException se) {

            }
            return null;

        }
    }

    class loginAccess3 extends AsyncTask<String, String, String> {
        private static final String TAG_PRODUCTS = "products";
        private static final String TAG_USER = "username";
        private static final String TAG_PASS = "password";
        // products JSONArray
        // static JSONArray products = null;
        String god = "final";


        EditText et1;

        private static final String LOG_TAG = "GeneratePDF";


        JSONParser jsonParser = new JSONParser();
        String srt;
        int numrows;
        String url3 = "http://ffs.kongu.edu/document/document.php";
        private ProgressDialog pDialog;
        int flag;
        SQLiteDatabase db = null;
        String TAG_SUCCESS = "success";
        String TAG_SUCCESS1 = "message";
        String str1 = "login";
        String str2 = "pass";


        protected String doInBackground(String... arg0) {

            List<NameValuePair> params = new ArrayList<NameValuePair>();
            String god = "Healthcare";
            File f = new File("/sdcard/Healthcare/");
            if (!f.exists())
                f.mkdir();

            File file = new File(Environment.getExternalStorageDirectory(), "Healthcare/healtcare.docx");
            try {


                if (!file.exists()) {
                    file.createNewFile();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                //  File gpxfile = new File(file, god);
                FileWriter writer = new FileWriter(file);
                writer.append("Folder no");
                writer.append("\t");
                writer.append("\t");
                writer.append("Uid");
                writer.append("\n");


                try {
                    String str1 = "username";
                    String str2 = "rollno";
                    params.add(new BasicNameValuePair("spinner1",spinner1));
                    params.add(new BasicNameValuePair("spinner2",spinner2));
                    JSONObject json = jsonParser.makeHttpRequest(url3, "POST", params);
                    Log.d("Create Response", json.toString());
                    try {

                        int success = json.getInt(TAG_SUCCESS);
                        products = json.getJSONArray(TAG_PRODUCTS);
                        for (int i = 0, j = 1; i < products.length(); i++, j++) {


                            JSONObject d = products.getJSONObject(i);
                            String user = d.getString("ffno");
                            String pass2 = d.getString("uid");
                            writer.append(user);
                            writer.append("\t");
                            writer.append("\t");
                            writer.append("\t");
                            writer.append("\t");
                            writer.append(pass2);
                            writer.append("\n");

                        }
                        writer.flush();

                        writer.close();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } catch (SQLiteException se) {

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;

        }
    }


    class loginAccess extends AsyncTask<String, String, String> {
        // @Override

        private static final String TAG_PRODUCTS = "products";
        private static final String TAG_USER = "username";
        private static final String TAG_PASS = "password";
        // products JSONArray

        int log;
        JSONParser jsonParser = new JSONParser();
        String url = "http://ffs.kongu.edu/document/document.php";
        private ProgressDialog pDialog;
        int flag;
        SQLiteDatabase db = null;
        String TAG_SUCCESS = "success";
        String str1 = "login";
        String str2 = "pass";
        String god = "Healtcare";


        protected String doInBackground(String... arg0) {

            List<NameValuePair> params = new ArrayList<NameValuePair>();
            try {
                log = 1;
                params.add(new BasicNameValuePair("spinner1", spinner1));
                params.add(new BasicNameValuePair("spinner2", spinner2));
                JSONObject json = jsonParser.makeHttpRequest(url, "POST", params);
                Log.d("Create Response", json.toString());
                try {

                    int success = json.getInt(TAG_SUCCESS);
                    // String message=json.getString("name");
                    //  numrows=json.getInt("numrows");
                    //  String name=json.getString("message");
                    //  String rollno=json.getString("rollno");


                    try {
                        File f = new File("/sdcard/Healthcare/");
                        if (!f.exists())
                            f.mkdir();
                        File file = new File(Environment.getExternalStorageDirectory(), "Healthcare/healtcare.pdf");
                        if (!file.exists()) {
                            file.createNewFile();
                        }



                        Document document = new Document();

                        PdfWriter.getInstance(document, new FileOutputStream(file.getAbsoluteFile()));

                        document.open();
                        Paragraph title1 = new Paragraph("Chapter 1", FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLDITALIC, new CMYKColor(0, 255, 255, 17)));

                        Chapter chapter1 = new Chapter(title1, 1);

                        chapter1.setNumberDepth(0);
                        Paragraph title11 = new Paragraph("Report for Healthcare", FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLD, new CMYKColor(0, 255, 255, 17)));

                        Section section1 = chapter1.addSection(title11);

                        PdfPTable t = new PdfPTable(2);

                        t.setSpacingBefore(5);

                        t.setSpacingAfter(5);

                        products = json.getJSONArray(TAG_PRODUCTS);
                        Font font = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.WHITE);
                        // create header cell

                        PdfPCell c3 = new PdfPCell(new Phrase("Family_Folder_No",font));
                        c3.setBackgroundColor(new BaseColor(0,121,182));

                        // border
                        c3.setBorder(0);
                        c3.setBorderWidth(2f);

                        t.addCell(c3);

                        Font font3 = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.WHITE);
                        // create header cell

                        PdfPCell c4 = new PdfPCell(new Phrase("UID",font3));

                        c4.setBackgroundColor(new BaseColor(0,121,182));
                        // border
                        c4.setBorder(0);
                        c4.setBorderWidth(2f);



                        t.addCell(c4);



                        // looping through All Products
                        for (int i = 0; i < products.length(); i++) {
                            JSONObject c = products.getJSONObject(i);

                            // Storing each json item in variable
                            String ffno = c.getString("ffno");
                            String uid = c.getString("uid");
                            Font font1 = new Font(Font.FontFamily.HELVETICA, 8, Font.BOLD, BaseColor.DARK_GRAY);


                            PdfPCell c1 = new PdfPCell(new Phrase(ffno,font1));

                            t.addCell(c1);



                            PdfPCell c2 = new PdfPCell(new Phrase(uid));
                            t.addCell(c2);




                        }

                        section1.add(t);


                        document.add(section1);


                        document.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (DocumentException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                        // return false;
                    }
                    if (success == 1) {
                        flag = 0;

                    } else {

                        flag = 1;

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            } catch (SQLiteException se) {

            }
            return null;

        }


    }
}




