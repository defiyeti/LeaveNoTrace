package com.example.root.leavenotrace;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


public class PastUsage extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_past_usage);
        Drawable button_border = getResources().getDrawable(R.drawable.button_border);
        TextView testTest = new TextView(this);
        testTest.setBackground(button_border);
        testTest.setText("Date will be here");
        testTest.setPadding(5, 20, 5, 5);
        testTest.setTextColor(Color.BLACK);
        testTest.setTextSize(20);
        testTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), UpdatePastUsage.class);
                startActivity(intent);
            }
        });
        LinearLayout linear = (LinearLayout) findViewById(R.id.Linear);
        linear.addView(testTest);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_past_usage, menu);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Past Usage");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        return super.onOptionsItemSelected(item);
    }
}
