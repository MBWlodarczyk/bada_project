package net.codejava.badabida.dao;

import net.codejava.badabida.model.Adres;
import net.codejava.badabida.model.Poczta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdresDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public AdresDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Adres> list() {
        String sql = "select * from adresy";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Adres.class));
    }

    public void save(Adres adres){
        jdbcTemplate.update("insert into ADRESY (miasto, ulica, nr_lokalu, nr_poczty) values  (?,?,?,?)",
                adres.getMiasto(),adres.getUlica(),adres.getNr_lokalu(),adres.getNr_poczty());
    }

    ///TODO dodac to wszytsko teraz xdddddddddddddddd

}
