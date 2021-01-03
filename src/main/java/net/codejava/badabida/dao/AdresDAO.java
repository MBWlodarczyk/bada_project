package net.codejava.badabida.dao;

import net.codejava.badabida.model.Adres;
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
        String sql = "select * from ADRESY";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Adres.class));
    }

    public void save(Adres adres) {
        jdbcTemplate.update("insert into ADRESY (miasto, ulica, nr_lokalu, kod_poczty, poczta) values  (?,?,?,?,?)",
                adres.getMiasto(), adres.getUlica(), adres.getNr_lokalu(), adres.getKod_poczty(), adres.getPoczta());
    }

    public List<Adres> getAdresBy_nr(int nr_adresu) {
        String sql = String.format("select * from ADRESY where nr_adresu = %d", nr_adresu);
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Adres.class));
    }

    public List<Adres> getAdresBy_kod(String kod_poczty) {
        String sql = String.format("select * from ADRESY where kod_poczty = '%s'", kod_poczty);
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Adres.class));
    }

    public void update(Adres adres) {
        String sql = String.format("update ADRESY set MIASTO = '%s', ULICA = '%s', " +
                        "NR_LOKALU = '%s', KOD_POCZTY = '%s', POCZTA = '%s' WHERE NR_ADRESU = %d",
                adres.getMiasto(), adres.getUlica(), adres.getNr_lokalu(), adres.getKod_poczty(), adres.getPoczta(), adres.getNr_adresu());
        jdbcTemplate.update(sql);
    }

    public void delete(int nr_adresu) {
        //QueryExcecutor.delete(jdbcTemplate, "ADRESY", nr_adresu);
        jdbcTemplate.update("delete from ADRESY where nr_adresu = ?", nr_adresu);
    }

}
