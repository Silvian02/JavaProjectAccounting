package com.company.repository;

import java.util.List;

public interface EmployeeRepository {
    void insertLine(String csvLine);
    List<String> readCsv();
    void deleteLine(int employeeId);
    void updateLine(int employeeId, String employeeDetails);





}
