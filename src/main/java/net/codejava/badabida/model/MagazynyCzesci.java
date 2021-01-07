package net.codejava.badabida.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "magazyny_czesci")
public class MagazynyCzesci implements Serializable {

    @EmbeddedId
    private MagazynyCzesciId magazynyCzesciId = new MagazynyCzesciId();

    @ManyToOne
    //@MapsId("NR_MAGAZYNU")
    private Magazyn magazyn;

    @ManyToOne
    //@MapsId("NR_CZESCI")
    private Czesc czesc;

    @Column(name = "ILOSC")
    private Long ilosc;

    public MagazynyCzesci() {
    }

    public MagazynyCzesciId getMagazynyCzesciId() {
        return magazynyCzesciId;
    }

    public void setMagazynyCzesciId(MagazynyCzesciId magazyny_czesci_id) {
        this.magazynyCzesciId = magazyny_czesci_id;
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
