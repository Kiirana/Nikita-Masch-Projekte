package com.example.library;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloApplication extends Application {
    Stage window;


    @Override
    public void start(Stage stage) throws IOException {
        Bibliotheksverwaltung neu = new Bibliotheksverwaltung();
        neu.nutzerHinzufuegen("Nikita", "Masch");
        neu.nutzerHinzufuegen("Steven", "Edy");
        neu.legeBuchAn("The Man Who Mistook His Wife For a Hat", "Oliver Sacks", "1", true);
        neu.legeBuchAn("The Stranger  ", "Albert Camus", "2", true);

        window = stage;
        Label nutzerText = new Label();
        String css = "file:///C:/Library/src/main/java/com/example/library/style.css";

        ImageView background1 = new ImageView(new Image("C:\\Users\\Admin\\Downloads\\open-book-illustration-reflection-black-background-red-1920x1080-5478 (3).jpg"));
        background1.setFitHeight(1080);
        background1.setFitWidth(1920);
        ImageView background2 = new ImageView(new Image("C:\\Users\\Admin\\Downloads\\open-book-illustration-reflection-black-background-red-1920x1080-5478 (3).jpg"));
        background2.setFitHeight(1080);
        background2.setFitWidth(1920);
        ImageView background3 = new ImageView(new Image("C:\\Users\\Admin\\Downloads\\open-book-illustration-reflection-black-background-red-1920x1080-5478 (3).jpg"));
        background3.setFitHeight(1080);
        background3.setFitWidth(1920);
        ImageView background4 = new ImageView(new Image("C:\\Users\\Admin\\Downloads\\open-book-illustration-reflection-black-background-red-1920x1080-5478 (3).jpg"));
        background4.setFitHeight(1080);
        background4.setFitWidth(1920);
        ImageView background5 = new ImageView(new Image("C:\\Users\\Admin\\Downloads\\open-book-illustration-reflection-black-background-red-1920x1080-5478 (3).jpg"));
        background5.setFitHeight(1080);
        background5.setFitWidth(1920);
        ImageView background6 = new ImageView(new Image("C:\\Users\\Admin\\Downloads\\open-book-illustration-reflection-black-background-red-1920x1080-5478 (3).jpg"));
        background6.setFitHeight(1080);
        background5.setFitWidth(1920);
        ImageView background7 = new ImageView(new Image("C:\\Users\\Admin\\Downloads\\open-book-illustration-reflection-black-background-red-1920x1080-5478 (3).jpg"));
        background7.setFitHeight(1080);
        background5.setFitWidth(1920);

        StackPane pane1 = new StackPane();
        StackPane pane2 = new StackPane();
        StackPane pane3 = new StackPane();
        StackPane pane4 = new StackPane();
        StackPane pane5 = new StackPane();
        StackPane pane6 = new StackPane();
        StackPane pane7 = new StackPane();


        Label Vorname = new Label("Vorname");
        Label Nachname = new Label("Name");

        TextField fuerVorname = new TextField();
        fuerVorname.setPromptText("Vorname");
        TextField fuerNachname = new TextField();
        fuerNachname.setPromptText("Nachname");


        Button submit1 = new Button("Eingabe");


        GridPane gridPaneName = new GridPane();


        gridPaneName.setVgap(10);
        gridPaneName.setHgap(10);
        Button exit1 = new Button("Zurueck");
        Button exit11 = new Button("Zurueck");

        gridPaneName.add(Vorname, 4, 0);
        gridPaneName.add(Nachname, 8, 0);
        gridPaneName.add(fuerVorname, 4, 1);
        gridPaneName.add(fuerNachname, 8, 1);
        gridPaneName.add(submit1, 5, 3);
        gridPaneName.add(exit11, 10, 10);
        gridPaneName.setAlignment(Pos.CENTER);
        pane1.getChildren().addAll(background1, gridPaneName);

        Scene scenario1 = new Scene(pane1, 1920, 1080);

        Label buchTitel1 = new Label("Buch Titel ");
        Label buchAutor1 = new Label("Buch Autor");
        Label buchIsbn1 = new Label("Buch ISBN");
        TextField buchTitel = new TextField();
        TextField buchAutor = new TextField();
        TextField buchIsbn = new TextField();
        buchTitel.setPromptText("Titel");
        buchAutor.setPromptText("Autor");
        buchIsbn.setPromptText("ISBN-Nummer");
        Button submit3 = new Button("Eingabe");
        GridPane gridPaneName3 = new GridPane();

        gridPaneName.setVgap(10);
        gridPaneName.setHgap(10);
        Button exit3 = new Button("Zurueck");
        Button exit31 = new Button("Zurueck");

        gridPaneName3.add(buchTitel1, 0, 0);
        gridPaneName3.add(buchAutor1, 1, 0);
        gridPaneName3.add(buchIsbn1, 2, 0);
        gridPaneName3.add(buchTitel, 0, 3);
        gridPaneName3.add(submit3, 4, 3);
        gridPaneName3.add(buchAutor, 1, 3);
        gridPaneName3.add(buchIsbn, 2, 3);
        gridPaneName3.add(exit31, 10, 10);
        gridPaneName3.setAlignment(Pos.CENTER);

        pane2.getChildren().addAll(background2, gridPaneName3);
        Scene scene3 = new Scene(pane2, 1920, 1080);


        Label nutzerLabel = new Label();
        nutzerLabel.setText(ausgabeListNutzer(neu));
        Label buecherLabel = new Label();
        buecherLabel.setText(ausgabeListeBuecher(neu));


        Label nutzerTextf = new Label();
        Label nutzerBuecher = new Label();
        nutzerTextf.setText(ausgabeListNutzer(neu));
        nutzerBuecher.setText(ausgabeListeBuecher(neu));
        Label nutzerTextf5 = nutzerTextf;
        Label nutzerBuecher5 = nutzerBuecher;
        Button exit = new Button("Zurück");
        Button exit4 = new Button("Zurück");

        GridPane gridPane4 = new GridPane();
        gridPane4.setHgap(10);
        gridPane4.setVgap(10);

        Label nutzer = new Label("Nutzer");
        Label buecher = new Label("Bücher");
        Label nutzerNeu = new Label("Nutzer");
        Label buecherNeu = new Label("Bücher");
        TextField nutzerText1 = new TextField();
        nutzerText1.setPromptText("Nutzer-Zahl Eingabe");

        TextField buecherText1 = new TextField();
        buecherText1.setPromptText("Buch-Zahl Eingabe");

        ImageView background = new ImageView(new Image("C:\\Users\\Admin\\Downloads\\open-book-illustration-reflection-black-background-red-1920x1080-5478 (3).jpg"));
        StackPane gridpane4Back = new StackPane();
        background.setFitWidth(1920);
        background.setFitHeight(1080);


        gridPane4.setAlignment(Pos.CENTER);
        gridPane4.add(nutzerNeu, 5, 3);
        gridPane4.add(buecherNeu, 1, 3);
        gridPane4.add(nutzerLabel, 5, 7);
        gridPane4.add(buecherLabel, 1, 7);
        gridPane4.add(nutzerText1, 5, 5);
        gridPane4.add(buecherText1, 1, 5);
        Button submit4 = new Button("Eingabe");
        gridPane4.add(submit4, 6, 8);
        gridPane4.add(exit1, 8, 8);
        gridpane4Back.getChildren().addAll(background, gridPane4);


        Scene scene4 = new Scene(gridpane4Back, 1920, 1080);


        GridPane pane41 = new GridPane();
        Text date1 = new Text();
        pane41.setAlignment(Pos.CENTER);
        pane41.setHgap(10);
        pane41.setVgap(10);

        Button exit6 = new Button("Zurück");

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd - HH:mm:ss ");
        Date currentTime = new Date();
        Label newDate = new Label();
        date1.setText(formatter.format(currentTime) + '\n');

        newDate.setText(date1.getText().toString());
        pane41.add(newDate, 0, 0);
        pane41.add(exit6, 1, 2);
        pane4.getChildren().addAll(background4, pane41);

        Scene scene41 = new Scene(pane4, 1920, 1080);
        submit4.setOnAction(e -> {
                    window.setScene(scene41);
                    neu.buchAusleihen(Integer.parseInt(nutzerText1.getText()), buecherText1.getText());

                    Buch tm = BibliotheksDatenbank.gibBuch(buecherText1.getText());
                    tm.setFalse();


                    newDate.setText(" 14 Tage Ausleihe ab dem " + formatter.format(currentTime) + " fuer das Buch " + tm.getTitel());

                    nutzerTextf5.setText(ausgabeListNutzer(neu));
                    nutzerBuecher5.setText(ausgabeListeBuecher(neu));
                    buecherLabel.setText(ausgabeListeBuecher(neu));
                    nutzerLabel.setText(ausgabeListNutzer(neu));
                    buecherText1.clear();
                    nutzerText1.clear();


                }

        );


        GridPane gridPane5 = new GridPane();
        gridPane5.setHgap(10);
        gridPane5.setVgap(10);


        TextField nutzerText15 = new TextField();
        nutzerText15.setPromptText("Nutzer-Zahl Eingabe");

        TextField buecherText15 = new TextField();
        buecherText15.setPromptText("Buch-Zahl Eingabe");
        gridPane5.setAlignment(Pos.CENTER);
        gridPane5.add(nutzer, 5, 1);
        gridPane5.add(buecher, 5, 4);
        gridPane5.add(nutzerTextf5, 3, 1);
        gridPane5.add(nutzerBuecher5, 3, 4);
        gridPane5.add(nutzerText15, 7, 1);
        gridPane5.add(buecherText15, 7, 4);
        gridPane5.add(exit, 9, 8);
        Button submit5 = new Button("Eingabe");
        gridPane5.add(submit5, 8, 8);
        pane5.getChildren().addAll(background5, gridPane5);
        Scene scene5 = new Scene(pane5, 1920, 1080);


        Label text = new Label("Rückgabe erfolgreich am " + date1.getText());
        GridPane pane51 = new GridPane();
        pane51.setAlignment(Pos.CENTER);
        pane51.setVgap(10);
        pane51.setHgap(10);
        pane51.add(text, 0, 0);

        pane51.add(exit3, 1, 2);

        pane3.getChildren().addAll(background3, pane51);


        Scene scene51 = new Scene(pane3, 1920, 1080);

        submit5.setOnAction(e -> {
                    window.setScene(scene51);


                    neu.gebeBuchzurueck(Integer.parseInt(nutzerText15.getText()), buecherText15.getText());

                    nutzerLabel.setText(ausgabeListNutzer(neu));
                    buecherLabel.setText(ausgabeListeBuecher(neu));
                    nutzerBuecher5.setText(ausgabeListeBuecher(neu));
                    nutzerTextf5.setText(ausgabeListNutzer(neu));
                    buecherText1.clear();
                    nutzerText1.clear();

                    nutzerText15.clear();
                    buecherText15.clear();

                }
        );


        window.setTitle("Bibliothekssystem");
        window.setOnCloseRequest(e -> close());


        Button button1 = new Button("Nutzer anlegen ");
        button1.setPrefSize(300, 30);

        Button button2 = new Button("Nutzer loeschen");
        button2.setPrefSize(300, 30);
        Button button3 = new Button("Buch aufnehemen");
        button3.setPrefSize(300, 30);
        Button button4 = new Button("Buch ausleihen");
        button4.setPrefSize(300, 30);
        Button button5 = new Button(" Rückgabe eines Buches");
        button5.setPrefSize(300, 30);
        Button button6 = new Button("Beenden");
        button6.setPrefSize(300, 30);

        Label text1 = new Label();

        VBox vBox = new VBox(10);
        vBox.setAlignment(Pos.CENTER);

        VBox vBox1 = new VBox(10);
        vBox1.setAlignment(Pos.CENTER);

        vBox1.getChildren().addAll(text1);

        GridPane vBox2 = new GridPane();


        nutzerText.setText(ausgabeListNutzer(neu));
        nutzerText.setStyle("");
        Button submit2 = new Button("Eingabe");

        TextField loesche = new TextField();
        loesche.setPrefSize(100, 30);

        loesche.setPrefSize(300, 10);
        loesche.setPromptText("Nutzer Nummer");


        vBox2.add(loesche, 3, 4);
        vBox2.add(submit2, 5, 6);
        vBox2.add(nutzerText, 3, 8);
        vBox2.add(exit4, 5, 11);
        vBox2.setAlignment(Pos.CENTER);

        pane6.getChildren().addAll(background6, vBox2);


        Scene scene2 = new Scene(pane6, 1920, 1080);


        vBox.getChildren().addAll(button1, button2, button3, button4, button5, button6);

        pane7.getChildren().addAll(background7, vBox);

        Scene scene = new Scene(pane7, 1920, 1080);


        button1.setOnAction(e -> {
            window.setScene(scenario1);

        });

        submit1.setOnAction(e -> {
                    window.setScene(scene);
                    String nutzerVorname = fuerVorname.getText().toString();
                    String nutzerNachname = fuerNachname.getText().toString();
                    neu.nutzerHinzufuegen(nutzerNachname, nutzerVorname);
                    nutzerText.setText(ausgabeListNutzer(neu));
                    fuerNachname.clear();
                    fuerVorname.clear();


                }
        );

        submit2.setOnAction(e -> {
            window.setScene(scene);
            String input = loesche.getText();
            neu.nutzerLoeschen(Integer.parseInt(input));
            nutzerText.setText(ausgabeListNutzer(neu));
            nutzerLabel.setText(ausgabeListNutzer(neu));
            nutzerBuecher5.setText(ausgabeListeBuecher(neu));
            nutzerTextf5.setText(ausgabeListNutzer(neu));
            loesche.clear();


        });


        exit.setOnAction(e -> window.setScene(scene));
        button2.setOnAction(e -> window.setScene(scene2));


        button3.setOnAction(e -> window.setScene(scene3));
        button4.setOnAction(e -> window.setScene(scene4));


        submit3.setOnAction(e -> {

            neu.legeBuchAn(buchTitel.getText(), buchAutor.getText(),
                    buchIsbn.getText(), true);
            nutzerLabel.setText(ausgabeListNutzer(neu));

            buecherLabel.setText(ausgabeListeBuecher(neu));
            nutzerBuecher5.setText(ausgabeListeBuecher(neu));
            nutzerTextf5.setText(ausgabeListNutzer(neu));
            buchTitel.clear();
            buchAutor.clear();
            buchIsbn.clear();

            window.setScene(scene);

        });

        button5.setOnAction(e -> window.setScene(scene5));
        button6.setOnAction(e -> close());
        exit1.setOnAction(e -> window.setScene(scene));
        exit3.setOnAction(e -> window.setScene(scene));
        exit4.setOnAction(e -> window.setScene(scene));
        exit6.setOnAction(e -> window.setScene(scene));
        exit31.setOnAction(e -> window.setScene(scene));
        exit11.setOnAction(e -> window.setScene(scene));


        scene.getStylesheets().add(css);
        scene3.getStylesheets().add(css);
        scene4.getStylesheets().add(css);
        scene2.getStylesheets().add(css);
        scene41.getStylesheets().add(css);
        scene5.getStylesheets().add(css);
        scene51.getStylesheets().add(css);
        scenario1.getStylesheets().add(css);


        window.setScene(scene);
        window.show();


    }

    public void close() {

        window.close();

    }

    public static String ausgabeListeBuecher(Bibliotheksverwaltung bi) {
        StringBuilder value = new StringBuilder();
        String[] buechername = bi.bestandBuecher();
        String[] buecherisbn = bi.gebeAlleBuecherId();

        for (int i = 0; i < buechername.length; i++) {
            value.append(buecherisbn[i] + ". " + buechername[i] + "\n");
        }

        return "Buch-Liste" + "\n" + "\n" + value.toString();


    }

    public static String ausgabeListNutzer(Bibliotheksverwaltung bi) {

        StringBuilder output = new StringBuilder();
        String[] array = bi.gebeAlleNutzerName();
        Integer[] arrayid = bi.gebeAlleNutzerId();
        for (int i = 0; i < array.length; i++) {
            output.append(arrayid[i] + ". " + array[i] + '\n');

        }

        return "Nutzer-Liste" + "\n" + "\n" + output.toString();

    }


    public static void main(String[] args) {

        launch();
    }
}



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





package com.example.library;
public class Buch {

    private String isbn;
    private String titel;
    private String autor;
    private boolean verfuegbarkeit;


    Buch(String titel, String autor, String isbn , boolean verfuegbarkeit ){
        this.titel = titel;
        this.autor = autor;
        this.isbn = isbn;
        this.verfuegbarkeit = verfuegbarkeit;

    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isVerfuegbarkeit() {
        return verfuegbarkeit;
    }

    public void setVerfuegbarkeit(boolean verfuegbarkeit) {
        this.verfuegbarkeit = verfuegbarkeit;
    }

    public void setFalse(){
        setVerfuegbarkeit(false);
    }




}


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


.text-field {
    -fx-background-color: #090a0c, linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%), linear-gradient(#20262b, #191d22), radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), rgba(255,255,255,0));
    -fx-background-radius: 5,4,3,5;
    -fx-background-insets: 0,1,2,0;
    -fx-text-fill: white;
    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );
    -fx-font-family: "Arial";
    -fx-font-size: 18px;
    -fx-padding: 10 20 10 20;
}

.label {
    -fx-background-color: #090a0c, linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%), linear-gradient(#20262b, #191d22), radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), rgba(255,255,255,0));
    -fx-background-radius: 5,4,3,5;
    -fx-background-insets: 0,1,2,0;
    -fx-text-fill: white;
    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );
    -fx-font-family: "Arial";
    -fx-font-size: 18px;
    -fx-padding: 10 20 10 20;
}

.text {
    -fx-background-color: #090a0c, linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%), linear-gradient(#20262b, #191d22), radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), rgba(255,255,255,0));
    -fx-background-radius: 5,4,3,5;
    -fx-background-insets: 0,1,2,0;
    -fx-text-fill: white;
    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );
    -fx-font-family: "Arial";

    -fx-padding: 10 20 10 20;
    -fx-font-size: 18px;

}

.button {
    -fx-background-color: #090a0c, linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%), linear-gradient(#20262b, #191d22), radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), rgba(255,255,255,0));
    -fx-background-radius: 5,4,3,5;
    -fx-background-insets: 0,1,2,0;
    -fx-text-fill: white;
    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );
    -fx-font-family: "Arial";
    -fx-font-size: 12px;
    -fx-padding: 10 20 10 20;
}
