package net.codejava.badabida;

import net.codejava.badabida.dao.PocztaDAO;
import net.codejava.badabida.model.Poczta;
import net.codejava.badabida.util.Connection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

@SpringBootApplication
public class BadabidaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BadabidaApplication.class, args);
        Connection connection = new Connection("mdadura","mdadura");

        PocztaDAO p = new PocztaDAO(connection.getJdbcTemplate());

        //p.save(new Poczta("99-99","Olecko"));

        //System.out.println(p.getBy_poczta("Olecko"));

        p.delete(21);

        List<Poczta> lista = p.list();
        for (Poczta element : lista) {
            System.out.println(element.toString());
        }
    }
}
