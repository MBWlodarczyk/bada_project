package net.codejava.badabida.model;

public class Adres {

    private int nr_adresu;
    private String miasto;
    private String ulica;
    private String nr_lokalu;
    private String kod_poczty;
    private String poczta;

    public Adres() {
    }

    public Adres(int nr_adresu, String miasto, String ulica, String nr_lokalu, String kod_poczty, String poczta) {
        this.nr_adresu = nr_adresu;
        this.miasto = miasto;
        this.ulica = ulica;
        this.nr_lokalu = nr_lokalu;
        this.kod_poczty = kod_poczty;
        this.poczta = poczta;
    }

    public int getNr_adresu() {
        return nr_adresu;
    }

    public void setNr_adresu(int nr_adresu) {
        this.nr_adresu = nr_adresu;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getNr_lokalu() {
        return nr_lokalu;
    }

    public void setNr_lokalu(String nr_lokalu) {
        this.nr_lokalu = nr_lokalu;
    }

    public String getKod_poczty() {
        return kod_poczty;
    }

    public void setKod_poczty(String kod_poczty) {
        this.kod_poczty = kod_poczty;
    }

    public String getPoczta() {
        return poczta;
    }

    public void setPoczta(String poczta) {
        this.poczta = poczta;
    }

    @Override
    public String toString() {
        return "Adres{" +
                "nr_adresu=" + nr_adresu +
                ", miasto='" + miasto + '\'' +
                ", ulica='" + ulica + '\'' +
                ", nr_lokalu='" + nr_lokalu + '\'' +
                ", kod_poczty='" + kod_poczty + '\'' +
                ", poczta='" + poczta + '\'' +
                '}';
    }
}
