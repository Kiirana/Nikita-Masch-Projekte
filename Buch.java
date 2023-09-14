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
