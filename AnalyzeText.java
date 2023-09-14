package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class AnalyzeText {
    private static boolean isLetter(char c) {
        return ((('a' <= c) && (c <= 'z')) || (('A' <= c) && (c <= 'Z')) ||
                (c == 'ß') || (c == 'ä') || (c == 'ö')|| (c == 'ü') ||
                (c == 'Ä') || (c == 'Ö') || (c == 'Ü') || (c == '\n'));
    }
    private static String readWord(BufferedReader f) throws IOException {
        String s = "";
        char c;
        int inputChar;
// Auf nächstes Wort warten
        do {
            inputChar = f.read();
            c = (char) inputChar;
        } while (!isLetter(c) && (inputChar != -1));
// Auf Wortende warten
        while (isLetter(c)) {
            if (c != '\n')
                s += c;
            else
                s += '!';
            inputChar = f.read();
            c = (char) inputChar;
        }
        if (s.isEmpty())
            return null;
        else
            return s;
    }

    public static void main(String[] args) {

        ArrayList<String> eingabe = new ArrayList<>();
        ArrayList<Integer> line = new ArrayList<>();
        int lineCounter = 1;

        try {

            BufferedReader f = new BufferedReader(new FileReader("C:\\AnalyzeText\\src\\main\\java\\org\\example\\AuDText.txt"));
            String s;
            while ((s = readWord(f)) != null) {
                eingabe.add(s);
            }
        }
        catch (IOException e) {
            System.out.println("Fehler beim Lesen: " + e.getMessage());
        }


        for (int i = 0; i < eingabe.size(); i++){
            if (eingabe.get(i).equals("!")){
                lineCounter++;
                eingabe.remove(i);
                i--;
            }
            else if (eingabe.get(i).contains("!")){
                lineCounter++;
                line.add(lineCounter);
                eingabe.set(i, eingabe.get(i).substring(1));
            }
            else {
                line.add(lineCounter);
            }
        }


        for (int i = 0; i < eingabe.size(); i++){
            System.out.println("Gelesenes Wort: " + eingabe.get(i) + " in Zeile: " + line.get(i));
        }


        String[] sortArr = new String[eingabe.size()];
        int arrCounter = 0;
        for (String wort : eingabe) {
            sortArr[arrCounter] = wort;
            arrCounter++;
        }

        Map<String, ArrayList<Integer>> sortedWB = new TreeMap<>();
        for (String s : sortArr) {
            if (!sortedWB.containsKey(s)) {
                sortedWB.put(s, null);
            }
        }

        ArrayList<Integer> zeilen = new ArrayList<>();
        int index;

        for (Map.Entry<String, ArrayList<Integer>> wort : sortedWB.entrySet()){
            zeilen.clear();
            while (eingabe.contains(wort.getKey())){
                index = eingabe.indexOf(wort.getKey());
                zeilen.add(line.get(index));
                eingabe.remove(index);
                line.remove(index);
            }
            wort.setValue(zeilen);
            System.out.println("'" + wort.getKey() +"'" + " kommt in  Zeile" + wort.getValue() + " also " + wort.getValue().size() + " mal vor");
        }

    }
}
