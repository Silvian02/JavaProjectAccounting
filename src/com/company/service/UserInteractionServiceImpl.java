package com.company.service;

import com.company.exception.InvalidUserInteractionException;
import com.company.model.Department;
import com.company.model.Employee;
import com.company.util.Constants;

import java.util.Scanner;

import static com.company.util.Constants.*;

public class UserInteractionServiceImpl implements UserInteractionService {
    private Scanner scanner = new Scanner(System.in);
    EmployeeInteractionService employeeInteractionService = new EmployeeInteractionServiceImpl();
    EmployeeService employeeService = new EmployeeServiceImpl();

    @Override
    public void initInteraction() {
        switch (chooseInitialAction()) {
            case ACCESS_DATABASE:
                switch (chooseAccessDatabaseAction()) {
                    case LIST_EMPLOYEES:
                        employeeService.listEmployees();
                        break;
                    case ADD_EMPLOYEE:
                        Employee employee = employeeInteractionService.addEmployeeAction();
                        employeeService.addEmployee(employee);
                        System.out.println("add employee");
                        break;
                    case DELETE_EMPLOYEE:
                        int idToBeDeleted = employeeInteractionService.deleteEmployeeAction();
                        employeeService.deleteEmployee(idToBeDeleted);
                        break;
                    case UPDATE_EMPLOYEE:
                        Employee employeeToBeUpdate = employeeInteractionService.updateEmployeeAction();
                        employeeService.updateEmployee(employeeToBeUpdate);
                        break;
                    case Constants.RETURN:
                        initInteraction();
                        break;
                }
                break;
            case VIEW_REPORTS:
                switch (chooseViewReportsAction()) {
                    case AVERAGE_SALARY_BY_COMPANY:
                        System.out.println("Show average salary " + employeeService.calculateAverageSalary());
                        break;
                    case AVERAGE_SALARY_BY_DEPARTMENT:
                        Department department = employeeInteractionService.chooseDepartmentAction();
                        Double avgByDepartment = employeeService.calculateAverageSalaryByDepartment(department);

                        System.out.println("Average salary for " + department + " is " + avgByDepartment);
                        break;
                    case TOP_10_EXPENSIVE_EMPLOYEES:
                        employeeService.employeeSalaryComparator();
                        break;
                    case TOP_10_LOYAL_EMPLOYEES:
                        employeeService.employeeDateComparator();
                        break;
                    case Constants.RETURN:
                        initInteraction();
                        break;

                }
                break;
        }
        initInteraction();
    }

    private Integer chooseViewReportsAction() {
        System.out.println("Average salary by company - press " + AVERAGE_SALARY_BY_COMPANY);
        System.out.println("Average salary by department - press " + AVERAGE_SALARY_BY_DEPARTMENT);
        System.out.println("Top 10 most expensive employees - press " + TOP_10_EXPENSIVE_EMPLOYEES);
        System.out.println("Top 10 loyal employees - press " + TOP_10_LOYAL_EMPLOYEES);
        System.out.println("Go to the firs menu - press " + Constants.RETURN);
        try {
            Integer action = Integer.parseInt(scanner.nextLine());
            if (action != AVERAGE_SALARY_BY_COMPANY &&
                    action != AVERAGE_SALARY_BY_DEPARTMENT &&
                    action != TOP_10_EXPENSIVE_EMPLOYEES &&
                    action != TOP_10_LOYAL_EMPLOYEES &&
                    action != Constants.RETURN) {
                throw new InvalidUserInteractionException();
            }
            return action;
        } catch (Exception e) {
            System.out.println("Please enter a valid number for your action.");
        }
        return chooseViewReportsAction();
    }


    private Integer chooseInitialAction() {
        System.out.println("Choose action: ");
        System.out.println("Access database - press 1 ");
        System.out.println("View Reports - press 2");
        try {
            Integer action = Integer.parseInt(scanner.nextLine());
            if (action != ACCESS_DATABASE && action != VIEW_REPORTS) {
                throw new InvalidUserInteractionException();
            }
            return action;
        } catch (Exception ex) {
            System.out.println("Please enter a valid number: " + ACCESS_DATABASE + " (access database) "
                    + " or  " + VIEW_REPORTS + " (view reports) !");
        }
        return chooseInitialAction();
    }

    public Integer chooseAccessDatabaseAction() {
        System.out.println("List employees - press " + LIST_EMPLOYEES);
        System.out.println("Add employees - press " + ADD_EMPLOYEE);
        System.out.println("Delete employees - press " + DELETE_EMPLOYEE);
        System.out.println("Update employees - press " + UPDATE_EMPLOYEE);
        System.out.println("Go to the first menu - press " + Constants.RETURN);

        try {
            Integer action = Integer.parseInt(scanner.nextLine());
            if (action != LIST_EMPLOYEES &&
                    action != ADD_EMPLOYEE &&
                    action != DELETE_EMPLOYEE &&
                    action != UPDATE_EMPLOYEE &&
                    action != Constants.RETURN) {
                throw new InvalidUserInteractionException();
            }
            return action;
        } catch (Exception e) {
            System.out.println("Please enter a valid number for your action! ");
        }
        return chooseAccessDatabaseAction();
    }
}
