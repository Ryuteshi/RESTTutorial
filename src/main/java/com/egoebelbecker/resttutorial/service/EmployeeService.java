package com.egoebelbecker.resttutorial.service;

import com.egoebelbecker.resttutorial.model.Employee;

import java.util.*;

// This is incredibly optimistic code
public class EmployeeService {


  private Map<Integer, Employee> employeeMap = new HashMap<>();


  // Create
  public void addEmployee(Employee employee) {
    employeeMap.put(employee.getEmployeeId(), employee);
  }



  // Read One

  public Optional<Employee> getEmployee(int id) {
    return Optional.of(employeeMap.get(id));
  }



  // Read all
  public Collection<Employee> loadAllEmployees() {
    return employeeMap.values();
  }


  // Update




  // Delete
  public void deleteEmployee(int id) {
    employeeMap.remove(id);
  }




}
