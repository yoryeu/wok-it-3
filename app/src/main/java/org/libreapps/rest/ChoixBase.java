package org.libreapps.rest;

import static org.libreapps.rest.GlobalVariable.setBase;
import static org.libreapps.rest.GlobalVariable.setUsrEmail;

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
public class ChoixBase extends AppCompatActivity {
    private String base = GlobalVariable.base;
    private ImageButton buttonRiz;
    private ImageButton buttonNouilles;
    private ImageButton buttonQuinoa;
    private Button buttonBasePrcédent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        buttonRiz = (ImageButton)findViewById(R.id.button_Riz);
        buttonNouilles = (ImageButton)findViewById(R.id.button_Nouilles);
        buttonQuinoa = (ImageButton)findViewById(R.id.button_Quinoa);
        buttonBasePrcédent = (Button)findViewById(R.id.button_BasePrecedent);

        buttonNouilles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBase("nouilles");
                Intent intent = new Intent(ChoixBase.this, ChoixProt.class);
                startActivity(intent);
            }
        });
        buttonRiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBase("riz");
                Intent intent = new Intent(ChoixBase.this, ChoixProt.class);
                startActivity(intent);
            }
        });
        buttonQuinoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBase("quinoa");
                Intent intent = new Intent(ChoixBase.this, ChoixProt.class);
                startActivity(intent);
            }
        });
        buttonBasePrcédent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChoixBase.this, Commander.class);
                startActivity(intent);
            }
        });
    }
}

