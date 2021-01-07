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
    private Long nrHurtowni;

    @Column(name = "NAZWA")
    private String nazwa;

    @Column(name = "DATA_ZALOZENIA")
    private Timestamp dataZalozenia;

    @OneToOne
    //@MapsId("NR_ADRESU") //TODO też nie
    private Adres adres;

    public Hurtownia() {
    }

    public Hurtownia(Long nr_hurtowni, String nazwa, Timestamp data_zalozenia, Adres adres) {
        this.nrHurtowni = nr_hurtowni;
        this.nazwa = nazwa;
        this.dataZalozenia = data_zalozenia;
        this.adres = adres;
    }

    @Override
    public String toString() {
        return "Hurtownia{" +
                "nr_hurtowni=" + nrHurtowni +
                ", nazwa='" + nazwa + '\'' +
                ", data_zalozenia=" + dataZalozenia +
                ", adres=" + adres +
                '}';
    }

    public Long getNrHurtowni() {
        return nrHurtowni;
    }

    public void setNrHurtowni(Long nr_hurtowni) {
        this.nrHurtowni = nr_hurtowni;
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

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }
}


