package com.example.covid19app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddCitizens extends AppCompatActivity {

    EditText nid,fname,email,age;
    Button btnS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try{

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_add_citizens);

            nid=findViewById(R.id.txtnid);
            fname=findViewById(R.id.txtfname);
            email=findViewById(R.id.txtemail);
            age=findViewById(R.id.txtage);
            btnS=findViewById(R.id.btnAdd);

            btnS.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    try{
                        Citizen citizen=new Citizen();
                        citizen.setNid(nid.getText().toString());
                        citizen.setFname(fname.getText().toString());
                        citizen.setEmail(email.getText().toString());
                        citizen.setAge(Integer.parseInt(age.getText().toString()));
                        Boolean result=new HttpRequestAddCitizen().execute(citizen).get();
                        if(result){
                            Intent intent =new Intent(AddCitizens.this,AddCitizens.class);
                            startActivity(intent);
                        }

                        else{
                            Toast.makeText(AddCitizens.this, "Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                    catch (Exception e){
                        AlertDialog.Builder builder=new AlertDialog.Builder(getApplicationContext());
                        builder.setMessage(e.getMessage());
                        builder.create().show();

                    }


                }
            });

        }

        catch (Exception e){

            AlertDialog.Builder builder=new AlertDialog.Builder(getApplicationContext());
            builder.setMessage(e.getMessage());
            builder.create().show();

        }

    }

    private class HttpRequestAddCitizen extends AsyncTask<Citizen, Void, Boolean>{


        @Override
        protected Boolean doInBackground(Citizen... citizens) {
            CitizensModel citizensModel =new CitizensModel();
            return citizensModel.add(citizens[0]);
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
        }
    }
}