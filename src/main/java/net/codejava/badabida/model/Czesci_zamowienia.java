package net.codejava.badabida.model;

import javax.persistence.*;

@Entity
@Table(name = "czesci_zamowienia")
public class Czesci_zamowienia {

    @ManyToOne
    @MapsId("nr_czesci")
    private int nr_czesci;

    @ManyToOne
    @MapsId("nr_zamowienia")
    private int nr_zamowienia;

    @Column(name = "ilosc")
    private int ilosc;

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

    @Override
    public String toString() {
        return "Czesci_zamowienia{" +
                "nr_czesci=" + nr_czesci +
                ", nr_zamowienia=" + nr_zamowienia +
                ", ilosc=" + ilosc +
                '}';
    }
}
