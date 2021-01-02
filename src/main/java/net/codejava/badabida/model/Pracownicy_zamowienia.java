package net.codejava.badabida.model;

public class Pracownicy_zamowienia {
    private int nr_pracownika;
    private int nr_zamowienia;

    public Pracownicy_zamowienia(int nr_pracownika, int nr_zamowienia) {
        this.nr_pracownika = nr_pracownika;
        this.nr_zamowienia = nr_zamowienia;
    }

    public int getNr_pracownika() {
        return nr_pracownika;
    }

    public void setNr_pracownika(int nr_pracownika) {
        this.nr_pracownika = nr_pracownika;
    }

    public int getNr_zamowienia() {
        return nr_zamowienia;
    }

    public void setNr_zamowienia(int nr_zamowienia) {
        this.nr_zamowienia = nr_zamowienia;
    }
}
