package net.codejava.badabida.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "magazyny")
@SequenceGenerator(name = "nr_magazynu_ai", sequenceName = "nr_magazynu_ai", allocationSize = 0)
public class Magazyn implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nr_magazynu_ai")
    @Column(updatable = false, nullable = false)
    private Long nrMagazynu;

    @Column(name = "NAZWA")
    private String nazwa;

    @Column(name = "DATA_ZALOZENIA")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataZalozenia;

    @ManyToOne
    @JoinColumn(name = "nr_hurtowni")
    private Hurtownia hurtownia;

    @OneToOne
    @JoinColumn(name = "nr_adresu")
    private Adres adres;


    public Magazyn() {
    }

    public Magazyn(Long nrMagazynu, String nazwa, LocalDate dataZalozenia, Hurtownia hurtownia, Adres adres) {
        this.nrMagazynu = nrMagazynu;
        this.nazwa = nazwa;
        this.dataZalozenia = dataZalozenia;
        this.hurtownia = hurtownia;
        this.adres = adres;
    }

    @Override
    public String toString() {
        return "Magazyn{" +
                "nrMagazynu=" + nrMagazynu +
                ", nazwa='" + nazwa + '\'' +
                ", dataZalozenia=" + dataZalozenia +
                ", hurtownia=" + hurtownia +
                ", adres=" + adres +
                '}';
    }

    public Long getNrMagazynu() {
        return nrMagazynu;
    }

    public void setNrMagazynu(Long nrMagazynu) {
        this.nrMagazynu = nrMagazynu;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public LocalDate getDataZalozenia() {
        return dataZalozenia;
    }

    public void setDataZalozenia(LocalDate dataZalozenia) {
        this.dataZalozenia = dataZalozenia;
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
}
