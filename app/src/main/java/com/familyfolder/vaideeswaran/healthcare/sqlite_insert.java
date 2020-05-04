package com.familyfolder.vaideeswaran.healthcare;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by VAIDEESWARAN on 14-04-2016.
 */
public class sqlite_insert extends AppCompatActivity {
    EditText et1;
    Button bt;
    EditText et2;
    SQLiteDatabase db;
    String str1;
    String str2;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqlite_insert);
        et1 = (EditText) findViewById(R.id.editText18);
        et2 = (EditText) findViewById(R.id.editText21);
        bt= (Button) findViewById(R.id.button13);
        // str1 = et1.getText().toString();
         //str2 = et2.getText().toString();
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String dist1 = "erode";
                    String taluk11="erode";
                    String taluk12="bhavani";
                    String dist2 = "coimbatore";
                    String taluk21="mettupalayam";
                    String taluk22="annur";

                    db = openOrCreateDatabase("place3", MODE_PRIVATE, null);
                    db.execSQL("delete from place1");
                    db.execSQL("CREATE TABLE IF NOT EXISTS place1 (dist VARCHAR,taluk VARCHAR)");
                    db.execSQL("INSERT INTO place1 values ('"+dist1+"','"+taluk11+"')");
                    db.execSQL("INSERT INTO place1 values ('"+dist1+"','"+taluk12+"')");
                    db.execSQL("INSERT INTO place1 values ('"+dist2+"','"+taluk21+"')");
                    db.execSQL("INSERT INTO place1 values ('"+dist2+"','"+taluk22+"')");

                    //Toast.makeText(getApplicationContext(),str1,Toast.LENGTH_LONG).show();
                    Intent i = new Intent(getApplicationContext(), try_spinner.class);
                    startActivity(i);

                } catch (SQLException e) {
                    Toast.makeText(getApplicationContext(), "not inserted", Toast.LENGTH_LONG).show();
                }


            }
        });
          }
}
