package net.codejava.badabida.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "magazyny_czesci")
public class Magazyny_czesci implements Serializable {

    @EmbeddedId
    private Magazyny_czesci_id magazyny_czesci_id= new Magazyny_czesci_id();

    @ManyToOne
    //@MapsId("NR_MAGAZYNU")
    private Magazyn magazyn;

    @ManyToOne
    //@MapsId("NR_CZESCI")
    private Czesc czesc;

    @Column(name = "ILOSC")
    private Long ilosc;

    public Magazyny_czesci() {
    }

    public Magazyny_czesci_id getMagazyny_czesci_id() {
        return magazyny_czesci_id;
    }

    public void setMagazyny_czesci_id(Magazyny_czesci_id magazyny_czesci_id) {
        this.magazyny_czesci_id = magazyny_czesci_id;
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
