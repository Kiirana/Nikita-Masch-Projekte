package com.example.library;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;

public class Ausleiher {


    private String EingeschriebenUni;


    public String[] AusgeliehneBuecher = new String[100];
    private int ID;
    private String Vorname;
    private String Name;

    HashMap<String, Buch> ausgelieheneBuecher = new HashMap<>();


    Ausleiher(String name, String vorname, Integer id) {


        this.Name = name;
        this.ID = id;
        this.Vorname = vorname;
    }
    public void leiheBuchaus(String isbn, Buch buch) {
        if(buch.isVerfuegbarkeit()) {
            ausgelieheneBuecher.put(isbn, buch);
            Buch b = BibliotheksDatenbank.gibBuch(isbn);

        }

    }

    public void gebeBuchzurueck(String isbn) {
        Buch b = BibliotheksDatenbank.gibBuch(isbn);
        b.setVerfuegbarkeit( true);

        ausgelieheneBuecher.remove(isbn);


    }

    Buch[] giballeBuecher() {
        Buch[] array = ausgelieheneBuecher.values().toArray(new Buch[0]);
        return array;
    }







    public String[] getAusgeliehneBuecher() {
        return AusgeliehneBuecher;
    }

    public void setAusgeliehneBuecher(String[] ausgeliehneBuecher) {
        AusgeliehneBuecher = ausgeliehneBuecher;
    }

    public String getEingeschriebenUni() {
        return EingeschriebenUni;
    }

    public void setEingeschriebenUni(String eingeschriebenUni) {
        EingeschriebenUni = eingeschriebenUni;
    }

    public int BuecherSize() {
        return ausgelieheneBuecher.size();


    }




    public void setName(String name) {
        this.Name = name;
    }

    public String getVorname() {
        return Vorname;
    }

    public void setVorname(String vorname) {
        this.Vorname = vorname;
    }

    public Integer getId() {
        return ID;
    }

    public void setId(Integer id) {
        this.ID = id;
    }

}


