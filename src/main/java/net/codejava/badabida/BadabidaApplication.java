package net.codejava.badabida;

import net.codejava.badabida.dao.AdresDAO;
import net.codejava.badabida.dao.KlientDAO;
import net.codejava.badabida.model.Adres;
import net.codejava.badabida.model.Klient;
import net.codejava.badabida.util.Connection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@SpringBootApplication
public class BadabidaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BadabidaApplication.class, args);


        Connection connection = new Connection("mwlodarc", "mwlodarc");



        AdresDAO ad = new AdresDAO(connection.getJdbcTemplate());






//        for(Klient e : xd)
//            System.out.println(e.toString());


    }
}
