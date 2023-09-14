package com.example.library;



public class Bibliotheksverwaltung implements Interface1 {






    public void nutzerHinzufuegen(String name, String vorname)  {
        BibliotheksDatenbank.insertNutzer(name, vorname);

    }




    public void nutzerLoeschen(Integer id) {
        BibliotheksDatenbank.loescheNutzer(id);
    }


    public void buchAusleihen( Integer id,  String isbn) {
        Ausleiher n= Bibliotheksverwaltung.gibtNutzer(id);

        Buch b = BibliotheksDatenbank.gibBuch(isbn);
        if(b.isVerfuegbarkeit() ) {
            n.leiheBuchaus(isbn, b);

        }
    }


    private static Ausleiher gibtNutzer(Integer id) {
        return BibliotheksDatenbank.gibtNutzer(id);
    }

    public void gebeBuchzurueck(Integer id,String ISBN) {

        Ausleiher n =Bibliotheksverwaltung.gibtNutzer(id);
        Buch b = BibliotheksDatenbank.gibBuch(ISBN);

        n.gebeBuchzurueck(ISBN);
    }



    public String[] bestandBuecher() {
        String[] array = BibliotheksDatenbank.getBuecherHashMap().keySet().toArray(new String[0]);

        String[] buechernamen= new String[BibliotheksDatenbank.getBuecherHashMap().size()];

        for( int i=0;i<array.length;i++){
            if(BibliotheksDatenbank.getBuecherHashMap().get(array[i]).isVerfuegbarkeit()){
                buechernamen[i]=BibliotheksDatenbank.getBuecherHashMap().get(array[i]).getTitel();
            }}
        return buechernamen;
    }


    public String[] gebeAlleBuecherId() {
        String[] array = BibliotheksDatenbank.getBuecherHashMap().keySet().toArray(new String[0]);
        return array;
    }

    public String[] gebeAlleNutzerName() {
        Integer[] array = BibliotheksDatenbank.GetAusleiherHashMap().keySet().toArray(new Integer[0]);
        String[] arrayForName = new String[BibliotheksDatenbank.GetAusleiherHashMap().size()];

        for(int i=0;i<array.length;i++){
            arrayForName[i]=BibliotheksDatenbank.GetAusleiherHashMap().get(array[i]).getVorname();
        }
        return arrayForName;
    }

    public Ausleiher gibNutzer(Integer id){
        return Bibliotheksverwaltung.gibtNutzer(id);
    }

    public Integer[] gebeAlleNutzerId() {
        Integer[] array = BibliotheksDatenbank.GetAusleiherHashMap().keySet().toArray(new Integer[0]);
        return array;
    }


    public void legeBuchAn(String titel, String autor, String isbn , boolean verfuegbarkeit) {
        BibliotheksDatenbank.insertBuch(titel,autor,isbn , verfuegbarkeit);
    }



    public void loescheBuch(String titel, String isbn) {
        BibliotheksDatenbank.loescheBuch(titel,isbn);
    }




    public Buch selectBuch(String isbn) {
        return null;
    }


}


