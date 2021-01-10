package com.company.mapper;

import com.company.model.Department;
import com.company.model.Employee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.company.util.Constants.COMMA_DELIMITER;

public class EmployeeMapper {
    public Employee getEmployeeFromCsvLine(String csvLine){
        String[] values = csvLine.split(COMMA_DELIMITER);
        Employee employee = new Employee();
        employee.setId(Integer.parseInt(values[0]));
        employee.setName(values[1]);
        if(values[2]. equals("IT")) {
            employee.setDepartment(Department.IT);
        }else if (values[2].equals("HR")) {
            employee.setDepartment(Department.HR);
        }else{
            employee.setDepartment(Department.SALES);
        }
        employee.setEmploymentDate (LocalDate.parse(values[3]));
        employee.setSalary(Double.parseDouble(values[4]));
        return employee;
    }

    public String getCsvLineFromEmployee(Employee employee){
        StringBuilder sb = new StringBuilder();
        sb.append(employee.getId());
        sb.append(COMMA_DELIMITER);
        sb.append(employee.getName());
        sb.append(COMMA_DELIMITER);
        sb.append(employee.getDepartment());
        sb.append(COMMA_DELIMITER);
        sb.append(employee.getEmploymentDate().toString());
        sb.append(COMMA_DELIMITER);
        sb.append(employee.getSalary());
        return sb.toString();
    }

    public List<Employee> getEmployeeList(List<String> stringEmployees){
        List<Employee> employees = new ArrayList<>();
        for (String employeeString : stringEmployees) {
            employees.add(getEmployeeFromCsvLine(employeeString));
        }
        return employees;

    }
}