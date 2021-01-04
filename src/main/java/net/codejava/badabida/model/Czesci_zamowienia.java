package net.codejava.badabida.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "czesci_zamowienia")
public class Czesci_zamowienia implements Serializable {

    @EmbeddedId
    private Czesci_zamowienia_id czesci_zamowienia_id = new Czesci_zamowienia_id();

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

}
