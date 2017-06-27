package com.example.rajshri.myexpensemanager;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

public class SpendAreasActivity extends AppCompatActivity {

    ImageView imgBack;
    Context mContext;

    PieChart pieChart ;
    ArrayList<PieEntry> entries ;
    ArrayList<String> PieEntryLabels ;
    PieDataSet pieDataSet ;
    PieData pieData ;

    private RecyclerView recyclerView;
    private SpendAreasAdapter mAdapter;
    LinearLayout layoutCell;

    ArrayList<ModelSpendAreas> modelSpendAreasArrayList = new ArrayList<ModelSpendAreas>();

    public static final int[] CUSTOM_COLORS = {
            Color.rgb(157, 206, 220), Color.rgb(249, 86, 106), Color.rgb(208, 199, 85),
            Color.rgb(223, 137, 86), Color.rgb(68, 180, 68)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spend_areas);

        mContext = this;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        ab.setDisplayShowTitleEnabled(false);

        imgBack = (ImageView)findViewById(R.id.img_back);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        pieChart = (PieChart) findViewById(R.id.piechart);
        entries = new ArrayList<>();
        PieEntryLabels = new ArrayList<>();
        AddValuesToPIEENTRY();
        //AddValuesToPieEntryLabels();
        pieDataSet = new PieDataSet(entries, "");
        pieData = new PieData(pieDataSet);
        pieDataSet.setColors(CUSTOM_COLORS);
        pieChart.setData(pieData);
        pieChart.animateY(3000);
        pieChart.setHoleRadius(75);
        pieChart.setDescription(null);
        pieData.setDrawValues(false);
        pieChart.getLegend().setEnabled(false);
        pieChart.setCenterText(" Spend \n"+"\u20B9" + " 1,546");
        pieChart.setCenterTextSize(20);
        pieChart.invalidate();

        ModelSpendAreas modelSpendAreas1 = new ModelSpendAreas("","Transport",""+"\u20B9"+" 600","FFA059","38.81%");
        modelSpendAreasArrayList.add(0,modelSpendAreas1);

        ModelSpendAreas modelSpendAreas2 = new ModelSpendAreas("","Dining",""+"\u20B9"+" 430","#4CB046","27.81%");
        modelSpendAreasArrayList.add(1,modelSpendAreas2);

        ModelSpendAreas modelSpendAreas3 = new ModelSpendAreas("","Online Transfer",""+"\u20B9"+" 253","#95D0DA","16.36%");
        modelSpendAreasArrayList.add(2,modelSpendAreas3);

        ModelSpendAreas modelSpendAreas4 = new ModelSpendAreas("","Shopping",""+"\u20B9"+" 160","FF167F","10.35%");
        modelSpendAreasArrayList.add(3,modelSpendAreas4);

        ModelSpendAreas modelSpendAreas5 = new ModelSpendAreas("","Prepaid Wallet",""+"\u20B9"+" 103","BDCE40","6.66%");
        modelSpendAreasArrayList.add(4,modelSpendAreas5);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_spend_areas);

        mAdapter = new SpendAreasAdapter(mContext, modelSpendAreasArrayList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
    }

    public void AddValuesToPIEENTRY(){
        entries.add(new PieEntry(1.5f, 0));
        entries.add(new PieEntry(2f, 1));
        entries.add(new PieEntry(1f, 2));
        entries.add(new PieEntry(5f, 3));
        entries.add(new PieEntry(4f, 4));
        entries.add(new PieEntry(1.5f, 5));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_spend, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.mnu_help:
                Toast.makeText(mContext,"Help Action",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
