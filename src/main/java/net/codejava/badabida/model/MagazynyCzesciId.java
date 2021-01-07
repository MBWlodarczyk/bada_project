package net.codejava.badabida.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MagazynyCzesciId implements Serializable {

    @Column(name = "nr_magazynu")
    private Long nrMagazynu;


    @Column(name = "nr_czesci")
    private Long nrCzesci;

    public MagazynyCzesciId() {
    }

    public Long getNrMagazynu() {
        return nrMagazynu;
    }

    public void setNrMagazynu(Long nr_magazynu) {
        this.nrMagazynu = nr_magazynu;
    }

    public Long getNrCzesci() {
        return nrCzesci;
    }

    public void setNrCzesci(Long nr_czesci) {
        this.nrCzesci = nr_czesci;
    }

    public MagazynyCzesciId(Long nr_magazynu, Long nr_czesci) {
        this.nrMagazynu = nr_magazynu;
        this.nrCzesci = nr_czesci;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MagazynyCzesciId that = (MagazynyCzesciId) o;
        return Objects.equals(nrMagazynu, that.nrMagazynu) &&
                Objects.equals(nrCzesci, that.nrCzesci);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nrMagazynu, nrCzesci);
    }

    @Override
    public String toString() {
        return "Magazyny_czesci_id{" +
                "nr_magazynu=" + nrMagazynu +
                ", nr_czesci=" + nrCzesci +
                '}';
    }
}
