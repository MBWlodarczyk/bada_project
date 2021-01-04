package net.codejava.badabida.model;

import java.sql.Timestamp;
import javax.persistence.*;

@Entity
@Table(name = "hurtownie")
public class Hurtownia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable=false,nullable = false)
    private int nr_hurtowni;

    @Column(name = "nazwa")
    private String nazwa;

    @Column(name = "data_zalozenia")
    private Timestamp data_zalozenia;

    @Column(name = "nr_adresu")
    private int nr_adresu;


    public int getNr_hurtowni() {
        return nr_hurtowni;
    }

    public void setNr_hurtowni(int nr_hurtowni) {
        this.nr_hurtowni = nr_hurtowni;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Timestamp getData_zalozenia() {
        return data_zalozenia;
    }

    public void setData_zalozenia(Timestamp data_zalozenia) {
        this.data_zalozenia = data_zalozenia;
    }

    public int getNr_adresu() {
        return nr_adresu;
    }

    public void setNr_adresu(int nr_adresu) {
        this.nr_adresu = nr_adresu;
    }
}
