package net.codejava.badabida.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "zamowienia")
@SequenceGenerator(name = "nr_zamowienia_ai", sequenceName = "nr_zamowienia_ai", allocationSize = 0)
public class Zamowienie implements Serializable, Comparable<Zamowienie> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nr_zamowienia_ai")
    @Column(updatable = false, nullable = false)
    private Long nrZamowienia;

    @Column(name = "data_zlozenia")
    private Date dataZlozenia;

    @Column(name = "status_zamowienia")
    private String statusZamowienia;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "zamowienia")
    private Set<Klient> klienci;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "zamowienia")
    private Set<Pracownik> pracownicy;

    @OneToMany(mappedBy = "zamowienie", cascade = CascadeType.MERGE, orphanRemoval = true)
    private List<CzesciZamowienia> czesci;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "nr_adresu")
    private Adres adres;

    public Zamowienie() {
    }

    @Override
    public String toString() {
        return "Zamowienie{" +
                "nrZamowienia=" + nrZamowienia +
                ", dataZlozenia=" + dataZlozenia +
                ", statusZamowienia='" + statusZamowienia + '\'' +
                '}';
    }

    public Zamowienie(Long nrZamowienia, Date data_zlozenia, String status_zamowienia, Set<Klient> klienci, Set<Pracownik> pracownicy, List<CzesciZamowienia> czesci, Adres adres) {
        this.nrZamowienia = nrZamowienia;
        this.dataZlozenia = data_zlozenia;
        this.statusZamowienia = status_zamowienia;
        this.klienci = klienci;
        this.pracownicy = pracownicy;
        this.czesci = czesci;
        this.adres = adres;
    }

    public Long getNrZamowienia() {
        return nrZamowienia;
    }

    public void setNrZamowienia(Long nr_zamowienia) {
        this.nrZamowienia = nr_zamowienia;
    }

    public Date getDataZlozenia() {
        return dataZlozenia;
    }

    public void setDataZlozenia(Date data_zlozenia) {
        this.dataZlozenia = data_zlozenia;
    }

    public String getStatusZamowienia() {
        return statusZamowienia;
    }

    public void setStatusZamowienia(String status_zamowienia) {
        this.statusZamowienia = status_zamowienia;
    }

    public Set<Klient> getKlienci() {
        return klienci;
    }

    public void setKlienci(Set<Klient> klienci) {
        this.klienci = klienci;
    }

    public List<CzesciZamowienia> getCzesci() {
        return czesci;
    }

    public void setCzesci(List<CzesciZamowienia> czesci) {
        this.czesci = czesci;
    }

    @Override
    public int compareTo(Zamowienie o) {
        return nrZamowienia.compareTo(o.nrZamowienia);
    }

    public Set<Pracownik> getPracownicy() {
        return pracownicy;
    }

    public void setPracownicy(Set<Pracownik> pracownicy) {
        this.pracownicy = pracownicy;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }
}
