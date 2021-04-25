package com.example.counterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.counterapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private int qty = 0;
    ActivityMainBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        setUpEventHandlers();
    }

    private void setUpEventHandlers() {
        b.incQty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incQty();
            }
        });

        b.incQty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decQty();
            }
        });
    }

    private void decQty() {
        b.resultTextView.setText(""+ --qty);
    }

    public void incQty(){
        b.resultTextView.setText(""+ ++qty);
    }
}