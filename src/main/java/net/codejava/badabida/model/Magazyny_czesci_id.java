package net.codejava.badabida.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Magazyny_czesci_id implements Serializable{

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
}
