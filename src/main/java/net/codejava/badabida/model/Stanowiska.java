package net.codejava.badabida.model;

public class Stanowiska {
    private int nr_stanowiska;
    private String nazwa;
    private String opis_stanowsika;

    public Stanowiska(int nr_stanowiska, String nazwa, String opis_stanowsika) {
        this.nr_stanowiska = nr_stanowiska;
        this.nazwa = nazwa;
        this.opis_stanowsika = opis_stanowsika;
    }

    public int getNr_stanowiska() {
        return nr_stanowiska;
    }

    public void setNr_stanowiska(int nr_stanowiska) {
        this.nr_stanowiska = nr_stanowiska;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getOpis_stanowsika() {
        return opis_stanowsika;
    }

    public void setOpis_stanowsika(String opis_stanowsika) {
        this.opis_stanowsika = opis_stanowsika;
    }
}
