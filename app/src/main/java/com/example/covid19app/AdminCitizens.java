package com.example.covid19app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class AdminCitizens extends AppCompatActivity {

    private ListView listViewCitizens1;

    private Button buttonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_admin_citizens);
            List<Citizen> citizens=new HttpRequestCitizenList().execute().get();
            listViewCitizens1=findViewById(R.id.listViewCitizens);
            listViewCitizens1.setAdapter(new CitizenListAdapter(citizens, getApplicationContext()));

            buttonAdd =(Button) findViewById(R.id.btnAdd );
            buttonAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent =new Intent(AdminCitizens.this,AddCitizens.class);
                    startActivity(intent);
                }
            });
        }

        catch (Exception e){
            AlertDialog.Builder builder=new AlertDialog.Builder(getApplicationContext());
            builder.setMessage(e.getMessage());
            builder.create().show();
        }


    }

    private class HttpRequestCitizenList extends AsyncTask<Void, Void, List<Citizen>>{

        @Override
        protected List<Citizen> doInBackground(Void... voids) {
            CitizensModel citizensModel=new CitizensModel();
            return  citizensModel.findAll();
        }

        @Override
        protected void onPostExecute(List<Citizen> citizens) {
            super.onPostExecute(citizens);
        }
    }
}