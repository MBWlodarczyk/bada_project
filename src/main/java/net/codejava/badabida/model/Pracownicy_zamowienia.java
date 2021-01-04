package net.codejava.badabida.model;


import javax.persistence.*;

@Entity
@Table(name = "PRACOWNICY_ZAMOWIENIA")
public class Pracownicy_zamowienia {

    @ManyToOne
    @MapsId("NR_PRACOWNIKA")
    private Pracownik pracownik;

    @ManyToOne
    @MapsId("NR_ZAMOWIENIA")
    private Zamowienie zamowienie;


    public Pracownicy_zamowienia() {
    }

    public Pracownicy_zamowienia(Pracownik pracownik, Zamowienie zamowienie) {
        this.pracownik = pracownik;
        this.zamowienie = zamowienie;
    }

    @Override
    public String toString() {
        return "Pracownicy_zamowienia{" +
                "pracownik=" + pracownik +
                ", zamowienie=" + zamowienie +
                '}';
    }

    public Pracownik getPracownik() {
        return pracownik;
    }

    public void setPracownik(Pracownik pracownik) {
        this.pracownik = pracownik;
    }

    public Zamowienie getZamowienie() {
        return zamowienie;
    }

    public void setZamowienie(Zamowienie zamowienie) {
        this.zamowienie = zamowienie;
    }
}
