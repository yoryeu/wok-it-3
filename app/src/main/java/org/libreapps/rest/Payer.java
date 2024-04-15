package org.libreapps.rest;

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
import android.widget.TextView;


import org.json.JSONException;
import org.json.JSONObject;
import org.libreapps.rest.obj.MesCommandes;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
public class Payer extends AppCompatActivity {
    private TextView boisson;
    private TextView base;
    private TextView typeMenu;
    private TextView sauce;
    private TextView topping;
    private TextView proteine;
    private TextView legume;
    private TextView prix;
    private Button payer;
    private Button modifier;

    private double prixInt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payer);
        boisson = (TextView) findViewById(R.id.txt_Boisson);
        boisson.setText(GlobalVariable.boisson);
        base = (TextView) findViewById(R.id.text_Base);
        base.setText(GlobalVariable.base);
        typeMenu = (TextView) findViewById(R.id.text_TypeMenu);
        typeMenu.setText(GlobalVariable.menuType);
        sauce = (TextView) findViewById(R.id.text_Sauce);
        sauce.setText(GlobalVariable.sauce);
        topping = (TextView) findViewById(R.id.text_Topping);
        topping.setText(GlobalVariable.topping);
        proteine = (TextView) findViewById(R.id.text_Proteine);
        proteine.setText(GlobalVariable.proteine);
        legume = (TextView) findViewById(R.id.text_Legume);
        legume.setText(GlobalVariable.legume);
        payer = (Button) findViewById(R.id.button_Payer);
        modifier = (Button) findViewById(R.id.button_Modifier);
        switch (GlobalVariable.menuType){
            case "menu classique":
               prixInt = 11.5;
                break;
            case "menu étudiant":
                prixInt = 9.5;
                break;
            case "menu enfant":
                prixInt = 8.5;
                break;
            default:
                prixInt = 0;
        }
        prix = (TextView) findViewById(R.id.txt_Boisson2);
        prix.setText("" + prixInt);

        payer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    ConnectionRest connectionRest = new ConnectionRest();
                    JSONObject product = new JSONObject();
                    product.put("email", GlobalVariable.UsrEmail);
                    product.put("type", GlobalVariable.menuType);
                    product.put("price", prixInt);
                    connectionRest.setObj(product);

                    connectionRest.execute("POST");

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(Payer.this, WelcomePage.class);
                startActivity(intent);
            }
        });
        modifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Payer.this, Commander.class);
                startActivity(intent);
            }
        });


    }
}