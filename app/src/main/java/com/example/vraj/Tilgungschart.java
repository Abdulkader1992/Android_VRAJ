package com.example.vraj;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.data.Entry;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Tilgungschart extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) { // Für die Erstellung des Charts hab ich dieses Tutorial verwendet: https://www.youtube.com/watch?v=Bd76zMHdrDE

        BarChart mpBarChart;


        super.onCreate( savedInstanceState );
        setContentView( R.layout.tilgungschart );

         mpBarChart = findViewById( R.id.bar_chart );


        Intent tilgungschartintent = getIntent();
        Bundle restschuldbundle = getIntent().getBundleExtra( "Restschuldbundle" );
        Bundle zinsenbundle = getIntent().getBundleExtra( "Zinsenbundle" );
        Bundle tilgungsbundle = getIntent().getBundleExtra( "Tilgungbundle" );
        Bundle annuitatsbundle = getIntent().getBundleExtra( "Annuitatbundle" );


        int kreditlaufzeit = tilgungschartintent.getIntExtra("Kreditlaufzeit", 1);
        double restschuld[] = restschuldbundle.getDoubleArray("Restschuld");
        double zinsen[] = zinsenbundle.getDoubleArray("Zinsen");
        double tilgung[] = tilgungsbundle.getDoubleArray("Tilgung");
        double annuitatsrate[] = annuitatsbundle.getDoubleArray("Annuitat");
        String addjahre[] = new String[kreditlaufzeit];




        Log.d("Restschuld", String.valueOf( restschuld[0] ));
        Log.d("Zinsen", String.valueOf( zinsen[0] ));
        Log.d("Tilgung", String.valueOf( tilgung[0] ));
        Log.d("Annuität", String.valueOf( annuitatsrate[0] ));


        BarDataSet barDataSet1 = new BarDataSet( barEntries1(restschuld, kreditlaufzeit), "Restschuld" );
        barDataSet1.setColor( Color.BLUE );

        BarDataSet barDataSet2 = new BarDataSet( barEntries2(zinsen, kreditlaufzeit), "Zinsen" );
        barDataSet2.setColor( Color.MAGENTA );

        BarDataSet barDataSet3 = new BarDataSet( barEntries3(tilgung, kreditlaufzeit), "Tilgung" );
        barDataSet3.setColor( Color.GREEN );

        BarDataSet barDataSet4 = new BarDataSet( barEntries4(annuitatsrate, kreditlaufzeit), "Annuitätsrate" );
        barDataSet4.setColor( Color.RED );

        BarData data = new BarData( barDataSet1, barDataSet4, barDataSet3, barDataSet2 );
        mpBarChart.setData( data );

        String[] jahre = new String[]{"1 Jahr", "2 Jahr", "3 Jahr", "4 Jahr", "5 Jahr", "6 Jahr", "7 Jahr"};

        for(int i = 0; i <= kreditlaufzeit - 1; i++) {
            addjahre[i] = jahre[i];
        }


        XAxis xAxis = mpBarChart.getXAxis();
        xAxis.setValueFormatter( new IndexAxisValueFormatter( addjahre ) );
        xAxis.setCenterAxisLabels( true );
        xAxis.setPosition( XAxis.XAxisPosition.BOTTOM );
        xAxis.setGranularity( 1 );
        xAxis.setGranularityEnabled( true );




        mpBarChart.setDragEnabled( true );
        mpBarChart.setVisibleXRangeMaximum( 3 );

        float barSpace = 0.0f;
        float groupSpace = 0.22f;
        data.setBarWidth( 0.20f );

        mpBarChart.getXAxis().setAxisMinimum( 0 );
        mpBarChart.getXAxis().setAxisMaximum( 0 + mpBarChart.getBarData().getGroupWidth( groupSpace, barSpace ) * kreditlaufzeit );
        mpBarChart.getAxisLeft().setAxisMinimum( 0 );

        mpBarChart.groupBars( 0, groupSpace, barSpace );

        mpBarChart.invalidate();
    }

    private ArrayList<BarEntry> barEntries1(double restschuldparameter[], int kreditlaufzeitparameter) {
        ArrayList<BarEntry> barEntries = new ArrayList<>();

        for(int i = kreditlaufzeitparameter - 1; i >= 0; i--){
            barEntries.add( new BarEntry( i, (float)restschuldparameter[i] ) );
        }
        return barEntries;
    }

    private ArrayList<BarEntry> barEntries2(double zinsenparameter[], int kreditlaufzeitparameter) {
        ArrayList<BarEntry> barEntries = new ArrayList<>();
        for(int i = kreditlaufzeitparameter - 1; i >= 0; i--){
            barEntries.add( new BarEntry( i, (float) zinsenparameter[i] ) );
        }
        return barEntries;
    }

    private ArrayList<BarEntry> barEntries3(double tilgungsparameter[], int kreditlaufzeitparameter) {
        ArrayList<BarEntry> barEntries = new ArrayList<>();
        for(int i = kreditlaufzeitparameter - 1; i >= 0; i--){
            barEntries.add( new BarEntry( i, (float) tilgungsparameter[i] ) );
        }
        return barEntries;
    }

    private ArrayList<BarEntry> barEntries4(double annuitatsparameter[], int kreditlaufzeitparameter) {
        ArrayList<BarEntry> barEntries = new ArrayList<>();
        for(int i = kreditlaufzeitparameter - 1; i >= 0; i--){
            barEntries.add( new BarEntry( i, (float) annuitatsparameter[i] ) );
        }
        return barEntries;
    }


    }
