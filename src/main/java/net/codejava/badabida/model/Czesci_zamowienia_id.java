package net.codejava.badabida.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;


@Embeddable
public class Czesci_zamowienia_id implements Serializable{

    @Column(name = "nr_czesci")
    private Long nr_czesci;

    @Column(name = "nr_zamowienia")
    private Long nr_zamowienia;

    public Czesci_zamowienia_id() {
    }

    public Long getNr_czesci() {
        return nr_czesci;
    }

    public void setNr_czesci(Long nr_czesci) {
        this.nr_czesci = nr_czesci;
    }

    public Long getNr_zamowienia() {
        return nr_zamowienia;
    }

    public void setNr_zamowienia(Long nr_zamowienia) {
        this.nr_zamowienia = nr_zamowienia;
    }

    public Czesci_zamowienia_id(Long nr_czesci, Long nr_zamowienia) {
        this.nr_czesci = nr_czesci;
        this.nr_zamowienia = nr_zamowienia;
    }

    @Override
    public String toString() {
        return "Czesci_zamowienia_id{" +
                "nr_czesci=" + nr_czesci +
                ", nr_zamowienia=" + nr_zamowienia +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Czesci_zamowienia_id that = (Czesci_zamowienia_id) o;
        return Objects.equals(nr_czesci, that.nr_czesci) &&
                Objects.equals(nr_zamowienia, that.nr_zamowienia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nr_czesci, nr_zamowienia);
    }
}
