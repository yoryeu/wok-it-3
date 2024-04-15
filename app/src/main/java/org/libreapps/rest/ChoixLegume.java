package org.libreapps.rest;

import static org.libreapps.rest.GlobalVariable.setBase;
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
public class ChoixLegume extends AppCompatActivity {
    private String legume = GlobalVariable.legume;
    private ImageButton buttonChampignon;
    private ImageButton buttonPoivrons;
    private ImageButton buttonNoixDeCajou;
    private ImageButton buttonBrocoly;
    private Button buttonLegumePrcédent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legumes);
        buttonBrocoly = (ImageButton)findViewById(R.id.button_Brocoly);
        buttonNoixDeCajou = (ImageButton)findViewById(R.id.button_NoixDeCajou);
        buttonPoivrons = (ImageButton)findViewById(R.id.button_Poivron);
        buttonChampignon = (ImageButton)findViewById(R.id.button_Champignon);
        buttonLegumePrcédent = (Button)findViewById(R.id.button_LegumePrecedent);

        buttonBrocoly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLegume("brocoly");
                Intent intent = new Intent(ChoixLegume.this, ChoixSauce.class);
                startActivity(intent);
            }
        });
        buttonChampignon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLegume("champignons");
                Intent intent = new Intent(ChoixLegume.this, ChoixSauce.class);
                startActivity(intent);
            }
        });
        buttonPoivrons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLegume("poivrons");
                Intent intent = new Intent(ChoixLegume.this, ChoixSauce.class);
                startActivity(intent);
            }
        });
        buttonNoixDeCajou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLegume("noix de cajou");
                Intent intent = new Intent(ChoixLegume.this, ChoixSauce.class);
                startActivity(intent);
            }
        });
        buttonLegumePrcédent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChoixLegume.this, ChoixProt.class);
                startActivity(intent);
            }
        });

    }
}



