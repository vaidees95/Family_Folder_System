package com.familyfolder.vaideeswaran.healthcare;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
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

/**
 * Created by VAIDEESWARAN on 27-03-2016.
 */
public class Income extends AppCompatActivity {
    LinearLayout lout;
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.income);
        lout = (LinearLayout) findViewById(R.id.lout);

        Bundle extras = getIntent().getExtras();
        int child = extras.getInt("child");
        int student = extras.getInt("student");

        int employed = extras.getInt("employed");
            int unemployed = extras.getInt("unemployed");
        int k=0;


        //  Toast.makeText(this,num+"",Toast.LENGTH_LONG).show();

        int y[] = {child,student,employed,unemployed};

        CategorySeries series = new CategorySeries("Income");
        for (int i = 0; i < y.length; i++) {

            series.add("Bar" + (i + 1),y[i]);

        }
        int color[]={Color.RED,Color.BLUE,Color.GREEN,Color.CYAN,Color.GRAY};


        XYMultipleSeriesDataset dataSet = new XYMultipleSeriesDataset();  // collection of series under one object.,there could any
        dataSet.addSeries(series.toXYSeries());                            // number of series


        //customization of the chart

        XYSeriesRenderer renderer = new XYSeriesRenderer();     // one renderer for one series
        renderer.setColor(Color.YELLOW);

        renderer.setDisplayChartValues(true);
        renderer.setChartValuesSpacing((float) 5.5d);
        renderer.setLineWidth((float) 10.5d);
        renderer.setChartValuesTextSize(20);




        XYMultipleSeriesRenderer mRenderer = new XYMultipleSeriesRenderer();   // collection multiple values for one renderer or series
        mRenderer.addSeriesRenderer(renderer);

        mRenderer.setChartTitle("Annual Income");

        mRenderer.setChartTitleTextSize(40);
//        mRenderer.setXTitle("xValues");
        mRenderer.setYTitle("Rupee");

            mRenderer.setAxisTitleTextSize(30);

            mRenderer.setLabelsTextSize(30);
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
            mRenderer.setLabelsTextSize(30);

            mRenderer.addXTextLabel(1, "1L-3L");

        mRenderer.addXTextLabel(2, "3L-6L");
        mRenderer.addXTextLabel(3, "6L-9L");
            mRenderer.addXTextLabel(4, "Above-9L");
        mRenderer.setPanEnabled(true, true);    // will fix the chart position
        View chartview = (GraphicalView) ChartFactory.getBarChartView(getBaseContext(), dataSet, mRenderer, BarChart.Type.DEFAULT);
        lout.addView(chartview);
        lout.setDrawingCacheEnabled(true);
        Bitmap bitmap = lout.getDrawingCache();
        if (bitmap == null) {
          //  Toast.makeText(this, "not fount", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, " fount", Toast.LENGTH_LONG).show();

        }
        File file = null, f = null;
        String image = "chart";
        String fpath = "/sdcard/" + image + ".png";
        if (android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED)) {
            file = new File(fpath);
            if (!file.exists()) {
                try {
                    file.mkdir();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
            f = new File(file.getAbsolutePath() + file.separator + "app" + ".jpeg");
        }
        try {
            FileOutputStream ostream = new FileOutputStream(f);
            //bitmap.compress(Bitmap.CompressFormat.PNG, 10, ostream);
            ostream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
