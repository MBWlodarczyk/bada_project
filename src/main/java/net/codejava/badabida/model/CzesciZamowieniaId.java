package net.codejava.badabida.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CzesciZamowieniaId implements Serializable {

    @Column(name = "nr_czesci")
    private Long nrCzesci;

    @Column(name = "nr_zamowienia")
    private Long nrZamowienia;

    public CzesciZamowieniaId() {
    }

    public Long getNrCzesci() {
        return nrCzesci;
    }

    public void setNrCzesci(Long nrCzesci) {
        this.nrCzesci = nrCzesci;
    }

    public Long getNrZamowienia() {
        return nrZamowienia;
    }

    public void setNrZamowienia(Long nr_zamowienia) {
        this.nrZamowienia = nr_zamowienia;
    }

    public CzesciZamowieniaId(Long nr_czesci, Long nr_zamowienia) {
        this.nrCzesci = nr_czesci;
        this.nrZamowienia = nr_zamowienia;
    }

    @Override
    public String toString() {
        return "Czesci_zamowienia_id{" +
                "nr_czesci=" + nrCzesci +
                ", nr_zamowienia=" + nrZamowienia +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CzesciZamowieniaId that = (CzesciZamowieniaId) o;
        return Objects.equals(nrCzesci, that.nrCzesci) &&
                Objects.equals(nrZamowienia, that.nrZamowienia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nrCzesci, nrZamowienia);
    }
}
