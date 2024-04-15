package org.libreapps.rest;

public class GlobalVariable {

    public static String UsrEmail = "";
    public static String menuType;
    public static String base;
    public static String proteine;
    public static String legume;
    public static String sauce;
    public static String topping;
    public static String boisson;

    public static void setUsrEmail(String usrEmail) {
        UsrEmail = usrEmail;
    }

    public static void setMenuType(String menuType) {
        GlobalVariable.menuType = menuType;
    }

    public static void setBase(String base) {
        GlobalVariable.base = base;
    }

    public static void setProteine(String proteine) {
        GlobalVariable.proteine = proteine;
    }

    public static void setLegume(String legume) {
        GlobalVariable.legume = legume;
    }

    public static void setSauce(String sauce) {
        GlobalVariable.sauce = sauce;
    }

    public static void setTopping(String topping) {
        GlobalVariable.topping = topping;
    }

    public static void setBoisson(String boisson) {
        GlobalVariable.boisson = boisson;
    }
}
