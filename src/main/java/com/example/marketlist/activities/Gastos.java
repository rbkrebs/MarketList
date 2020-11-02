package com.example.marketlist.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.example.marketlist.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class Gastos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gastos);

        PieChart pieChart = findViewById(R.id.pieChart);

        ArrayList<PieEntry> meses = new ArrayList();
        meses.add(new PieEntry(500, "Janeiro"));
        meses.add(new PieEntry(600, "Fevereiro"));
        meses.add(new PieEntry(450, "Março"));
        meses.add(new PieEntry(300, "Abril"));
        meses.add(new PieEntry(520, "Maio"));
        meses.add(new PieEntry(500, "Junho"));
        meses.add(new PieEntry(490, "Julho"));

        PieDataSet pieDataSet = new PieDataSet(meses, "Meses");
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet.setValueTextColor(Color.BLACK);
        pieDataSet.setValueTextSize(16f);

        PieData pieData = new PieData(pieDataSet);

        pieChart.setData(pieData);
        pieChart.getDescription().setEnabled(false);
        pieChart.setCenterText("Gastos Mensais");
        pieChart.animate();
    }
}