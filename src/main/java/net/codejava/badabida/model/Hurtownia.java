package net.codejava.badabida.model;

import java.sql.Timestamp;
import javax.persistence.*;

@Entity
@Table(name = "HURTOWNIE")
public class Hurtownia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "NR_HURTOWNI",updatable=false,nullable = false)
    private Long nr_hurtowni;

    @Column(name = "NAZWA")
    private String nazwa;

    @Column(name = "DATA_ZALOzENIA")
    private Timestamp data_zalozenia;

    @ManyToOne
    @MapsId("NR_ADRESU")
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


