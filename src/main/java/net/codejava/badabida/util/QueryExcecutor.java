package net.codejava.badabida.util;


import org.springframework.jdbc.core.JdbcTemplate;


//@Service
public class QueryExcecutor {

    //@Transactional(rollbackFor = Exception.class)
    public static void delete(JdbcTemplate jdbcTemplate, String name, int nr_encji) {
        //get primary key name
        String sql = "SELECT cols.column_name FROM all_constraints cons, all_cons_columns cols " +
                "WHERE cols.table_name = ? " +
                "AND cons.constraint_type = 'P'" +
                "AND cons.constraint_name = cols.constraint_name " +
                "AND cons.owner = cols.owner " +
                "ORDER BY cols.table_name, cols.position";
        String primary_key = (String) jdbcTemplate.queryForObject(
                sql, new Object[]{name}, String.class);
        sql = String.format("delete from %s where %s = %d", name, primary_key, nr_encji);
        jdbcTemplate.update(sql);

        System.out.println(sql);
    }


    //TODO query with commit and rollback


}
