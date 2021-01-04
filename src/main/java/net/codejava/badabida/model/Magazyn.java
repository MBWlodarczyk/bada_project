package net.codejava.badabida.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "magazyny")
public class Magazyn {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "NR_MAGAZYNU", updatable = false, nullable = false)
    private Long nr_magazynu;

    @Column(name = "NAZWA")
    private String nazwa;

    @Column(name = "DATA_ZALOZENIA")
    private Timestamp data_zalozenia;

    @ManyToOne
    @MapsId("NR_HURTOWNI")
    private Hurtownia hurtownia;

    @OneToOne
    //@MapsId("NR_ADRESU")
    private Adres adres; //TODO czy tutaj ma bycć MapsID?

    public Magazyn() {
    }

    @Override
    public String toString() {
        return "Magazyn{" +
                "nr_magazynu=" + nr_magazynu +
                ", nazwa='" + nazwa + '\'' +
                ", data_zalozenia=" + data_zalozenia +
                ", hurtownia=" + hurtownia +
                ", adres=" + adres +
                '}';
    }

    public Long getNr_magazynu() {
        return nr_magazynu;
    }

    public void setNr_magazynu(Long nr_magazynu) {
        this.nr_magazynu = nr_magazynu;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Timestamp getData_zalozenia() {
        return data_zalozenia;
    }

    public void setData_zalozenia(Timestamp data_zalozenia) {
        this.data_zalozenia = data_zalozenia;
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
        this.nr_magazynu = nr_magazynu;
        this.nazwa = nazwa;
        this.data_zalozenia = data_zalozenia;
        this.hurtownia = hurtownia;
        this.adres = adres;
    }
}
