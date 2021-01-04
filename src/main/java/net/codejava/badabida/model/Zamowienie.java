package net.codejava.badabida.model;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "ZAMOWIENIA")
public class Zamowienie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "NR_ZAMOWIENIA",updatable=false,nullable = false)
    private Long nr_zamowienia;

    @Column(name = "DATA_ZLOZENIA")
    private Timestamp data_zlozenia;

    @Column(name = "STATUS_ZLOZENIA")
    private String status_zamowienia;

}
