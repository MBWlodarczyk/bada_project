package net.codejava.badabida.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "czesci")
@SequenceGenerator(name = "nr_czesci_ai", sequenceName = "nr_czesci_ai", allocationSize = 0)
public class Czesc implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nr_czesci_ai")
    @Column(updatable = false, nullable = false)
    private Long nrCzesci;

    @Column(name = "CENA")
    private BigDecimal cena;

    @Column(name = "NAZWA")
    private String nazwa;

    @Column(name = "CZAS_GWARANCJI")
    private int czasGwarancji;

    @Column(name = "PRODUCENT")
    private String producent;

    @OneToMany(mappedBy = "czesc",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<CzesciZamowienia> zamowienia;

    public Czesc() {
    }

    public Czesc(Long nr_czesci, BigDecimal cena, String nazwa, int czas_gwarancji, String producent) {
        this.nrCzesci = nr_czesci;
        this.cena = cena;
        this.nazwa = nazwa;
        this.czasGwarancji = czas_gwarancji;
        this.producent = producent;
    }

    public Long getNrCzesci() {
        return nrCzesci;
    }

    public void setNrCzesci(Long nr_czesci) {
        this.nrCzesci = nr_czesci;
    }

    public BigDecimal getCena() {
        return cena;
    }

    public void setCena(BigDecimal cena) {
        this.cena = cena;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getCzasGwarancji() {
        return czasGwarancji;
    }

    public void setCzasGwarancji(int czas_gwarancji) {
        this.czasGwarancji = czas_gwarancji;
    }

    public String getProducent() {
        return producent;
    }

    public void setProducent(String producent) {
        this.producent = producent;
    }

    @Override
    public String toString() {
        return "Czesc{" +
                "nr_czesci=" + nrCzesci +
                ", cena=" + cena +
                ", nazwa='" + nazwa + '\'' +
                ", czas_gwarancji=" + czasGwarancji +
                ", producent='" + producent + '\'' +
                '}';
    }
}
