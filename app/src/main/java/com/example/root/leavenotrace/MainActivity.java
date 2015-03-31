package com.example.root.leavenotrace;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.TextureView;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setPersonalMetrics();
        setLocalMetrics();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
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
}
