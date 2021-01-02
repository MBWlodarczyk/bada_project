package net.codejava.badabida.model;

import java.sql.Timestamp;

public class Zamowienie {
    private int nr_zamowienia;
    private Timestamp data_zlozenia;
    private String status_zamowienia;

    public Zamowienie(int nr_zamowienia, Timestamp data_zlozenia, String status_zamowienia) {
        this.nr_zamowienia = nr_zamowienia;
        this.data_zlozenia = data_zlozenia;
        this.status_zamowienia = status_zamowienia;
    }

    public int getNr_zamowienia() {
        return nr_zamowienia;
    }

    public void setNr_zamowienia(int nr_zamowienia) {
        this.nr_zamowienia = nr_zamowienia;
    }

    public Timestamp getData_zlozenia() {
        return data_zlozenia;
    }

    public void setData_zlozenia(Timestamp data_zlozenia) {
        this.data_zlozenia = data_zlozenia;
    }

    public String getStatus_zamowienia() {
        return status_zamowienia;
    }

    public void setStatus_zamowienia(String status_zamowienia) {
        this.status_zamowienia = status_zamowienia;
    }
}
