package net.codejava.badabida.model;


import javax.persistence.*;

@Entity
@Table(name = "ZAMOWIENIA_KLIENCI")
public class Zamowienia_klient {

    @ManyToOne
    @MapsId("NR_ZAMOWIENIA")
    private Zamowienie zamowienie;

    @ManyToOne
    @MapsId("NR_KLIENTA")
    private Klient klient;


    public Zamowienia_klient() {
    }

    public Zamowienia_klient(Zamowienie zamowienie, Klient klient) {
        this.zamowienie = zamowienie;
        this.klient = klient;
    }

    @Override
    public String toString() {
        return "Zamowienia_klient{" +
                "zamowienie=" + zamowienie +
                ", klient=" + klient +
                '}';
    }

    public Zamowienie getZamowienie() {
        return zamowienie;
    }

    public void setZamowienie(Zamowienie zamowienie) {
        this.zamowienie = zamowienie;
    }

    public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient klient) {
        this.klient = klient;
    }
}
