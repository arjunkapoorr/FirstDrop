package com.arjunkapoor.firstdrop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class VaccineList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_VaccineList);
        Bundle extras = getIntent().getExtras();
        String valuename = extras.getString("name");
        TextView titlename = (TextView) findViewById(R.id.toolbartitle_vaccinelist);
        titlename.setText(valuename);







    }
    public void backButton(View view){
        Intent i = new Intent(this, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);

    }
    public void addBaby(View view) {

        Intent i = new Intent(this, addBaby.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);


    }



}
