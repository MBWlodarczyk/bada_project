package net.codejava.badabida.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;


@Entity
@Table(name = "zamowienia")
public class Zamowienie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable=false,nullable = false)
    private Long nr_zamowienia;

    @Column(name = "data_zlozenia")
    private Date data_zlozenia;

    @Column(name = "status_zamowienia")
    private String status_zamowienia;

    public Zamowienie() {
    }

    public Zamowienie(Long nr_zamowienia, Date data_zlozenia, String status_zamowienia) {
        this.nr_zamowienia = nr_zamowienia;
        this.data_zlozenia = data_zlozenia;
        this.status_zamowienia = status_zamowienia;
    }

    public Long getNr_zamowienia() {
        return nr_zamowienia;
    }

    public void setNr_zamowienia(Long nr_zamowienia) {
        this.nr_zamowienia = nr_zamowienia;
    }

    public Date getData_zlozenia() {
        return data_zlozenia;
    }

    public void setData_zlozenia(Date data_zlozenia) {
        this.data_zlozenia = data_zlozenia;
    }

    public String getStatus_zamowienia() {
        return status_zamowienia;
    }

    public void setStatus_zamowienia(String status_zamowienia) {
        this.status_zamowienia = status_zamowienia;
    }
}
