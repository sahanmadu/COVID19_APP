package com.example.covid19app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CitizenListAdapter extends ArrayAdapter<Citizen> {

    private List<Citizen> citizens;
    private  Context context;


    public CitizenListAdapter(List<Citizen> citizens, Context context) {
        super(context, R.layout.citizen_layout, citizens);
        this.citizens=citizens;
        this.context=context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.citizen_layout, parent, false);
        Citizen citizen = this.citizens.get(position);
        TextView textView1=(TextView) view.findViewById(R.id.txtTxt1);
        textView1.setText(citizen.getNid());

        TextView textView2=(TextView) view.findViewById(R.id.txtTxt2);
        textView1.setText(citizen.getFname());

        TextView textView3=(TextView) view.findViewById(R.id.txtTxt3);
        textView1.setText(citizen.getEmail());


        TextView textView4=(TextView) view.findViewById(R.id.txtTxt4);
        textView1.setText(citizen.getAge());

        return  view;

    }
}
