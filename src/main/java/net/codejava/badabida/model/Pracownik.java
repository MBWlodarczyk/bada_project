package net.codejava.badabida.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Pracownik {

    private int nr_pracownika;
    private String imie;
    private String nazwisko;
    private Timestamp data_urodzenia;
    private String pesel;
    private String telefon;
    private BigDecimal wynagrodzenie;
    private String stanowisko;
    private String plec;
    private int nr_hurtowni;
    private int nr_magazynu;
    private int nr_adresu;

    public Pracownik(int nr_pracownika, String imie, String nazwisko, Timestamp data_urodzenia, String pesel, String telefon, BigDecimal wynagrodzenie, String stanowisko, String plec, int nr_hurtowni, int nr_magazynu, int nr_adresu) {
        this.nr_pracownika = nr_pracownika;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.data_urodzenia = data_urodzenia;
        this.pesel = pesel;
        this.telefon = telefon;
        this.wynagrodzenie = wynagrodzenie;
        this.stanowisko = stanowisko;
        this.plec = plec;
        this.nr_hurtowni = nr_hurtowni;
        this.nr_magazynu = nr_magazynu;
        this.nr_adresu = nr_adresu;
    }

    public int getNr_pracownika() {
        return nr_pracownika;
    }

    public void setNr_pracownika(int nr_pracownika) {
        this.nr_pracownika = nr_pracownika;
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

    public Timestamp getData_urodzenia() {
        return data_urodzenia;
    }

    public void setData_urodzenia(Timestamp data_urodzenia) {
        this.data_urodzenia = data_urodzenia;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public BigDecimal getWynagrodzenie() {
        return wynagrodzenie;
    }

    public void setWynagrodzenie(BigDecimal wynagrodzenie) {
        this.wynagrodzenie = wynagrodzenie;
    }

    public String getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public int getNr_hurtowni() {
        return nr_hurtowni;
    }

    public void setNr_hurtowni(int nr_hurtowni) {
        this.nr_hurtowni = nr_hurtowni;
    }

    public int getNr_magazynu() {
        return nr_magazynu;
    }

    public void setNr_magazynu(int nr_magazynu) {
        this.nr_magazynu = nr_magazynu;
    }

    public int getNr_adresu() {
        return nr_adresu;
    }

    public void setNr_adresu(int nr_adresu) {
        this.nr_adresu = nr_adresu;
    }
}
