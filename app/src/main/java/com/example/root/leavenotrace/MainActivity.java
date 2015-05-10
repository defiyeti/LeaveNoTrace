package com.example.root.leavenotrace;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import org.w3c.dom.Text;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setPersonalMetrics();
        setLocalMetrics();
        GraphView graph = (GraphView) findViewById(R.id.graph);
        GraphView graph1 = (GraphView) findViewById(R.id.graph2);
        GraphView graph2 = (GraphView) findViewById(R.id.graph3);
        GraphView graph3 = (GraphView) findViewById(R.id.graph4);
        setGraphProperties(graph);
        setGraphProperties(graph1);
        setGraphProperties(graph2);
        setGraphProperties(graph3);
        Connection con = new Connection();
    }

    private void setGraphProperties(GraphView graph) {
        graph.getGridLabelRenderer().setGridStyle(GridLabelRenderer.GridStyle.NONE);
        graph.getGridLabelRenderer().setHorizontalLabelsVisible(false);
        graph.getGridLabelRenderer().setVerticalLabelsVisible(false);
        LineGraphSeries<DataPoint> series1 = new LineGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(0, 5),
                new DataPoint(2, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 0),
                new DataPoint(4, 2)
        });
        LineGraphSeries<DataPoint> series2 = new LineGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(0, 0),
                new DataPoint(1, 0),
                new DataPoint(2, 3),
                new DataPoint(3, 5),
                new DataPoint(4, 2)
        });
        series1.setColor(Color.BLACK);
        series2.setColor(Color.GRAY);
        graph.addSeries(series1);
        graph.addSeries(series2);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Your Usage");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_search) {
            Intent intent = new Intent(this, AddNewData.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    //Sets the string value of personal metrics based on data fetched from login
    public void setPersonalMetrics() {
        TextView personalCO = (TextView)findViewById(R.id.personalCO);
        TextView personalWater = (TextView)findViewById(R.id.personalWater);
        TextView personalElectricity = (TextView)findViewById(R.id.personalElectricity);
        TextView personalNaturalGas = (TextView)findViewById(R.id.personalNaturalGas);

        //Fetch int values of personal metrics (default = 0)
        int personalCOUsage = 0;
        int personalWaterUsage = 0;
        int personalElectricityUsage = 0;
        int personalNaturalGasUsage = 0;

        //Set values
        personalCO.setText(personalCOUsage + " Tons CO2 eq/yr");
        personalWater.setText(personalWaterUsage + " Thousand Gallons This Month");
        personalElectricity.setText(personalElectricityUsage + " kW/hr This Month");
        personalNaturalGas.setText(personalNaturalGasUsage + " CCF This Month");
    }

    //Sets the string value of local metrics based on data fetched from account zipcode
    public void setLocalMetrics() {
        TextView localCO = (TextView)findViewById(R.id.localCO);
        TextView localWater = (TextView)findViewById(R.id.localWater);
        TextView localElectricity = (TextView)findViewById(R.id.localElectricity);
        TextView localNaturalGas = (TextView)findViewById(R.id.localNaturalGas);
        TextView localRank = (TextView)findViewById(R.id.localRank);

        //Fetch int values of local metrics (default = 0)
        int localCOUsage = 0;
        int localWaterUsage = 0;
        int localElectricityUsage = 0;
        int localNaturalGasUsage = 0;
        int localPercentile = 0;

        //Set values
        localCO.setText(localCOUsage + " Tons CO2 eq/yr");
        localWater.setText(localWaterUsage + " Thousand Gallons This Month");
        localElectricity.setText(localElectricityUsage + " kW/hr This Month");
        localNaturalGas.setText(localNaturalGasUsage + " CCF This Month");

        if ((localPercentile % 10) == 1) {
            localRank.setText("You rank in the "+ localPercentile +"st percentile of your zip code for lowest carbon footprint this month!");
        }
        else if ((localPercentile % 10) == 2) {
            localRank.setText("You rank in the "+ localPercentile +"nd percentile of your zip code for lowest carbon footprint this month!");
        }
        else if ((localPercentile % 10) == 3) {
            localRank.setText("You rank in the "+ localPercentile +"rd percentile of your zip code for lowest carbon footprint this month!");
        }
        else {
            localRank.setText("You rank in the "+ localPercentile +"th percentile of your zip code for lowest carbon footprint this month!");
        }
    }

    //Set graphs of personal metrics overtime based on past consumption and usage
    public void setPersonalMetricGraphs () {

    }

    public void accountSettings(View view) {
        Intent intent = new Intent(this, AccountSettings.class);
        startActivity(intent);
    }
}
