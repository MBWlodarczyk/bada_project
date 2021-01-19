package net.codejava.badabida.model;

import org.hibernate.annotations.SortNatural;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "magazyny_czesci")
public class MagazynyCzesci implements Serializable, Comparable<MagazynyCzesci> {

    @EmbeddedId
    private MagazynyCzesciId magazynyCzesciId = new MagazynyCzesciId();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("nrMagazynu")
    @JoinColumn(name = "nr_magazynu")
    private Magazyn magazyn;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("nrCzesci")
    @JoinColumn(name = "nr_czesci")
    @SortNatural
    private Czesc czesc;

    @Column(name = "ILOSC")
    private Long ilosc;


    public MagazynyCzesci(Magazyn magazyn, Czesc czesc, Long ilosc) {
        this.magazyn = magazyn;
        this.czesc = czesc;
        this.ilosc = ilosc;
        this.magazynyCzesciId = new MagazynyCzesciId(magazyn.getNrMagazynu(), czesc.getNrCzesci());
    }

    public MagazynyCzesci() {
    }

    public MagazynyCzesci(MagazynyCzesciId magazynyCzesciId, Magazyn magazyn, Czesc czesc, Long ilosc) {
        this.magazynyCzesciId = magazynyCzesciId;
        this.magazyn = magazyn;
        this.czesc = czesc;
        this.ilosc = ilosc;
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

    @Override
    public int compareTo(MagazynyCzesci o) {
        return czesc.compareTo(o.getCzesc());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MagazynyCzesci that = (MagazynyCzesci) o;
        return Objects.equals(magazynyCzesciId, that.magazynyCzesciId) && Objects.equals(magazyn, that.magazyn) && czesc.equals(that.czesc) && Objects.equals(ilosc, that.ilosc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(magazynyCzesciId, magazyn, czesc, ilosc);
    }
}
