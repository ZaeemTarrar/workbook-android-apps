package com.example.mydroid2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.mydroid2.data.Bio;
import com.example.mydroid2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    private final Bio bio = new Bio();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        bio.setName("Zaeem");
        binding.setBio(bio);

        binding.hobbyButton.setOnClickListener(this::addHobby);
    }

    public void addHobby(View view) {
        bio.setHobbies("Hobbies: "+binding.hobbyInput.getText().toString());
        binding.hobbyInput.setText("");
        binding.invalidateAll();
        binding.hobbyResult.setVisibility(View.VISIBLE);

        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
    }
}