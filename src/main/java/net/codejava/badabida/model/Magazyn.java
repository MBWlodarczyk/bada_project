package net.codejava.badabida.model;

import java.sql.Timestamp;

public class Magazyn {

    private int nr_magazynu;
    private String nazwa;
    private Timestamp data_zalozenia;
    private int nr_hurtowni;
    private int nr_adresu;

    public Magazyn(int nr_magazynu, String nazwa, Timestamp data_zalozenia, int nr_hurtowni, int nr_adresu) {
        this.nr_magazynu = nr_magazynu;
        this.nazwa = nazwa;
        this.data_zalozenia = data_zalozenia;
        this.nr_hurtowni = nr_hurtowni;
        this.nr_adresu = nr_adresu;
    }

    public int getNr_magazynu() {
        return nr_magazynu;
    }

    public void setNr_magazynu(int nr_magazynu) {
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

    public int getNr_hurtowni() {
        return nr_hurtowni;
    }

    public void setNr_hurtowni(int nr_hurtowni) {
        this.nr_hurtowni = nr_hurtowni;
    }

    public int getNr_adresu() {
        return nr_adresu;
    }

    public void setNr_adresu(int nr_adresu) {
        this.nr_adresu = nr_adresu;
    }
}
