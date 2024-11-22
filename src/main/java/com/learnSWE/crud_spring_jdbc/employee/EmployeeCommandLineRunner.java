package com.learnSWE.crud_spring_jdbc.employee;

import com.learnSWE.crud_spring_jdbc.employee.jdbc.EmployeeJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EmployeeCommandLineRunner implements CommandLineRunner {

    @Autowired
    EmployeeJdbcRepository employeeJdbcRepository;

    @Override
    public void run(String... args) throws Exception {
        employeeJdbcRepository.insertRow(
                new Employee("4fj3jds6", "Iman", "Badaui", 25, 500000));
        employeeJdbcRepository.insertRow(
                new Employee("f4hs9f5h", "Laila", "Fahmy", 45, 250000));
        employeeJdbcRepository.insertRow(
                new Employee("d6hs7j4d", "Aly", "Sami", 35, 150000));
        employeeJdbcRepository.insertRow(
                new Employee("s0fn4dg6", "Shady", "Samir", 24, 50000));
        employeeJdbcRepository.insertRow(
                new Employee("s3gd56d4", "Rania", "Yousef", 23, 45000));
        employeeJdbcRepository.insertRow(
                new Employee("4dg5d5gf", "Noha", "Salama", 22, 20000));

      Employee employee1 =  employeeJdbcRepository.readRow("4fj3jds6");
      Employee employee2 = employeeJdbcRepository.readRow("s0fn4dg6");

        employeeJdbcRepository.updateRow(350000,"4fj3jds6");
        employeeJdbcRepository.updateRow(200000, "f4hs9f5h");

        employeeJdbcRepository.deleteRow("s3gd56d4");
    }
}
