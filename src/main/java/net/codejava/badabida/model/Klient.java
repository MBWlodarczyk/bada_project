package net.codejava.badabida.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "klienci")
public class Klient implements Serializable, UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Long nr_klienta;

    @Column(name = "IMIE")
    private String imie;

    @Column(name = "NAZWISKO")
    private String nazwisko;

    @Column(name = "TELEFON")
    private String telefon;

    @ManyToOne
    //@MapsId("NR_ADRESU") //TODO tu chyba tez nie
    private Adres adres;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "zamowienia_klienci", joinColumns = { @JoinColumn(name = "nr_klienta") }, inverseJoinColumns = { @JoinColumn(name = "nr_zamowienia") })
    private List<Zamowienie> zamowienia;

    public Klient() {
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

    public Klient(Long nr_klienta, String imie, String nazwisko, String telefon, Adres adres, String username, String password, String role, List<Zamowienie> zamowienia) {
        this.nr_klienta = nr_klienta;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.telefon = telefon;
        this.adres = adres;
        this.username = username;
        this.password = password;
        this.role = role;
        this.zamowienia = zamowienia;
    }

    @Override
    public String toString() {
        return "Klient{" +
                "nr_klienta=" + nr_klienta +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", telefon='" + telefon + '\'' +
                ", adres=" + adres +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public Long getNr_klienta() {
        return nr_klienta;
    }

    public void setNr_klienta(Long nr_klienta) {
        this.nr_klienta = nr_klienta;
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

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
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

    public List<Zamowienie> getZamowienia() {
        return zamowienia;
    }

    public void setZamowienia(List<Zamowienie> zamowienia) {
        this.zamowienia = zamowienia;
    }
}
