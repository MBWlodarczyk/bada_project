package net.codejava.badabida.dao;

import net.codejava.badabida.model.Adres;
import net.codejava.badabida.model.Magazyn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class MagazynDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public MagazynDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Magazyn> list() {
        String sql = "select * from MAGAZYNY";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Magazyn.class));
    }


    //TODO dokonczyc
    public void save(Magazyn magazyn){
        //jdbcTemplate.update("insert into MAGAZYNY (NAZWA, DATA_ZALOZENIA, NR_HURTOWNI, NR_ADRESU)  values (?,?,?,?)");
    }

}
