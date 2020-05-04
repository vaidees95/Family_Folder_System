package com.familyfolder.vaideeswaran.healthcare;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.BarChart;
import org.achartengine.model.CategorySeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import java.io.File;
import java.io.FileOutputStream;

public class Age extends AppCompatActivity {
    LinearLayout lout;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.age);

        lout = (LinearLayout) findViewById(R.id.lout);

        Bundle extras = getIntent().getExtras();
        int child = extras.getInt("child");
        int student = extras.getInt("student");

        int employed = extras.getInt("employed");


        //  Toast.makeText(this,num+"",Toast.LENGTH_LONG).show();

        int y[] = {child,student,employed};

        CategorySeries series = new CategorySeries("Age");
        for (int i = 0; i < y.length; i++) {
            series.add("Bar" + (i + 1), y[i]);
        }
        XYMultipleSeriesDataset dataSet = new XYMultipleSeriesDataset();  // collection of series under one object.,there could any
        dataSet.addSeries(series.toXYSeries());                            // number of series

        //customization of the chart

        XYSeriesRenderer renderer = new XYSeriesRenderer();     // one renderer for one series
        renderer.setColor(Color.YELLOW);
        renderer.setDisplayChartValues(true);
        renderer.setChartValuesSpacing((float) 10d);
        renderer.setLineWidth((float) 10.5d);
        renderer.setChartValuesTextSize(20);
        renderer.setChartValuesTextAlign(Paint.Align.CENTER);


        XYMultipleSeriesRenderer mRenderer = new XYMultipleSeriesRenderer();   // collection multiple values for one renderer or series
        mRenderer.addSeriesRenderer(renderer);
        mRenderer.setChartTitle("AGE REPORT");
        mRenderer.setChartTitleTextSize(40);

//        mRenderer.setXTitle("xValues");
        mRenderer.setYTitle("Total Numbers");
        mRenderer.setAxisTitleTextSize(20);
        mRenderer.setZoomButtonsVisible(true);
        mRenderer.setShowLegend(true);
        mRenderer.setShowGridX(true);      // this will show the grid in  graph
        mRenderer.setShowGridY(true);
//        mRenderer.setAntialiasing(true);
        mRenderer.setBarSpacing(.5);   // adding spacing between the line or stacks
        mRenderer.setApplyBackgroundColor(true);
        mRenderer.setBackgroundColor(Color.BLACK);
        mRenderer.setXAxisMin(0);
//        mRenderer.setYAxisMin(.5);
        mRenderer.setXAxisMax(5);
        mRenderer.setYAxisMax(50);
//
        mRenderer.setXLabels(0);
        mRenderer.setLabelsTextSize(20);
        mRenderer.addXTextLabel(1, "0-18");

        mRenderer.addXTextLabel(2, "18-50");
        mRenderer.addXTextLabel(3, " Above 50");
        mRenderer.setPanEnabled(true, true);    // will fix the chart position
        View chartview = (GraphicalView) ChartFactory.getBarChartView(getBaseContext(), dataSet, mRenderer, BarChart.Type.DEFAULT);
        lout.addView(chartview);
        lout.setDrawingCacheEnabled(true);
        lout.buildDrawingCache(true);
        Bitmap bitmap = lout.getDrawingCache();
        if (bitmap == null) {
           // Toast.makeText(this, "not fount", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, " fount", Toast.LENGTH_LONG).show();

        }
        File file = null, f = null;
        String image = "chart";
        String fpath = "/sdcard/" + image;
        if (android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED)) {
            file = new File(fpath);
            if (!file.exists()) {
                try {
                    file.mkdir();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
            f = new File(file.getAbsolutePath() + file.separator + "app" + ".png");
        }
        try {
            FileOutputStream ostream = new FileOutputStream(f);

            bitmap.compress(Bitmap.CompressFormat.PNG, 10, ostream);
            ostream.close();
        } catch (Exception e) {
           // Toast.makeText(getApplicationContext(),"cannot create jpg",Toast.LENGTH_LONG).show();
        }
    }
}
