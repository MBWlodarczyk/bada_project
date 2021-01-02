package net.codejava.badabida.dao;

import net.codejava.badabida.model.Poczta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PocztaDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public PocztaDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Poczta> list() {
        String sql = "select * from poczty";
        List<Poczta> poczty = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Poczta.class));
        return poczty;
    }

    /** Insert */
    public void save(Poczta poczta) {
//        String sql = String.format("insert into POCZTY (kod_poczty,poczta) values (%s,%s)",
//                                    poczta.getKod_poczty(),poczta.getPoczta());
//        jdbcTemplate.update(sql);
        jdbcTemplate.update("insert into POCZTY (kod_poczty, poczta) values (?,?)",
                poczta.getKod_poczty(),poczta.getPoczta());
    }


    /** Read */
    public List<Poczta> getBy_nr_poczty(int nr_poczty) {
        String sql = String.format("select * from POCZTY where NR_POCZTY = %d",nr_poczty);
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Poczta.class));
    }

    public List<Poczta> getBy_kod_poczty(String kod_poczty) {
        kod_poczty = "\'" + kod_poczty + "\'";
        String sql = String.format("select * from poczty where kod_poczty = %s",kod_poczty);
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Poczta.class));
    }

    public List<Poczta> getBy_poczta(String poczta) {
        poczta = "\'" + poczta + "\'";
        String sql = String.format("select * from poczty where poczta = %s",poczta);
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Poczta.class));
    }


    /**
     * Update
     * @param poczta
     */
    public void update(Poczta poczta) {

    }

    /**
     * Delete
     * @param nr_poczty
     */
    public void delete(int nr_poczty) {
        String sql = String.format("delete from POCZTY where nr_poczty = %d",nr_poczty);
        jdbcTemplate.update(sql);
    }
}
