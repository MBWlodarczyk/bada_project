package net.codejava.badabida.model;

public class Magazyny_czesci {
    private int nr_magazynu;
    private int nr_czesci;
    private int ilosc;

    public Magazyny_czesci(int nr_magazynu, int nr_czesci, int ilosc) {
        this.nr_magazynu = nr_magazynu;
        this.nr_czesci = nr_czesci;
        this.ilosc = ilosc;
    }

    public int getNr_magazynu() {
        return nr_magazynu;
    }

    public void setNr_magazynu(int nr_magazynu) {
        this.nr_magazynu = nr_magazynu;
    }

    public int getNr_czesci() {
        return nr_czesci;
    }

    public void setNr_czesci(int nr_czesci) {
        this.nr_czesci = nr_czesci;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }
}
