package org.libreapps.rest;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.libreapps.rest.obj.MesCommandes;
import org.libreapps.rest.obj.Param;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

public class ConnectionRest extends AsyncTask<String, Void, String> {
    private final static String URL = "https://api.munier.me/jwt/";
    private JSONObject jsonObj = null;
    private String action = "commandes";
    private String UsrEmail = GlobalVariable.UsrEmail;
    @Override
    protected String doInBackground(String... strings) {
        try {
            return get(strings[0]);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String get(String methode) throws IOException, JSONException {
        String url = URL + action + "/";
        String token = Param.getInstance().getToken();
        InputStream is = null;
        String parameters = "";
        if(!methode.equals("POST")&&(jsonObj!=null)&&!methode.equals("CREATE_USER")){
            url += jsonObj.getInt("id");
        }
        if(jsonObj != null){
            if(methode.equals("PUT")){
                jsonObj.remove("id");
            }
            parameters  = "data="+URLEncoder.encode(jsonObj.toString(), "utf-8");
            Log.v("URL", url+" "+parameters);
        }

        if (methode.equals("CREATE_USER")) {
            methode = "POST";
            url = URL + "register.php";
        }
        try {
            final HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod(methode);
            if (token != null) {
                conn.setRequestProperty("Authorization", "Bearer " + URLEncoder.encode(token, "utf-8"));
            }

            // Pour les methode POST et PUT on envoie les parametre avec l'OutputStreamWriter
            if(methode.equals("POST")||methode.equals("PUT")){
                conn.setDoInput(true);
                conn.setDoOutput(true);
                OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
                out.write(parameters);// here i sent the parameter
                out.close();
            }else{
                conn.setDoInput(true);
                conn.connect();
            }

            is = conn.getInputStream();
            // Lit le InputStream et l'enregistre dans une string
            return readIt(is);
        } finally {
            // Pour etre sur que le InputStream soit ferme apres avoir quitter l'application
            if (is != null) {
                is.close();
            }
        }
    }

    private String readIt(InputStream is) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(is));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = r.readLine()) != null) {
            response.append(line).append('\n');
        }
        return response.toString();
    }

    public ArrayList<MesCommandes> parse(final String json) {
        try {
            final ArrayList<MesCommandes> products = new ArrayList<>();
            final JSONArray jProductArray = new JSONArray(json);
            Log.d("test",UsrEmail);
            for (int i = 0; i < jProductArray.length(); i++) {
                MesCommandes commandes = new MesCommandes(jProductArray.optJSONObject(i));
                Log.d("test",commandes.getEmail());

                if (commandes.getEmail().equals(UsrEmail)){
                    Log.d("test","yes");
                    products.add(new MesCommandes(jProductArray.optJSONObject(i)));
                }

            }
            return products;
        } catch (JSONException e) {
            Log.v("TAG","[JSONException] e : " + e.getMessage());
        }
        return null;
    }

    public void setObj(JSONObject jsonObj){
        this.jsonObj = jsonObj;
    }
    public void setAction(String monAction){ this.action = monAction;}

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}