package com.learnSWE.crud_spring_jdbc.employee.jdbc;

import com.learnSWE.crud_spring_jdbc.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeJdbcRepository {

    @Autowired
    JdbcTemplate springJdbcTemplate;

    private static String CREATE_QUERY =
            """
                    INSERT INTO Employee
                    VALUES(?, ?, ?, ?, ?)
                    """;

    private static String READ_QUERY =
            """
                    SELECT *
                    FROM Employee
                    WHERE id = ?
                    """;

    private static String UPDATE_QUERY =
            """
                    UPDATE Employee
                    SET salary = ?
                    WHERE id = ?
                    """;

    private static String DELETE_QUERY =
            """
                    DELETE FROM Employee
                    WHERE id = ?
                    """;

    public void insertRow(Employee employee) {

        int numOfRowsAffected = springJdbcTemplate.update(CREATE_QUERY,
                employee.getId(), employee.getFname(), employee.getLname(),
                employee.getAge(), employee.getSalary());
        if (numOfRowsAffected == 0) {
            System.out.println("Nothing is inserted in Employee table.");
        }
    }

    public Employee readRow(String id) {
        //uses Row Mapper to convert ResultSet to a Bean.
        return springJdbcTemplate.queryForObject(READ_QUERY, new BeanPropertyRowMapper<>(Employee.class), id);
    }

    public void updateRow(int salary, String id) {
        int numOfRowsAffected  = springJdbcTemplate.update(UPDATE_QUERY, salary, id);
        if (numOfRowsAffected == 0) {
            System.out.println("Nothing is updated in Employee table.");
        }
    }

    public void deleteRow(String id) {
        int numOfRowsAffected  =  springJdbcTemplate.update(DELETE_QUERY, id);
        if (numOfRowsAffected == 0) {
            System.out.println("Nothing is deleted in Employee table.");
        }
    }
}
