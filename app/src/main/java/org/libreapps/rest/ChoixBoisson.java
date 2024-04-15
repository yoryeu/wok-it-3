package org.libreapps.rest;

import static org.libreapps.rest.GlobalVariable.setBoisson;
import static org.libreapps.rest.GlobalVariable.setProteine;

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
public class ChoixBoisson extends AppCompatActivity {
    private String boisson = GlobalVariable.boisson;
    private ImageButton buttonAsahi;
    private ImageButton buttonCoca;
    private ImageButton buttonFanta;
    private ImageButton buttonSprite;
    private ImageButton buttonIceTea;
    private Button buttonBoissonPrécedent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boissons);
        buttonAsahi = (ImageButton)findViewById(R.id.button_Asahi);
        buttonCoca = (ImageButton)findViewById(R.id.button_Coca);
        buttonFanta = (ImageButton)findViewById(R.id.button_Fanta);
        buttonSprite = (ImageButton)findViewById(R.id.button_Sprite);
        buttonIceTea = (ImageButton)findViewById(R.id.button_IceTea);
        buttonBoissonPrécedent = (Button)findViewById(R.id.button_BoissonPrecedent);

        buttonAsahi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBoisson("Asahi");
                Intent intent = new Intent(ChoixBoisson.this, Payer.class);
                startActivity(intent);
            }
        });
        buttonCoca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBoisson("Coca cola");
                Intent intent = new Intent(ChoixBoisson.this, Payer.class);
                startActivity(intent);
            }
        });
        buttonFanta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBoisson("Fanta");
                Intent intent = new Intent(ChoixBoisson.this, Payer.class);
                startActivity(intent);
            }
        });
        buttonSprite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBoisson("Sprite");
                Intent intent = new Intent(ChoixBoisson.this, Payer.class);
                startActivity(intent);
            }
        });
        buttonIceTea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBoisson("ice tea");
                Intent intent = new Intent(ChoixBoisson.this, Payer.class);
                startActivity(intent);
            }
        });
        buttonBoissonPrécedent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChoixBoisson.this, ChoixTopping.class);
                startActivity(intent);
            }
        });
    }
}
