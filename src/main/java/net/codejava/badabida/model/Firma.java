package net.codejava.badabida.model;

public class Firma {

    private int nr_firmy;
    private String nazwa;
    private String nip;
    private int nr_adresu;

    public Firma() {
    }

    public Firma(int nr_firmy, String nazwa, String nip, int nr_adresu) {
        this.nr_firmy = nr_firmy;
        this.nazwa = nazwa;
        this.nip = nip;
        this.nr_adresu = nr_adresu;
    }

    public int getNr_firmy() {
        return nr_firmy;
    }

    public void setNr_firmy(int nr_firmy) {
        this.nr_firmy = nr_firmy;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public int getNr_adresu() {
        return nr_adresu;
    }

    public void setNr_adresu(int nr_adresu) {
        this.nr_adresu = nr_adresu;
    }
}


