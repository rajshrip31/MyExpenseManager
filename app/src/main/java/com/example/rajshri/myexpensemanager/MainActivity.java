package com.example.rajshri.myexpensemanager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.github.amlcurran.showcaseview.OnShowcaseEventListener;
import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.ViewTarget;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements OnShowcaseEventListener {

    ImageView imgBack;
    Context mContext;
    private FloatingActionButton fab;
    TextView txtMarkAsRead;

    private RecyclerView recyclerView;
    private BillsAndEmisAdapter mAdapter;
    ArrayList<ModelBillAndEmis> modelBillAndEmisArrayList = new ArrayList<ModelBillAndEmis>();
    LinearLayout layoutCell;

    ShowcaseView sv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SpendAreasActivity.class);
                startActivity(intent);
            }
        });

        RelativeLayout.LayoutParams lps = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lps.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        lps.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        int margin = ((Number) (getResources().getDisplayMetrics().density * 12)).intValue();
        lps.setMargins(margin, margin, margin, margin);

        ViewTarget target = new ViewTarget(R.id.fab, this);
        sv = new ShowcaseView.Builder(this)
                .withMaterialShowcase()
                .setTarget(target)
                .setContentTitle("Welcome")
                .setContentText("Press Plus button for next Screen")
                .setStyle(R.style.CustomShowcaseTheme2)
                .setShowcaseEventListener(this)
                .replaceEndButton(R.layout.view_custom_button)
                .build();
        sv.setButtonPosition(lps);

        layoutCell = (LinearLayout)findViewById(R.id.layout_cell);

        ModelBillAndEmis modelBillAndEmis1 = new ModelBillAndEmis("ICICI Credit Card","x9005",""+"\u20B9"+" 0","Paid on: 31 Mar");
        modelBillAndEmisArrayList.add(0,modelBillAndEmis1);

        ModelBillAndEmis modelBillAndEmis2 = new ModelBillAndEmis("SBI Credit Card","x6023",""+"\u20B9"+" 4,592","Paid on: 06 Apr");
        modelBillAndEmisArrayList.add(1,modelBillAndEmis2);

        ModelBillAndEmis modelBillAndEmis3 = new ModelBillAndEmis("HDFC Credit Card","x3256",""+"\u20B9"+" 3638","Paid on: 02 Apr");
        modelBillAndEmisArrayList.add(2,modelBillAndEmis3);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_bills);

        mAdapter = new BillsAndEmisAdapter(mContext, modelBillAndEmisArrayList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        txtMarkAsRead = (TextView)findViewById(R.id.txt_mark_as_read);
        txtMarkAsRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                layoutCell.setVisibility(View.GONE);

                modelBillAndEmisArrayList.clear();

                Calendar c = Calendar.getInstance();
                System.out.println("Current time => " + c.getTime());

                SimpleDateFormat df = new SimpleDateFormat("dd MMM");
                String formattedDate = df.format(c.getTime());

                ModelBillAndEmis modelBillAndEmis = new ModelBillAndEmis("रिलायंस","x241882",""+"\u20B9"+" 674","Paid on: "+formattedDate);
                modelBillAndEmisArrayList.add(0,modelBillAndEmis);

                ModelBillAndEmis modelBillAndEmis1 = new ModelBillAndEmis("ICICI Credit Card","x9005",""+"\u20B9"+" 0","Paid on: 31 Mar");
                modelBillAndEmisArrayList.add(1,modelBillAndEmis1);

                ModelBillAndEmis modelBillAndEmis2 = new ModelBillAndEmis("SBI Credit Card","x6023",""+"\u20B9"+" 4,592","Paid on: 06 Apr");
                modelBillAndEmisArrayList.add(2,modelBillAndEmis2);

                ModelBillAndEmis modelBillAndEmis3 = new ModelBillAndEmis("HDFC Credit Card","x3256",""+"\u20B9"+" 3638","Paid on: 02 Apr");
                modelBillAndEmisArrayList.add(3,modelBillAndEmis3);

                mAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mnu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.mnu_settings:
                Toast.makeText(mContext,"Settings Action",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.mnu_help:
                Toast.makeText(mContext,"Help Action",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onShowcaseViewHide(ShowcaseView showcaseView) {

    }

    @Override
    public void onShowcaseViewDidHide(ShowcaseView showcaseView) {

    }

    @Override
    public void onShowcaseViewShow(ShowcaseView showcaseView) {

    }

    @Override
    public void onShowcaseViewTouchBlocked(MotionEvent motionEvent) {

    }
}
