package net.codejava.badabida.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "czesci_zamowienia")
public class CzesciZamowienia implements Serializable {

    @EmbeddedId
    private CzesciZamowieniaId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("nrCzesci")
    @JoinColumn(name = "nr_czesci")
    private Czesc czesc;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("nrZamowienia")
    @JoinColumn(name = "nr_zamowienia")
    private Zamowienie zamowienie;

    @Column(name = "ILOSC")
    private int ilosc;

    public CzesciZamowienia() {
    }

    public CzesciZamowienia(Czesc czesc, Zamowienie zamowienie, int ilosc) {
        this.czesc = czesc;
        this.ilosc = ilosc;
        this.zamowienie = zamowienie;
        this.id = new CzesciZamowieniaId(czesc.getNrCzesci(), zamowienie.getNrZamowienia());
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

    public CzesciZamowieniaId getId() {
        return id;
    }

    public void setId(CzesciZamowieniaId id) {
        this.id = id;
    }
}
