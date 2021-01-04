package net.codejava.badabida.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Table(name = "PRACOWNICY")
public class Pracownik {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "NR_PRACOWNIKA",updatable=false,nullable = false)
    private Long nr_pracownika;

    @Column(name = "IMIE")
    private String imie;

    @Column(name = "NAZWISKO")
    private String nazwisko;

    @Column(name = "DATA_URODZENIA")
    private Timestamp data_urodzenia;

    @Column(name = "PESEL")
    private String pesel;

    @Column(name = "TELEFON")
    private String telefon;

    @Column(name = "WYNAGRODENIE")
    private BigDecimal wynagrodzenie;

    @Column(name = "STANOWISKO")
    private String stanowisko;

    @Column(name = "PLEC")
    private String plec;

    @ManyToOne
    @MapsId("NR_HURTOWNI")
    private Hurtownia hurtownia;

    @ManyToOne
    @MapsId("NR_MAGAZYNU")
    private Magazyn magazyn;

    @ManyToOne
    @MapsId("NR_ADRESU")
    private Adres adres;

    public Pracownik() {
    }

    @Override
    public String toString() {
        return "Pracownik{" +
                "nr_pracownika=" + nr_pracownika +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", data_urodzenia=" + data_urodzenia +
                ", pesel='" + pesel + '\'' +
                ", telefon='" + telefon + '\'' +
                ", wynagrodzenie=" + wynagrodzenie +
                ", stanowisko='" + stanowisko + '\'' +
                ", plec='" + plec + '\'' +
                ", hurtownia=" + hurtownia +
                ", magazyn=" + magazyn +
                ", adres=" + adres +
                '}';
    }

    public Long getNr_pracownika() {
        return nr_pracownika;
    }

    public void setNr_pracownika(Long nr_pracownika) {
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

    public Hurtownia getHurtownia() {
        return hurtownia;
    }

    public void setHurtownia(Hurtownia hurtownia) {
        this.hurtownia = hurtownia;
    }

    public Magazyn getMagazyn() {
        return magazyn;
    }

    public void setMagazyn(Magazyn magazyn) {
        this.magazyn = magazyn;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public Pracownik(Long nr_pracownika, String imie, String nazwisko, Timestamp data_urodzenia, String pesel, String telefon, BigDecimal wynagrodzenie, String stanowisko, String plec, Hurtownia hurtownia, Magazyn magazyn, Adres adres) {
        this.nr_pracownika = nr_pracownika;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.data_urodzenia = data_urodzenia;
        this.pesel = pesel;
        this.telefon = telefon;
        this.wynagrodzenie = wynagrodzenie;
        this.stanowisko = stanowisko;
        this.plec = plec;
        this.hurtownia = hurtownia;
        this.magazyn = magazyn;
        this.adres = adres;
    }
}
