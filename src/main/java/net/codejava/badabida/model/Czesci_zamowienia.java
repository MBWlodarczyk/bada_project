package net.codejava.badabida.model;

import javax.persistence.*;

@Entity
@Table(name = "CZESCI_ZAMOWIENIA")
public class Czesci_zamowienia {

    @ManyToOne
    @MapsId("NR_CZESCI")
    private Czesc czesc;

    @ManyToOne
    @MapsId("NR_ZAMOWIENIA")
    private Zamowienie zamowienie;

    @Column(name = "ILOSC")
    private int ilosc;

    public Czesci_zamowienia() {
    }

    @Override
    public String toString() {
        return "Czesci_zamowienia{" +
                "czesc=" + czesc +
                ", zamowienie=" + zamowienie +
                ", ilosc=" + ilosc +
                '}';
    }

    public Czesc getCzesc() {
        return czesc;
    }

    public void setCzesc(Czesc czesc) {
        this.czesc = czesc;
    }

    public Zamowienie getZamowienie() {
        return zamowienie;
    }

    public void setZamowienie(Zamowienie zamowienie) {
        this.zamowienie = zamowienie;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }

    public Czesci_zamowienia(Czesc czesc, Zamowienie zamowienie, int ilosc) {
        this.czesc = czesc;
        this.zamowienie = zamowienie;
        this.ilosc = ilosc;
    }
}
