package com.pontic_studio.tema2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button closeButton = findViewById(R.id.buttonClose);
        Button startButton = findViewById(R.id.buttonStart);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenAnimalPage();
            }
        });


    }
    public void OpenAnimalPage()
    {
        Intent intent = new Intent(this, AnimalPageActivity.class);
        startActivity(intent);
    }
}