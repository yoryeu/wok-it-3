package org.libreapps.rest;

import static org.libreapps.rest.GlobalVariable.setLegume;
import static org.libreapps.rest.GlobalVariable.setTopping;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ChoixTopping extends AppCompatActivity {
    private String legume = GlobalVariable.topping;
    private ImageButton buttonAnanas;
    private ImageButton buttonOignons;
    private ImageButton buttonCacahuetes;
    private ImageButton buttonSesame;
    private Button buttonToppingPrcédent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topping);
        buttonAnanas = (ImageButton)findViewById(R.id.button_Ananas);
        buttonOignons = (ImageButton)findViewById(R.id.button_FriedOignons);
        buttonCacahuetes = (ImageButton)findViewById(R.id.button_Cacahuettes);
        buttonSesame = (ImageButton)findViewById(R.id.button_Sesam);
        buttonToppingPrcédent = (Button)findViewById(R.id.button_ToppingsPrecedent);

        buttonAnanas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTopping("Ananas");
                Intent intent = new Intent(ChoixTopping.this, ChoixBoisson.class);
                startActivity(intent);
            }
        });
        buttonOignons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTopping("oignons frits");
                Intent intent = new Intent(ChoixTopping.this, ChoixBoisson.class);
                startActivity(intent);
            }
        });
        buttonCacahuetes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTopping("cacahuètes");
                Intent intent = new Intent(ChoixTopping.this, ChoixBoisson.class);
                startActivity(intent);
            }
        });
        buttonSesame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTopping("Mix de graines de sésame");
                Intent intent = new Intent(ChoixTopping.this, ChoixBoisson.class);
                startActivity(intent);
            }
        });
        buttonToppingPrcédent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChoixTopping.this, ChoixSauce.class);
                startActivity(intent);
            }
        });
    }
}
