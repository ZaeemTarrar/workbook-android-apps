package com.example.mydroid2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.mydroid2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    
//    private TextView hobbyBar;
//    private Button hobbyButton;
//    private TextView hobbyResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

//        hobbyBar = findViewById(R.id.hobby_input);
//        hobbyButton = findViewById(R.id.hobby_button);
//        hobbyResult = findViewById(R.id.hobby_result);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

//        binding.hobbyButton.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                addHobby(view);
//            }
//        });

        binding.hobbyButton.setOnClickListener(this::addHobby);
    }

    public void addHobby(View view) {
//        String data = hobbyBar.getText().toString();
//        hobbyBar.setText("");
//        hobbyResult.setText("Hobbies: "+data.toString());
//        hobbyResult.setVisibility(View.VISIBLE);

        String data = binding.hobbyInput.getText().toString();
        binding.hobbyInput.setText("");
        binding.hobbyResult.setText("Hobbies: "+data.toString());
        binding.invalidateAll();
        binding.hobbyResult.setVisibility(View.VISIBLE);

        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
    }
}