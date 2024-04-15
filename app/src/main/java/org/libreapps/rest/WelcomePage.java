package org.libreapps.rest;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

public class WelcomePage extends AppCompatActivity {
    private Button buttonCommander;
    private Button buttonHistorique;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcomepage);
        buttonCommander = (Button)findViewById(R.id.button_Commander);
        buttonHistorique = (Button)findViewById(R.id.button_Modifier);
        buttonCommander.setBackgroundColor(Color.BLACK);
        buttonHistorique.setBackgroundColor(Color.BLACK);

        buttonCommander.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomePage.this, Commander.class);
                startActivity(intent);
            }
        });
        buttonHistorique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomePage.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}