package net.codejava.badabida.model;

public class Klient {
    private int nr_klienta;
    private String imie;
    private String nazwisko;
    private String telefon;
    private int nr_adresu;

    public Klient(int nr_klienta, String imie, String nazwisko, String telefon, int nr_adresu) {
        this.nr_klienta = nr_klienta;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.telefon = telefon;
        this.nr_adresu = nr_adresu;
    }

    public int getNr_klienta() {
        return nr_klienta;
    }

    public void setNr_klienta(int nr_klienta) {
        this.nr_klienta = nr_klienta;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public int getNr_adresu() {
        return nr_adresu;
    }

    public void setNr_adresu(int nr_adresu) {
        this.nr_adresu = nr_adresu;
    }
}
