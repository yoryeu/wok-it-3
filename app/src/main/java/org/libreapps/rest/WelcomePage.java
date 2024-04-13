package org.libreapps.rest;

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

import org.libreapps.rest.obj.Product;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
public class WelcomePage extends AppCompatActivity {
    private Button buttonCommander;
    private Button buttonHistorique;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcomepage);
        buttonCommander = (Button)findViewById(R.id.button_Commander);
        buttonHistorique = (Button)findViewById(R.id.button_Historique);
        buttonCommander.setBackgroundColor(Color.BLACK);
        buttonHistorique.setBackgroundColor(Color.BLACK);

        buttonCommander.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomePage.this, Commander.class);
                startActivity(intent);
            }
        });
    }
}