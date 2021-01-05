package net.codejava.badabida.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "hurtownie")
public class Hurtownia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Long nr_hurtowni;

    @Column(name = "NAZWA")
    private String nazwa;

    @Column(name = "DATA_ZALOZENIA")
    private Timestamp data_zalozenia;

    @OneToOne
    //@MapsId("NR_ADRESU") //TODO też nie
    private Adres adres;

    public Hurtownia() {
    }

    public Hurtownia(Long nr_hurtowni, String nazwa, Timestamp data_zalozenia, Adres adres) {
        this.nr_hurtowni = nr_hurtowni;
        this.nazwa = nazwa;
        this.data_zalozenia = data_zalozenia;
        this.adres = adres;
    }

    @Override
    public String toString() {
        return "Hurtownia{" +
                "nr_hurtowni=" + nr_hurtowni +
                ", nazwa='" + nazwa + '\'' +
                ", data_zalozenia=" + data_zalozenia +
                ", adres=" + adres +
                '}';
    }

    public Long getNr_hurtowni() {
        return nr_hurtowni;
    }

    public void setNr_hurtowni(Long nr_hurtowni) {
        this.nr_hurtowni = nr_hurtowni;
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

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }
}


