package com.example.mydroid;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.icu.text.NumberFormat;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private int moneyCounter = 0;
    private TextView money;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        money = findViewById(R.id.money);
        money.setTextColor(ContextCompat.getColor(MainActivity.this,R.color.white));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void makeItRain(View view) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        moneyCounter += 1000;
        money.setText(String.valueOf(numberFormat.format(moneyCounter)));
        Log.d("makeItRainAction","Accomplished!");
    }

    public void showInfo(View view) {
        Snackbar.make(money,R.string.app_info_question, Snackbar.LENGTH_SHORT).setAction("Who", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,R.string.app_info_answer,Toast.LENGTH_SHORT).show();
            }
        }).show();
    }
}