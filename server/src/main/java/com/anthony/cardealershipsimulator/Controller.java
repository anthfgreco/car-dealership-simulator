package com.anthony.cardealershipsimulator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String sql = """
            SELECT AVG(entry_price) AS 'Average Price'
            FROM price
            WHERE maker LIKE ?;
                """;

    @GetMapping("/")
    public List<Object> greeting(@RequestParam(value = "offset", defaultValue = "0") String offset) {
        return jdbcTemplate.query(
                sql,
                ps -> ps.setString(1, offset),
                (rs, rowNum) -> rs.getFloat("Average Price"));
    }
}