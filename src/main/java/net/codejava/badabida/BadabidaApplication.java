package net.codejava.badabida;

import net.codejava.badabida.util.Connection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class BadabidaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BadabidaApplication.class, args);


        Connection connection = new Connection("mwlodarc", "mwlodarc");


    }
}
