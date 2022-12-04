package com.anthony.cardealershipsimulator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            SELECT maker, genmodel, genmodel_id, adv_id, adv_year, adv_month, color, reg_year, bodytype, runned_miles, engin_size, gearbox, fuel_type, price, seat_num, door_num
            FROM ad
            WHERE maker LIKE ?
            ORDER BY price DESC
            LIMIT 50 OFFSET 0;
                    """;

    @GetMapping("/")
    public List<Object> greeting(@RequestParam(value = "maker", defaultValue = "") String maker) {
        return jdbcTemplate.query(
                sql,
                ps -> ps.setString(1, maker),
                (rs, rowNum) -> {
                    // Create an object to hold the data from all of the columns
                    Map<String, Object> row = new HashMap<>();

                    // Add the data from each column to the object
                    row.put("maker", rs.getString("maker"));
                    row.put("genmodel", rs.getString("genmodel"));
                    row.put("genmodel_id", rs.getString("genmodel_id"));
                    row.put("adv_id", rs.getString("adv_id"));
                    row.put("adv_year", rs.getInt("adv_year"));
                    row.put("adv_month", rs.getInt("adv_month"));
                    row.put("color", rs.getString("color"));
                    row.put("reg_year", rs.getInt("reg_year"));
                    row.put("bodytype", rs.getString("bodytype"));
                    row.put("runned_miles", rs.getInt("runned_miles"));
                    row.put("engin_size", rs.getString("engin_size"));
                    row.put("gearbox", rs.getString("gearbox"));
                    row.put("fuel_type", rs.getString("fuel_type"));
                    row.put("price", rs.getInt("price"));
                    row.put("seat_num", rs.getInt("seat_num"));
                    row.put("door_num", rs.getInt("door_num"));

                    // Return the Map object
                    return row;
                });
    }
}