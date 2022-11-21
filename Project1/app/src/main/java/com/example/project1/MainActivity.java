package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnIn;
    private EditText login;
    private EditText password;
    private TextView error;
    public static final String KEY = "Act";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnIn = findViewById(R.id.button);
        btnIn.setOnClickListener(this);
        login = findViewById(R.id.editTextTextEmailAddress);
        password = findViewById(R.id.editTextTextPassword);
        error = findViewById(R.id.textView);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button){
            Pattern email = Pattern.compile("[a-zA-Z0-9]{1,}@[a-zA-Z]{1,10}\\.[a-zA-Z]{1,5}");
            Matcher matcher = email.matcher((CharSequence) login);
            Pattern passwordP = Pattern.compile("[a-zA-Z0-9]{8,15}");
            Matcher matcher2 = passwordP.matcher((CharSequence) password);
            if (matcher.matches() && matcher2.matches()) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra(KEY, "Hello "+ login + "!");
                startActivity(intent);
            }
            else{
                error.setText("Ошибка входа!");
            }
        }
    }
}