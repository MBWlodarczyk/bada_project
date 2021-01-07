package net.codejava.badabida.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "adresy")
public class Adres implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Long nrAdresu;

    @Column(name = "MIASTO")
    private String miasto;

    @Column(name = "ULICA")
    private String ulica;

    @Column(name = "NR_LOKALU")
    private String nrLokalu;

    @Column(name = "KOD_POCZTY")
    private String kodPoczty;

    @Column(name = "POCZTA")
    private String poczta;


    public Adres() {
    }

    public Adres(Long nr_adresu, String miasto, String ulica, String nr_lokalu, String kod_poczty, String poczta) {
        this.nrAdresu = nr_adresu;
        this.miasto = miasto;
        this.ulica = ulica;
        this.nrLokalu = nr_lokalu;
        this.kodPoczty = kod_poczty;
        this.poczta = poczta;
    }

    public Long getNrAdresu() {
        return nrAdresu;
    }

    public void setNrAdresu(Long nr_adresu) {
        this.nrAdresu = nr_adresu;
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

    public String getNrLokalu() {
        return nrLokalu;
    }

    public void setNrLokalu(String nr_lokalu) {
        this.nrLokalu = nr_lokalu;
    }

    public String getKodPoczty() {
        return kodPoczty;
    }

    public void setKodPoczty(String kod_poczty) {
        this.kodPoczty = kod_poczty;
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
                "nr_adresu=" + nrAdresu +
                ", miasto='" + miasto + '\'' +
                ", ulica='" + ulica + '\'' +
                ", nr_lokalu='" + nrLokalu + '\'' +
                ", kod_poczty='" + kodPoczty + '\'' +
                ", poczta='" + poczta + '\'' +
                '}';
    }
}