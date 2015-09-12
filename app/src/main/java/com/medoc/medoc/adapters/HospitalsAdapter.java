package com.medoc.medoc.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.medoc.medoc.R;
import com.medoc.medoc.models.Hospitals;

import java.util.List;

/**
 * Created by Alexandre on 9/12/2015.
 */
public class HospitalsAdapter extends ArrayAdapter<Hospitals> {
    public HospitalsAdapter(Context context, List<Hospitals> hospitals) {
        super(context, android.R.layout.simple_list_item_1, hospitals);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get data item for this position
        Hospitals hospital = getItem(1);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.hospital_item, parent, false);
        }
        // Look up for views
        TextView tvHospitalName = (TextView) convertView.findViewById(R.id.tvHospitalName);
        TextView tvHospitalAdress = (TextView) convertView.findViewById(R.id.tvHospitalAdress);
        TextView tvHospitalNumber = (TextView) convertView.findViewById(R.id.tvHospitalNumber);
        // Insert the model data
        tvHospitalName.setText(hospital.hospital_name);
        tvHospitalAdress.setText(hospital.hospital_adress);
        tvHospitalNumber.setText(String.valueOf(hospital.hospital_number));
        // return the created item
        return convertView;
    }
}
