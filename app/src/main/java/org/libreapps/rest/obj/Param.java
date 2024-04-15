package org.libreapps.rest.obj;

public class Param {

    private String token;
    private static Param param;
    private int idUser;
    private String nameUser;

    private Param() {
    }

    public static Param getInstance() {
        if (param == null) {
            param = new Param();
        }
        return param;
    }

    public void setToken(String token) { this.token = token; }
    public void setIdUser(int idUser) {this.idUser = idUser;}
    public void setNameUser(String nameUser) {this.nameUser = nameUser;}

    public String getToken() { return token; }
    public int getIdUser() {return idUser;}
    public String getNameUser() {return nameUser;}
}