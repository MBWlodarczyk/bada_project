package net.codejava.badabida.model;

public class Wlasciciel {
    private int nr_wlasciciela;
    private String imie;
    private String nazwisko;
    private String telefon;
    private int nr_hurtowni;

    public Wlasciciel(int nr_wlasciciela, String imie, String nazwisko, String telefon, int nr_hurtowni) {
        this.nr_wlasciciela = nr_wlasciciela;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.telefon = telefon;
        this.nr_hurtowni = nr_hurtowni;
    }

    public int getNr_wlasciciela() {
        return nr_wlasciciela;
    }

    public void setNr_wlasciciela(int nr_wlasciciela) {
        this.nr_wlasciciela = nr_wlasciciela;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public int getNr_hurtowni() {
        return nr_hurtowni;
    }

    public void setNr_hurtowni(int nr_hurtowni) {
        this.nr_hurtowni = nr_hurtowni;
    }
}
