package com.company.service;

import com.company.model.Department;
import com.company.model.Employee;

public interface EmployeeInteractionService {
    Employee addEmployeeAction();
    Integer deleteEmployeeAction();
    Employee updateEmployeeAction();
    Department chooseDepartmentAction();


}

