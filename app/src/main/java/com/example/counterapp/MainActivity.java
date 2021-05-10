package com.example.counterapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

import com.example.counterapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private int qty = 0;
    ActivityMainBinding b;

    /**
     * Event Handlers
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        setUpEventHandlers();
        if(savedInstanceState != null){
            qty = savedInstanceState.getInt(Constants.QTY);
            b.resultTextView.setText(String.valueOf(qty));
        }else{
            qty = preferences.getInt(Constants.QTY, 0);
            b.resultTextView.setText(String.valueOf(qty));
        }
    }

    private void setUpEventHandlers() {
        b.incQty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incQty();
            }
        });

        b.decQty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decQty();
            }
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(Constants.QTY, qty);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        preferences.edit()
                .putInt(Constants.QTY, qty)
                .apply();
    }

    /**
     * Utils
     */
    private void decQty() {
        b.resultTextView.setText(""+ --qty);
    }

    public void incQty(){
        b.resultTextView.setText(""+ ++qty);
    }
}