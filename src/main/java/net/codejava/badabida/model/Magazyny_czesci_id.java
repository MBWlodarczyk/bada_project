package net.codejava.badabida.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Magazyny_czesci_id implements Serializable {

    @Column(name = "nr_magazynu")
    private Long nr_magazynu;


    @Column(name = "nr_czesci")
    private Long nr_czesci;

    public Magazyny_czesci_id() {
    }

    public Long getNr_magazynu() {
        return nr_magazynu;
    }

    public void setNr_magazynu(Long nr_magazynu) {
        this.nr_magazynu = nr_magazynu;
    }

    public Long getNr_czesci() {
        return nr_czesci;
    }

    public void setNr_czesci(Long nr_czesci) {
        this.nr_czesci = nr_czesci;
    }

    public Magazyny_czesci_id(Long nr_magazynu, Long nr_czesci) {
        this.nr_magazynu = nr_magazynu;
        this.nr_czesci = nr_czesci;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Magazyny_czesci_id that = (Magazyny_czesci_id) o;
        return Objects.equals(nr_magazynu, that.nr_magazynu) &&
                Objects.equals(nr_czesci, that.nr_czesci);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nr_magazynu, nr_czesci);
    }

    @Override
    public String toString() {
        return "Magazyny_czesci_id{" +
                "nr_magazynu=" + nr_magazynu +
                ", nr_czesci=" + nr_czesci +
                '}';
    }
}
