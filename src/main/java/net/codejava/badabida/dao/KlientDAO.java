package net.codejava.badabida.dao;

import net.codejava.badabida.model.Hurtownia;
import net.codejava.badabida.model.Klient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class KlientDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public KlientDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Klient> list() {
        String sql = "select * from KLIENCI";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Klient.class));
    }

    public void save(Klient klient){
        jdbcTemplate.update("insert into KLIENCI (imie, nazwisko, telefon, nr_adresu) values  (?,?,?,?)",
                klient.getImie(),klient.getNazwisko(),klient.getTelefon(),klient.getNr_adresu());
    }


    //TODO dokonczyc

}
