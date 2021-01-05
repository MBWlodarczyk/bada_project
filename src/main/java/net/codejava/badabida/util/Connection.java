package net.codejava.badabida.util;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Connection {

    private final DriverManagerDataSource dataSource;
    private final JdbcTemplate jdbcTemplate;

    public Connection(String username, String password) {
        dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf");
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public DriverManagerDataSource getDataSource() {
        return dataSource;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
}
