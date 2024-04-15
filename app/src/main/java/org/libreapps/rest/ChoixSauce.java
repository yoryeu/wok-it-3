package org.libreapps.rest;

import static org.libreapps.rest.GlobalVariable.setLegume;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;


import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
public class ChoixSauce extends AppCompatActivity {
    private String sauce = GlobalVariable.sauce;
    private ImageButton buttonHongKong;
    private ImageButton buttonTokyo;
    private ImageButton buttonSeoul;
    private ImageButton buttonHotAsia;
    private Button buttonSaucePrcédent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sauces);
        buttonHongKong = (ImageButton)findViewById(R.id.button_HongKong);
        buttonTokyo = (ImageButton)findViewById(R.id.button_Tokyo);
        buttonSeoul = (ImageButton)findViewById(R.id.button_Seoul);
        buttonHotAsia = (ImageButton)findViewById(R.id.button_HotAsia);
        buttonSaucePrcédent = (Button)findViewById(R.id.button_LegumePrecedent);

        buttonHongKong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLegume("hongkong");
                Intent intent = new Intent(ChoixSauce.this, ChoixTopping.class);
                startActivity(intent);
            }
        });
        buttonTokyo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLegume("tokyo");
                Intent intent = new Intent(ChoixSauce.this, ChoixTopping.class);
                startActivity(intent);
            }
        });
        buttonSeoul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLegume("séoul");
                Intent intent = new Intent(ChoixSauce.this, ChoixTopping.class);
                startActivity(intent);
            }
        });
        buttonHotAsia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLegume("hot asia");
                Intent intent = new Intent(ChoixSauce.this, ChoixTopping.class);
                startActivity(intent);
            }
        });
        buttonSaucePrcédent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChoixSauce.this, ChoixLegume.class);
                startActivity(intent);
            }
        });
    }
}
