package com.company.service;

import com.company.exception.InvalidUserInteractionException;
import com.company.model.Department;
import com.company.model.Employee;
import com.company.util.Constants;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class EmployeeInteractionServiceImpl implements EmployeeInteractionService {
    private Scanner scanner = new Scanner (System.in);

    @Override
    public Employee addEmployeeAction() {
        Employee employee  =new Employee();
        employee.setId(getId());
        employee.setName(getName());
        employee.setDepartment(getDepartment());
        employee.setEmploymentDate(getEmployeeDate());
        employee.setSalary(getSalary());
        return employee;
    }

    @Override
    public Integer deleteEmployeeAction() {
        return getId();
    }

    @Override
    public Employee updateEmployeeAction() {
        return addEmployeeAction();
    }

    @Override
    public Department chooseDepartmentAction() {
        return getDepartment();
    }

    private Integer getId(){
        System.out.println("Id: ");
        try {
            Integer id = Integer.parseInt(scanner.nextLine());
            return id;
        }catch (Exception ex){
            System.out.println("Wrong id. Try again!");
        }
        return getId();
    }
    private String getName(){
        System.out.println("Name: ");
        try{
            String name = scanner.nextLine();
            return name;
        }catch (Exception ex){
            System.out.println("Wrong name. Try again!");
        }
        return getName();
    }
    private Department getDepartment() {
        System.out.println("Department: " +
                Department.IT.getValue() + " - IT, " +
                Department.HR.getValue() + " - HR, " +
                Department.SALES.getValue() + " - SALES, ");
        try {
            Integer depId = Integer.parseInt(scanner.nextLine());
            if(depId != 1 && depId != 2 && depId != 3){
              throw new InvalidUserInteractionException();
            }
            Department department = depId == Department.IT.getValue() ?
                    Department.IT : depId == Department.HR.getValue() ?
                    Department.HR : Department.SALES;
            return  department;
        } catch (Exception ex) {
            System.out.println("Wrong department. Try again!");
        }
        return getDepartment();
    }

    private LocalDate getEmployeeDate(){
        System.out.println("Emplyee Date(" + Constants.DATE_FORMAT + "):");
        try{
            return LocalDate.parse(scanner.nextLine());
        }catch (Exception ex){
            System.out.println("Wronf employment date format. Try again!");
        }
        return getEmployeeDate();
    }
    private Double getSalary(){
        System.out.println("Salary: ");
        try{
            return Double.parseDouble(scanner.nextLine());
        }catch(Exception e){
            System.out.println("Wrong salary. Try again!");
        }
        return getSalary();
    }
}

