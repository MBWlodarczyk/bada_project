package net.codejava.badabida.dao;

import net.codejava.badabida.model.Klient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class KlientDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public KlientDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Klient> list() {
        String sql = "select * from KLIENCI";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Klient.class));
    }

    public void save(Klient klient) {
        jdbcTemplate.update("insert into KLIENCI (imie, nazwisko, telefon, nr_adresu) values  (?,?,?,?)",
                klient.getImie(), klient.getNazwisko(), klient.getTelefon(), klient.getNr_adresu());
    }

    public List<Klient> getKlienyBy_nr(int nr_klienta) {
        String sql = String.format("select * from ADRESY where nr_klienta = %d", nr_klienta);
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Klient.class));
    }

    public void update(Klient klient) {
        String sql = "update KLIENCI set IMIE = ?, NAZWISKO = ?, TELEFON = ?, NR_ADRESU = ? where nr_klienta = ?";
        jdbcTemplate.update(sql, new Object[]{klient.getImie(), klient.getNazwisko(), klient.getTelefon(), klient.getNr_adresu(), klient.getNr_klienta()});
    }

    public void delete(int nr_klienta) {
        jdbcTemplate.update("delete from KLIENCI where nr_klienta = ?", nr_klienta);
    }
}
