package com.example.mydroid2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    
    private TextView hobbyBar;
    private Button hobbyButton;
    private TextView hobbyResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        hobbyBar = findViewById(R.id.hobby_input);
        hobbyButton = findViewById(R.id.hobby_button);
        hobbyResult = findViewById(R.id.hobby_result);
    }

    public void addHobby(View view) {
        String data = hobbyBar.getText().toString();
        hobbyBar.setText("");
        hobbyResult.setText("Hobbies: "+data.toString());
        hobbyResult.setVisibility(View.VISIBLE);

        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
    }
}