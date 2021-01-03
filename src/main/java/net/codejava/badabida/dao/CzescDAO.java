package net.codejava.badabida.dao;

import net.codejava.badabida.model.Czesc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CzescDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public CzescDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Czesc> list(){
        String sql = "select * from CZESCI";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Czesc.class));
    }

    public void save(Czesc czesc){
        jdbcTemplate.update("insert  into CZESCI (cena, nazwa, czas_gwarancji,producent) values (?,?,?,?)",
                czesc.getCena(),czesc.getNazwa(),czesc.getCzas_gwarancji(),czesc.getProducent());
    }

    public List<Czesc> getCzescBy_nr(int nr_czesci){
        String sql = String.format("select * from CZESCI where nr_czesci = %d", nr_czesci);
        return jdbcTemplate.query(sql,BeanPropertyRowMapper.newInstance(Czesc.class));
    }

    public List<Czesc> getCzescBy_nazwa(String nazwa){
        String sql = String.format("select * from CZESCI where nazwa = '%s'", nazwa);
        return jdbcTemplate.query(sql,BeanPropertyRowMapper.newInstance(Czesc.class));
    }

    public void update(Czesc czesc){
        jdbcTemplate.update("update CZESCI set cena = ? , nazwa = '?', czas_gwarancji = ?, producent = '?' where nr_czesci = ?",
                czesc.getCena(),czesc.getNazwa(),czesc.getCzas_gwarancji(), czesc.getProducent(),czesc.getNr_czesci());
    }

    public void delete(int nr_czesci){
        String sql = String.format("delete from CZESCI where nr_czesci = %d",nr_czesci);
        jdbcTemplate.update(sql);
    }
}

