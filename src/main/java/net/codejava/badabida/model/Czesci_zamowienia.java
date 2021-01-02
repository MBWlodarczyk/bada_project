package net.codejava.badabida.model;

public class Czesci_zamowienia {

    private int nr_czesci;
    private int nr_zamowienia;
    private int ilosc;

    public Czesci_zamowienia(int nr_czesci, int nr_zamowienia, int ilosc) {
        this.nr_czesci = nr_czesci;
        this.nr_zamowienia = nr_zamowienia;
        this.ilosc = ilosc;
    }

    public int getNr_czesci() {
        return nr_czesci;
    }

    public void setNr_czesci(int nr_czesci) {
        this.nr_czesci = nr_czesci;
    }

    public int getNr_zamowienia() {
        return nr_zamowienia;
    }

    public void setNr_zamowienia(int nr_zamowienia) {
        this.nr_zamowienia = nr_zamowienia;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }
}
