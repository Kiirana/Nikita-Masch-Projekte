package com.example.library;

interface Interface1 {

    void nutzerHinzufuegen(String name, String vorname);
    void nutzerLoeschen(Integer id);
    public void buchAusleihen( Integer id,  String isbn);


    void gebeBuchzurueck(Integer id, String isbn);

    void loescheBuch(String titel, String buch);
    String[] bestandBuecher();
    String[] gebeAlleBuecherId();
    String[] gebeAlleNutzerName();
    Integer[] gebeAlleNutzerId();
    public void legeBuchAn(String titel, String autor, String isbn , boolean verfuegbarkeit);

    public Ausleiher gibNutzer(Integer id);

    public Buch selectBuch(String isbn);
}
