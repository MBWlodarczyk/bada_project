package net.codejava.badabida.model;

public class Zamowienia_klient {
    private int nr_zamowienia;
    private int nr_klienta;

    public Zamowienia_klient(int nr_zamowienia, int nr_klienta) {
        this.nr_zamowienia = nr_zamowienia;
        this.nr_klienta = nr_klienta;
    }

    public int getNr_zamowienia() {
        return nr_zamowienia;
    }

    public void setNr_zamowienia(int nr_zamowienia) {
        this.nr_zamowienia = nr_zamowienia;
    }

    public int getNr_klienta() {
        return nr_klienta;
    }

    public void setNr_klienta(int nr_klienta) {
        this.nr_klienta = nr_klienta;
    }
}
