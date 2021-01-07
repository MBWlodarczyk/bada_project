package net.codejava.badabida.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "magazyny")
public class Magazyn implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Long nrMagazynu;

    @Column(name = "NAZWA")
    private String nazwa;

    @Column(name = "DATA_ZALOZENIA")
    private Timestamp dataZalozenia;

    @ManyToOne
    //@MapsId("NR_HURTOWNI")
    private Hurtownia hurtownia;

    @OneToOne
    //@MapsId("NR_ADRESU")
    private Adres adres; //TODO czy tutaj ma bycć MapsID?

    public Magazyn() {
    }

    @Override
    public String toString() {
        return "Magazyn{" +
                "nr_magazynu=" + nrMagazynu +
                ", nazwa='" + nazwa + '\'' +
                ", data_zalozenia=" + dataZalozenia +
                ", hurtownia=" + hurtownia +
                ", adres=" + adres +
                '}';
    }

    public Long getNrMagazynu() {
        return nrMagazynu;
    }

    public void setNrMagazynu(Long nr_magazynu) {
        this.nrMagazynu = nr_magazynu;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Timestamp getDataZalozenia() {
        return dataZalozenia;
    }

    public void setDataZalozenia(Timestamp data_zalozenia) {
        this.dataZalozenia = data_zalozenia;
    }

    public Hurtownia getHurtownia() {
        return hurtownia;
    }

    public void setHurtownia(Hurtownia hurtownia) {
        this.hurtownia = hurtownia;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public Magazyn(Long nr_magazynu, String nazwa, Timestamp data_zalozenia, Hurtownia hurtownia, Adres adres) {
        this.nrMagazynu = nr_magazynu;
        this.nazwa = nazwa;
        this.dataZalozenia = data_zalozenia;
        this.hurtownia = hurtownia;
        this.adres = adres;
    }
}
