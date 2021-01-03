package net.codejava.badabida.dao;

import net.codejava.badabida.model.Adres;
import net.codejava.badabida.model.Hurtownia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class HurtowniaDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public HurtowniaDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Hurtownia> list() {
        String sql = "select * from hurtownie";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Hurtownia.class));
    }

    public void save(Hurtownia hurtownia){
        jdbcTemplate.update("insert into HURTOWNIE (nazwa, data_zalozenia, nr_adresu) values  (?,?,?)",
               hurtownia.getNazwa(),hurtownia.getData(),hurtownia.getNr_adresu());
    }

    public List<Hurtownia> getHurtowniaBy_nr(int nr_hurtowni){
        String sql = String.format("select * from HURTOWNIE where nr_hurtowni = %d",nr_hurtowni);
        return jdbcTemplate.query(sql,BeanPropertyRowMapper.newInstance(Hurtownia.class));
    }

    public void update(Hurtownia hurtownia){
        jdbcTemplate.update("update HURTOWNIE set nazwa = '?', data_zalozenia = ?, nr_adresu = ? where nr_hurtowni = ?",
                hurtownia.getNazwa(),hurtownia.getData(),hurtownia.getNr_adresu(),hurtownia.getNr_hurtowni());
    }

    public void delete(int nr_hurtowni){
        jdbcTemplate.update("delete from HURTOWNIE where nr_hurtowni = ?",nr_hurtowni);
    }
}

