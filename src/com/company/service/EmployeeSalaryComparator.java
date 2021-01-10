package com.company.service;

import com.company.model.Employee;

import java.util.Comparator;

public class EmployeeSalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) { return (int) (o2.getSalary() - o1.getSalary());}
}
