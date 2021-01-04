package net.codejava.badabida.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "czesci")
public class Czesc implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Long nr_czesci;

    @Column(name = "CENA")
    private BigDecimal cena;

    @Column(name = "NAZWA")
    private String nazwa;

    @Column(name = "CZAS_GWARANCJI")
    private int czas_gwarancji;

    @Column(name = "PRODUCENT")
    private String producent;

    public Czesc() {
    }

    public Czesc(Long nr_czesci, BigDecimal cena, String nazwa, int czas_gwarancji, String producent) {
        this.nr_czesci = nr_czesci;
        this.cena = cena;
        this.nazwa = nazwa;
        this.czas_gwarancji = czas_gwarancji;
        this.producent = producent;
    }

    public Long getNr_czesci() {
        return nr_czesci;
    }

    public void setNr_czesci(Long nr_czesci) {
        this.nr_czesci = nr_czesci;
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

    public int getCzas_gwarancji() {
        return czas_gwarancji;
    }

    public void setCzas_gwarancji(int czas_gwarancji) {
        this.czas_gwarancji = czas_gwarancji;
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
                "nr_czesci=" + nr_czesci +
                ", cena=" + cena +
                ", nazwa='" + nazwa + '\'' +
                ", czas_gwarancji=" + czas_gwarancji +
                ", producent='" + producent + '\'' +
                '}';
    }
}
