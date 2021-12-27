package com.sp.p2032430assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

    private Button AboutBtn,FormBtn,DisplayBtn,ExitBtn;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();

        AboutBtn = findViewById(R.id.about_button);
        FormBtn = findViewById(R.id.form_button);
        DisplayBtn = findViewById(R.id.display_button);
        ExitBtn = findViewById(R.id.submit_btn);

        AboutBtn.setOnClickListener(onAbt);
        FormBtn.setOnClickListener(onForm);
        DisplayBtn.setOnClickListener(onDisplay);
        ExitBtn.setOnClickListener(onExit);
    }

    private View.OnClickListener onAbt = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            intent = new Intent(Home.this, About.class);
            startActivity(intent);
        }

    };
    private View.OnClickListener onForm = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            intent = new Intent(Home.this, Form.class);
            startActivity(intent);
        }

    };
    private View.OnClickListener onDisplay = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            intent = new Intent(Home.this, Display.class);
            startActivity(intent);
        }

    };
    private View.OnClickListener onExit = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
            System.exit(0);
        }

    };
}