package com.medoc.medoc.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.medoc.medoc.R;
import com.medoc.medoc.adapters.HospitalsAdapter;
import com.medoc.medoc.models.Hospitals;
import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class HospitalsActivity extends AppCompatActivity {
    private ArrayList<Hospitals> hospitals;
    private HospitalsAdapter aHospitals;
    ListView lvHospitals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospitals);
        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "Abn28hlx5bcDwhsWGILEdCxiGIZLQFC2nNCxlTLp", "Syp24Ge1dTm9VmVYZJsJhh7AIEqRA3s6p9HrX9Gm");
        hospitals = new ArrayList<>();
        aHospitals = new HospitalsAdapter(this, hospitals);
        lvHospitals = (ListView) findViewById(R.id.lvHospitals);
        lvHospitals.setAdapter(aHospitals);
        hospitals();
    }

    public void hospitals() {
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Hospitals");
        query.whereEqualTo("country", "Haiti");
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> hospitalList, ParseException e) {
                if (e == null) {
                    Hospitals hospital = new Hospitals();
                    String name = hospitalList.toString();
                    Log.d("hospital", "Retrieved " + hospitalList.size() + " hospitals");
                    Log.d("THE QUERY ", "" + name);
                    for (ParseObject hospitalObject : hospitalList) {
                        // use hospitalObject.get('columnName') to access the properties of the Hospitals object.
                        hospital.hospital_name = hospitalObject.getString("hospital_name");
                        TextView tvTest = (TextView) findViewById(R.id.tvTest);
                        tvTest.setText(hospital.hospital_name);
                        //hospital.hospital_adress = hospitalObject.getString("hospital_adress");
                        //hospital.hospital_number = hospitalObject.getInt("hospital_number");
                        Toast.makeText(getApplicationContext(), "hehehehehe", Toast.LENGTH_LONG).show();
                        Toast.makeText(getApplicationContext(), hospital.hospital_name , Toast.LENGTH_LONG).show();
                        hospitals.add(hospital);
                    }
                    }else{
                        Log.d("hospital", "Error: " + e.getMessage());
                    }
                }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hospitals, menu);
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
}
