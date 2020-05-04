package com.familyfolder.vaideeswaran.healthcare;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import org.apache.poi.hssf.util.HSSFColor;

import java.util.ArrayList;

/**
 * Created by VAIDEESWARAN on 05-04-2016.
 */
public class Sexratio extends AppCompatActivity {
    private PieChart mchart;
    private RelativeLayout mainLayout;
int child,student,employed;
// private int[] yData=new int[10];
    private int[] yData=new int[2];
    private String[] xData={"Male","Female"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sexratio);
       Bundle extras = getIntent().getExtras();
         child = extras.getInt("child");
        student= extras.getInt("student");
       // String ch=getString(child);
       // String st=getString(student);
       // Toast.makeText(getApplicationContext(),ch,Toast.LENGTH_LONG).show();

       // Toast.makeText(getApplicationContext(),st,Toast.LENGTH_LONG).show();

     //   employed = extras.getInt("employed");
        yData[0]=child;
        yData[1]=student;
      //  yData[2]=employed;
      //  Toast.makeText(getApplicationContext(),child+"",Toast.LENGTH_LONG).show();

       // Toast.makeText(getApplicationContext(),student+"",Toast.LENGTH_LONG).show();
       // Toast.makeText(getApplicationContext(),employed+"",Toast.LENGTH_LONG).show();

       /*yData[0]=child;
        yData[1]=student;
        yData[2]=employed;*/

        //int child=10,student=10,employed=10;




        mainLayout=(RelativeLayout)findViewById(R.id.mainLayout);
        mchart= new PieChart(this);

        // mainLayout.addView(mchart);
        mainLayout.setBackgroundColor(Color.BLACK);
       // mainLayout.setTextAlignment(23);
        mchart.setUsePercentValues(true);
       // mchart.setDescription("smart phone");
        mchart.setCenterTextColor(Color.WHITE);
        //mchart.setBackgroundColor(Color.BLUE);
        mchart.setDrawHoleEnabled(true);
        mchart.setHoleRadius(7);
        mchart.setTransparentCircleRadius(10);
        mchart.setRotationAngle(0);
        mchart.setRotationEnabled(true);
        mchart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry entry, int i, Highlight highlight) {
                if (entry == null) {
                    return;
                }
            }

            @Override
            public void onNothingSelected() {

            }
        });
        addData();
        Legend l=mchart.getLegend();
        l.setPosition(Legend.LegendPosition.BELOW_CHART_LEFT);
        l.setTextColor(Color.WHITE);
        l.setTextSize(13f);
        l.setXEntrySpace(7);
        l.setYEntrySpace(5);


    }
    private void addData()
    {
        ArrayList<Entry> yVals1=new ArrayList<Entry>();
        for(int i=0;i<yData.length;i++)
        {
            yVals1.add(new Entry(yData[i],i));


        }

        ArrayList<String> xVals = new ArrayList<String>();
        for (int i =0; i<xData.length; i++)
            xVals.add(xData[i]);

        PieDataSet dataset=new PieDataSet(yVals1,"");
        dataset.setSliceSpace(3);
        dataset.setSelectionShift(5);
        ArrayList<Integer> colors=new ArrayList<Integer>();
      /*  for (int c : ColorTemplate.VORDIPLOM_COLORS)
            colors.add(c);*/
        for (int c : ColorTemplate.JOYFUL_COLORS)
            colors.add(c);

      /*  for (int c : ColorTemplate.COLORFUL_COLORS)
            colors.add(c);
*/
        for (int c : ColorTemplate.LIBERTY_COLORS)
            colors.add(c);

      /*  for (int c : ColorTemplate.PASTEL_COLORS)
            colors.add(c);*/

        colors.add(ColorTemplate.getHoloBlue());
        dataset.setColors(colors);



        PieData data = new PieData(xVals,dataset);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(12f);
        data.setValueTextColor(Color.BLACK);

        mchart.setData(data);
        mainLayout.addView(mchart,900,700);

        mchart.highlightValues(null);

        mchart.invalidate();


    }
}
