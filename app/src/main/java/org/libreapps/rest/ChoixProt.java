package org.libreapps.rest;

import static org.libreapps.rest.GlobalVariable.setLegume;
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
public class ChoixProt extends AppCompatActivity {
    private String prot = GlobalVariable.proteine;
    private ImageButton buttonBoeuf;
    private ImageButton buttonPoulet;
    private ImageButton buttonTofu;
    private ImageButton buttonPorc;
    private ImageButton buttonCrevette;
    private Button buttonProtPrécedent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proteine);
        buttonBoeuf = (ImageButton)findViewById(R.id.button_Boeuf);
        buttonPoulet = (ImageButton)findViewById(R.id.button_Poulet);
        buttonCrevette = (ImageButton)findViewById(R.id.button_Crevette);
        buttonPorc = (ImageButton)findViewById(R.id.button_Porc);
        buttonTofu = (ImageButton)findViewById(R.id.button_Tofu);
        buttonProtPrécedent = (Button)findViewById(R.id.button_ProtPrecedent);

        buttonBoeuf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setProteine("Boeuf");
                Intent intent = new Intent(ChoixProt.this, ChoixLegume.class);
                startActivity(intent);
            }
        });
        buttonPoulet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setProteine("Poulet");
                Intent intent = new Intent(ChoixProt.this, ChoixLegume.class);
                startActivity(intent);
            }
        });
        buttonCrevette.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setProteine("Crevette");
                Intent intent = new Intent(ChoixProt.this, ChoixLegume.class);
                startActivity(intent);
            }
        });
        buttonPorc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setProteine("Porc");
                Intent intent = new Intent(ChoixProt.this, ChoixLegume.class);
                startActivity(intent);
            }
        });
        buttonTofu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setProteine("Tofu");
                Intent intent = new Intent(ChoixProt.this, ChoixLegume.class);
                startActivity(intent);
            }
        });
        buttonProtPrécedent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChoixProt.this, ChoixBase.class);
                startActivity(intent);
            }
        });
    }
}




