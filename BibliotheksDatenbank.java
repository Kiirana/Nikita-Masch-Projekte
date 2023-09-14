package com.example.library;

import java.util.HashMap;

public class BibliotheksDatenbank {




    static Integer nutzerid = 0;
    static HashMap<Integer, Ausleiher> nutzerHashMap = new HashMap<Integer, Ausleiher>();
    static HashMap<String, Buch> buecherHashMap = new HashMap<String, Buch>();

    public static HashMap<Integer, Ausleiher> GetAusleiherHashMap() {
        return nutzerHashMap;
    }

    public static HashMap<String, Buch> getBuecherHashMap() {
        return buecherHashMap;
    }

    static void insertNutzer(String name, String vorname) {
        nutzerid++;
        nutzerHashMap.put(nutzerid, new Ausleiher(name, vorname, nutzerid));
    }

    static void loescheNutzer(Integer id) throws IllegalArgumentException {

        nutzerHashMap.remove(id);
    }

    static void insertBuch(String titel, String autor, String isbn , boolean verfuebarkeit) {
        BibliotheksDatenbank.buecherHashMap.put(isbn, new Buch(titel, autor, isbn, verfuebarkeit ));}

    static void loescheBuch(String titel, String isbn) {


        BibliotheksDatenbank.buecherHashMap.remove(isbn);
    }


    static Buch gibBuch(String isbn) {
        return BibliotheksDatenbank.buecherHashMap.get(isbn);
    }

    static Ausleiher gibtNutzer(Integer id) {
        return BibliotheksDatenbank.nutzerHashMap.get(id);
    }


}





