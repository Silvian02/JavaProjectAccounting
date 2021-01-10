package com.company.model;

import java.time.LocalDate;
import java.util.Objects;

public class Employee {
    private Integer id;
    private String name;
    private Department department;
    LocalDate employmentDate;
    private double salary;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(LocalDate employmentDate) {
        this.employmentDate = employmentDate;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) &&
                Objects.equals(name, employee.name) &&
                department == employee.department &&
                Objects.equals(employmentDate, employee.employmentDate) &&
                Objects.equals(salary, employee.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, department, employmentDate, salary);
    }

    @Override
    public String toString() {
        return "Employee(" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department=" + department +
                ", employmentDate=" + employmentDate +
                ", salary=" + salary +
                ')';
    }

}