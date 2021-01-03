package net.codejava.badabida.model;

import java.math.BigDecimal;

public class Czesc {
    private int nr_czesci;
    private BigDecimal cena;
    private String nazwa;
    private int czas_gwarancji;
    private String producent;

    public Czesc() {
    }

    public Czesc(int nr_czesci, BigDecimal cena, String nazwa, int czas_gwarancji, String producent) {
        this.nr_czesci = nr_czesci;
        this.cena = cena;
        this.nazwa = nazwa;
        this.czas_gwarancji = czas_gwarancji;
        this.producent = producent;
    }

    public int getNr_czesci() {
        return nr_czesci;
    }

    public void setNr_czesci(int nr_czesci) {
        this.nr_czesci = nr_czesci;
    }

    public BigDecimal getCena() {
        return cena;
    }

    public void setCena(BigDecimal cena) {
        this.cena = cena;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getCzas_gwarancji() {
        return czas_gwarancji;
    }

    public void setCzas_gwarancji(int czas_gwarancji) {
        this.czas_gwarancji = czas_gwarancji;
    }

    public String getProducent() {
        return producent;
    }

    public void setProducent(String producent) {
        this.producent = producent;
    }
}
