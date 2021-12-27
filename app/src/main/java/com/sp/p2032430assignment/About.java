package com.sp.p2032430assignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        ActionBar actionBar = getSupportActionBar();
        //actionBar.setHomeAsUpIndicator(R.drawable.backbtn_2);
        actionBar.setDisplayHomeAsUpEnabled(true);
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#253334"));
        // Set BackgroundDrawable
        actionBar.setBackgroundDrawable(colorDrawable);
        TextView t = findViewById(R.id.about_info);
        t.setText("This app is created for Singaporeans to write a report to the town council regarding maintenance and repairs in public areas.\n" +"\n"+
                "Users will be asked to fill in personal details and upload a picture of the issue. All forms submitted can be seen in the All Forms page.\n" +
                "\n"+"The location of the report will automatically be shown using google maps based on the address the user typed. ");
    }

    // this event will enable the back
    // function to the button on press
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

