package net.codejava.badabida.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@Entity
@Table(name = "pracownicy")
public class Pracownik implements Serializable, UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Long nrPracownika;

    @Column(name = "IMIE")
    private String imie;

    @Column(name = "NAZWISKO")
    private String nazwisko;

    @Column(name = "DATA_URODZENIA")
    private Timestamp dataUrodzenia;

    @Column(name = "PESEL")
    private String pesel;

    @Column(name = "TELEFON")
    private String telefon;

    @Column(name = "wynagrodzenie")
    private BigDecimal wynagrodzenie;

    @Column(name = "STANOWISKO")
    private String stanowisko;

    @Column(name = "PLEC")
    private String plec;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.REFRESH)
    @JoinColumn(name = "nr_hurtowni")
    private Hurtownia hurtownia;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.REFRESH)
    @JoinColumn(name = "nr_magazynu")
    private Magazyn magazyn;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.REFRESH)
    @JoinColumn(name = "nr_adresu")
    private Adres adres;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "pracownicy_zamowienia",
            joinColumns = { @JoinColumn(name = "nr_pracownika") },
            inverseJoinColumns = { @JoinColumn(name = "nr_zamowienia") }
    )
    private Set<Zamowienie> zamowienia;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    public Pracownik() {
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(role));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Long getNrPracownika() {
        return nrPracownika;
    }

    public void setNrPracownika(Long nr_pracownika) {
        this.nrPracownika = nr_pracownika;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public Timestamp getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(Timestamp data_urodzenia) {
        this.dataUrodzenia = data_urodzenia;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public BigDecimal getWynagrodzenie() {
        return wynagrodzenie;
    }

    public void setWynagrodzenie(BigDecimal wynagrodzenie) {
        this.wynagrodzenie = wynagrodzenie;
    }

    public String getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public Hurtownia getHurtownia() {
        return hurtownia;
    }

    public void setHurtownia(Hurtownia hurtownia) {
        this.hurtownia = hurtownia;
    }

    public Magazyn getMagazyn() {
        return magazyn;
    }

    public void setMagazyn(Magazyn magazyn) {
        this.magazyn = magazyn;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Pracownik(Long nr_pracownika, String imie, String nazwisko, Timestamp data_urodzenia, String pesel, String telefon, BigDecimal wynagrodzenie, String stanowisko, String plec, Hurtownia hurtownia, Magazyn magazyn, Adres adres, Set<Zamowienie> zamowienia, String username, String password, String role) {
        this.nrPracownika = nr_pracownika;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUrodzenia = data_urodzenia;
        this.pesel = pesel;
        this.telefon = telefon;
        this.wynagrodzenie = wynagrodzenie;
        this.stanowisko = stanowisko;
        this.plec = plec;
        this.hurtownia = hurtownia;
        this.magazyn = magazyn;
        this.adres = adres;
        this.zamowienia = zamowienia;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Set<Zamowienie> getZamowienia() {
        return zamowienia;
    }

    public void setZamowienia(Set<Zamowienie> zamowienia) {
        this.zamowienia = zamowienia;
    }
}
