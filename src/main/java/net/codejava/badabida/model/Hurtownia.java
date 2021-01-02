package net.codejava.badabida.model;

import java.sql.Timestamp;

public class Hurtownia {
    private int nr_hurtowni;
    private String nazwa;
    private Timestamp data;
    private int nr_adresu;

    public Hurtownia() {
    }

    public Hurtownia(int nr_hurtowni, String nazwa, Timestamp data, int nr_adresu) {
        this.nr_hurtowni = nr_hurtowni;
        this.nazwa = nazwa;
        this.data = data;
        this.nr_adresu = nr_adresu;
    }

    public int getNr_hurtowni() {
        return nr_hurtowni;
    }

    public void setNr_hurtowni(int nr_hurtowni) {
        this.nr_hurtowni = nr_hurtowni;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    public int getNr_adresu() {
        return nr_adresu;
    }

    public void setNr_adresu(int nr_adresu) {
        this.nr_adresu = nr_adresu;
    }
}
