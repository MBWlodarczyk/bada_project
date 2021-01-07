package net.codejava.badabida.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "zamowienia")
public class Zamowienie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Long nrZamowienia;

    @Column(name = "data_zlozenia")
    private Date dataZlozenia;

    @Column(name = "status_zamowienia")
    private String statusZamowienia;

    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "zamowienia")
    private Set<Klient> klienci;

    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "zamowienia")
    private Set<Klient> pracownicy;

    @OneToMany(mappedBy = "zamowienie",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<CzesciZamowienia> czesci;

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

    public Zamowienie(Long nrZamowienia, Date data_zlozenia, String status_zamowienia, Set<Klient> klienci, Set<Klient> pracownicy, List<CzesciZamowienia> czesci) {
        this.nrZamowienia = nrZamowienia;
        this.dataZlozenia = data_zlozenia;
        this.statusZamowienia = status_zamowienia;
        this.klienci = klienci;
        this.pracownicy = pracownicy;
        this.czesci = czesci;
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
}
