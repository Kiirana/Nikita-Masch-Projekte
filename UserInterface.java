package com.example.library;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class UserInterface {

    public static void anwendung(Bibliotheksverwaltung bibliotheksdienste) {

        Scanner scanner = new Scanner(System.in);


        while (true) {

            System.out.println();

            System.out.println("1. Nutzer anlegen");
            System.out.println("2. Nutzer löschen");
            System.out.println("3. Buch aufnehmen");
            System.out.println("4. Buch ausleihen");
            System.out.println("5. Rückgabe eines Buches");
            System.out.println("6. Beenden");
            System.out.println("-----------------------");

            System.out.println("Eingabe: ");

            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println(" Vornamen Eingabe: ");
                String nutzerVorname = scanner.next();
                System.out.println(" Nachname Eingabe: ");
                String nutzerNachname = scanner.next();
                bibliotheksdienste.nutzerHinzufuegen(nutzerNachname, nutzerVorname);
                System.out.println(nutzerVorname + " "+ nutzerNachname + " wurde hinzugefügt.");
                System.out.println();
            } else if (choice == 2) {
                ausgabeListeNutzer(bibliotheksdienste);
                System.out.println(" Nutzer Id Eingabe");
                int auswahlNutzerId = scanner.nextInt();
                bibliotheksdienste.nutzerLoeschen(auswahlNutzerId);
                System.out.println("Nutzer gelöscht.");
            } else if (choice == 3) {
                System.out.println(" Titel Eingabe (buch) ");
                String buchTitel = scanner.next();
                System.out.println(" Autor Eingabe ");
                String buchAutor = scanner.next();
                System.out.println("ISBN eingabe ");
                String buchISBN = scanner.next();
                bibliotheksdienste.legeBuchAn(buchTitel, buchAutor, buchISBN, true);
                System.out.println(buchTitel + " wurde hinzugefügt.");
                System.out.println();
            } else if (choice == 4) {
                ausgabeListeNutzer(bibliotheksdienste);
                System.out.println("Nutzer auswählen ");
                int auswahlNutzer = scanner.nextInt();
                ausgabeListeBuecher(bibliotheksdienste);
                System.out.println("Buch auswählen ");
                String auswahlBuch = scanner.next();
                bibliotheksdienste.buchAusleihen(auswahlNutzer,auswahlBuch);
                Buch  b =   BibliotheksDatenbank.gibBuch(auswahlBuch);
                if(b.isVerfuegbarkeit()) {
                    Buch[] array3 = bibliotheksdienste.gibNutzer(auswahlNutzer).giballeBuecher();
                    System.out.println(bibliotheksdienste.gibNutzer(auswahlNutzer).getVorname());
                    for (Buch buch : array3) {
                        System.out.println(buch.getTitel());
                    }
                    SimpleDateFormat formatter = new SimpleDateFormat(
                            "yyyy.MM.dd - HH:mm:ss ");
                    Date currentTime = new Date();
                    System.out.println(" 14 Tage Ausleihe ab dem " + formatter.format(currentTime));
                    b.setFalse();

                } else{


                    System.out.println(" Buch ist nicht verfügbar");

                }


            } else if (choice == 5) {
                ausgabeListeNutzer(bibliotheksdienste);
                System.out.println("Nutzer auswählen" );


                int auswahlNutzer = scanner.nextInt();

                System.out.println("folgende Bücher wurden geliehen:");

                Buch[] array = bibliotheksdienste.gibNutzer(auswahlNutzer).giballeBuecher();
                for (Buch buch : array) {
                    System.out.println(buch.getIsbn() + ": " + buch.getTitel());
                }

                System.out.println("Welches Buch soll zurück gegeben werden?");
                String auswahlBuchZurueck = scanner.next();
                bibliotheksdienste.gebeBuchzurueck(auswahlNutzer,auswahlBuchZurueck);

                System.out.println("Rückgabe abgeschlossen.");

            } else if (choice == 6) {
                break;
            }
        }
        scanner.close();
    }

    public static String ausgabeListeNutzer(Bibliotheksverwaltung bi) {

        StringBuilder output = new StringBuilder();
        String[] array = bi.gebeAlleNutzerName();
        Integer[] arrayid = bi.gebeAlleNutzerId();
        for (int i = 0; i < array.length; i++) {
            output.append(arrayid[i] + ", " + array[i] + '\n');

        }

       return output.toString();

    }

    public static void ausgabeListeBuecher(Bibliotheksverwaltung bi) {
        System.out.println("Bücher im System:");
        String[] buechername = bi.bestandBuecher();
        String[] buecherisbn = bi.gebeAlleBuecherId();

        for (int i = 0; i < buechername.length; i++) {
            System.out.println(buecherisbn[i] + " ," + buechername[i]);
        }


    }
}
