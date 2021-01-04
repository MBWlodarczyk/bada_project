package net.codejava.badabida.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "adresy")
public class Adres implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Long nr_adresu;

    @Column(name = "MIASTO")
    private String miasto;

    @Column(name = "ULICA")
    private String ulica;

    @Column(name = "NR_LOKALU")
    private String nr_lokalu;

    @Column(name = "KOD_POCZTY")
    private String kod_poczty;

    @Column(name = "POCZTA")
    private String poczta;


    public Adres() {
    }

    public Adres(Long nr_adresu, String miasto, String ulica, String nr_lokalu, String kod_poczty, String poczta) {
        this.nr_adresu = nr_adresu;
        this.miasto = miasto;
        this.ulica = ulica;
        this.nr_lokalu = nr_lokalu;
        this.kod_poczty = kod_poczty;
        this.poczta = poczta;
    }

    public Long getNr_adresu() {
        return nr_adresu;
    }

    public void setNr_adresu(Long nr_adresu) {
        this.nr_adresu = nr_adresu;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getNr_lokalu() {
        return nr_lokalu;
    }

    public void setNr_lokalu(String nr_lokalu) {
        this.nr_lokalu = nr_lokalu;
    }

    public String getKod_poczty() {
        return kod_poczty;
    }

    public void setKod_poczty(String kod_poczty) {
        this.kod_poczty = kod_poczty;
    }

    public String getPoczta() {
        return poczta;
    }

    public void setPoczta(String poczta) {
        this.poczta = poczta;
    }

    @Override
    public String toString() {
        return "Adres{" +
                "nr_adresu=" + nr_adresu +
                ", miasto='" + miasto + '\'' +
                ", ulica='" + ulica + '\'' +
                ", nr_lokalu='" + nr_lokalu + '\'' +
                ", kod_poczty='" + kod_poczty + '\'' +
                ", poczta='" + poczta + '\'' +
                '}';
    }
}