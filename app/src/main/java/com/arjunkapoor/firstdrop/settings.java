package com.arjunkapoor.firstdrop;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class settings extends AppCompatActivity {
    static boolean active = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarsettings);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setTitle("Settings");
        if(active == false){
            Button settingsButton = (Button) findViewById(R.id.settingsbuttonsettings);
            settingsButton.setTextColor(Color.parseColor("#ffffff"));
            settingsButton.setBackgroundColor(Color.parseColor("#1f1a1a"));










        }



    }
    public void profileButtonSettings(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
    public void newsButtonSettings(View view) {
        Intent i = new Intent(this, news.class);
        startActivity(i);
    }

    public void shareButtonsettings(View view) {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = "Hey here I found this cool application on play store for baby immnuization.Do download it from Google play via  = ";
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }
    public void onStart() {
        super.onStart();
        active = true;
    }
    public void onStop() {
        super.onStop();
        active = false;
    }
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

}
