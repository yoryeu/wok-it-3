package org.libreapps.rest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;
import org.libreapps.rest.obj.Param;

import java.util.Base64;
import java.util.concurrent.ExecutionException;

public class LoginActivity extends AppCompatActivity {
    private EditText userEmail;
    private EditText userPassword;
    private Button buttonLogin;
    private Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userEmail = (EditText)findViewById(R.id.user_email);
        userPassword = (EditText)findViewById(R.id.user_password);
        buttonLogin = (Button)findViewById(R.id.button_login);
        buttonRegister = (Button)findViewById(R.id.button_register);
        buttonLogin.setBackgroundColor(Color.BLACK);
        buttonRegister.setBackgroundColor(Color.BLACK);

        userEmail.setText("");
        userPassword.setText("");

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    JSONObject jAuth = new JSONObject();
                    jAuth.put("email", userEmail.getText().toString());
                    jAuth.put("password", userPassword.getText().toString());
                    jAuth.put("app", "MNA");

                    Log.v("LoginActivity", userEmail.getText().toString()+" "+userPassword.getText().toString());
                    ConnectionRest connectionRest = new ConnectionRest();
                    connectionRest.setObj(jAuth);
                    connectionRest.setAction("auth");
                    connectionRest.execute("POST");
                    String token = connectionRest.get();
                    Param.getInstance().setToken(token);

                    if(token.charAt(0)=='{') {
                        Log.v("LoginActivity", token);
                    }else{
                        Param.getInstance().setToken(token);
                        String []tabToken = token.split("\\.");
                        String jsonToken = "";
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            jsonToken = new String(Base64.getDecoder().decode(tabToken[1].getBytes()));
                        }

                        Log.v("TOKEN",jsonToken+" "+tabToken[1]);
                        JSONObject payload = new JSONObject(jsonToken);
                        Param.getInstance().setNameUser(payload.getString("name"));
                        Param.getInstance().setIdUser(payload.getInt("usr"));
                        Intent intent = new Intent(LoginActivity.this, WelcomePage.class);
                        startActivity(intent);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (InterruptedException  e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        });

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });
    }
}