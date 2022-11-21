package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView login;
    private Button btnOut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        login = findViewById(R.id.textView2);
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            login.setText(bundle.getString(MainActivity.KEY));
        }
        btnOut = findViewById(R.id.button2);
        btnOut.setOnClickListener(view -> {
            finish();
        });
    }
}