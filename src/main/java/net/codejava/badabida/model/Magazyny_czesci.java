package net.codejava.badabida.model;

import javax.persistence.*;

@Entity
@Table(name = "MAGAZYNY_CZESCI")
public class Magazyny_czesci {

    @ManyToOne
    @MapsId("NR_MAGAZYNU")
    private Magazyn magazyn;

    @ManyToOne
    @MapsId("NR_CZESCI")
    private Czesc czesc;

    @Column(name = "ILOSC")
    private Long ilosc;

    public Magazyny_czesci() {
    }

    public Magazyny_czesci(Magazyn magazyn, Czesc czesc, Long ilosc) {
        this.magazyn = magazyn;
        this.czesc = czesc;
        this.ilosc = ilosc;
    }

    @Override
    public String toString() {
        return "Magazyny_czesci{" +
                "magazyn=" + magazyn +
                ", czesc=" + czesc +
                ", ilosc=" + ilosc +
                '}';
    }

    public Magazyn getMagazyn() {
        return magazyn;
    }

    public void setMagazyn(Magazyn magazyn) {
        this.magazyn = magazyn;
    }

    public Czesc getCzesc() {
        return czesc;
    }

    public void setCzesc(Czesc czesc) {
        this.czesc = czesc;
    }

    public Long getIlosc() {
        return ilosc;
    }

    public void setIlosc(Long ilosc) {
        this.ilosc = ilosc;
    }
}
