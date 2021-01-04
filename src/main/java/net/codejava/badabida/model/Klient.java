package net.codejava.badabida.model;

import javax.persistence.*;

@Entity
@Table(name = "klienci")
public class Klient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "NR_KLIENTA", updatable=false,nullable = false)
    private Long nr_klienta;

    @Column(name = "IMIE")
    private String imie;

    @Column(name = "NAZWISKO")
    private String nazwisko;

    @Column(name = "TELEFON")
    private String telefon;

    @OneToOne
    //@MapsId("NR_ADRESU") //TODO tu chyba tez nie
    private Adres adres;

    public Klient() {
    }

    @Override
    public String toString() {
        return "Klient{" +
                "nr_klienta=" + nr_klienta +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", telefon='" + telefon + '\'' +
                ", adres=" + adres +
                '}';
    }

    public Long getNr_klienta() {
        return nr_klienta;
    }

    public void setNr_klienta(Long nr_klienta) {
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

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public Klient(Long nr_klienta, String imie, String nazwisko, String telefon, Adres adres) {
        this.nr_klienta = nr_klienta;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.telefon = telefon;
        this.adres = adres;
    }
}
