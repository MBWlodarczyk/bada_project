package net.codejava.badabida.model;

public class Producent {
    private int nr_producenta;
    private String nazwa_producenta;
    private String telefon_producenta;
    private int nr_adresu;

    public Producent(int nr_producenta, String nazwa_producenta, String telefon_producenta, int nr_adresu) {
        this.nr_producenta = nr_producenta;
        this.nazwa_producenta = nazwa_producenta;
        this.telefon_producenta = telefon_producenta;
        this.nr_adresu = nr_adresu;
    }

    public int getNr_producenta() {
        return nr_producenta;
    }

    public void setNr_producenta(int nr_producenta) {
        this.nr_producenta = nr_producenta;
    }

    public String getNazwa_producenta() {
        return nazwa_producenta;
    }

    public void setNazwa_producenta(String nazwa_producenta) {
        this.nazwa_producenta = nazwa_producenta;
    }

    public String getTelefon_producenta() {
        return telefon_producenta;
    }

    public void setTelefon_producenta(String telefon_producenta) {
        this.telefon_producenta = telefon_producenta;
    }

    public int getNr_adresu() {
        return nr_adresu;
    }

    public void setNr_adresu(int nr_adresu) {
        this.nr_adresu = nr_adresu;
    }
}
