package org.libreapps.rest;

import static org.libreapps.rest.GlobalVariable.setMenuType;
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
import android.widget.ListView;


import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
public class Commander extends AppCompatActivity {
    private String menuType = GlobalVariable.menuType;
    private Button buttonMenuClassique;
    private Button buttonMenuEtudiant;
    private Button buttonMenuEnfant;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commander);
        buttonMenuClassique = (Button)findViewById(R.id.button_MenuClassique);
        buttonMenuEtudiant = (Button)findViewById(R.id.button_MenuEtudiant);
        buttonMenuEnfant = (Button)findViewById(R.id.button_MenuEnfant);

        buttonMenuClassique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMenuType("menu classique");
                Intent intent = new Intent(Commander.this, ChoixBase.class);
                startActivity(intent);
            }
        });
        buttonMenuEtudiant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMenuType("menu étudiant");
                Intent intent = new Intent(Commander.this, ChoixBase.class);
                startActivity(intent);
            }
        });
        buttonMenuEnfant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMenuType("menu enfant");
                Intent intent = new Intent(Commander.this, ChoixBase.class);
                startActivity(intent);
            }
        });

    }
}
