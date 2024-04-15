package org.libreapps.rest.obj;

import org.json.JSONObject;

public class MesCommandes {
    private final int id;
    private final String email;
    private final String type;
    private final double price;

    public MesCommandes(JSONObject jObject) {
        this.id =jObject.optInt("id");
        this.email = jObject.optString("email");
        this.type = jObject.optString("type");
        this.price = jObject.optDouble("price");
    }

    public int getId() { return id; }
    public String getEmail() { return email; }
    public String getType() { return type; }
    public double getPrice() { return price; }
}
