package com.egoebelbecker.resttutorial.controller;

import com.egoebelbecker.resttutorial.model.Employee;
import com.egoebelbecker.resttutorial.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.NoSuchElementException;

@Slf4j
@RestController
@Api(value = "resttutorial", description = "REST Tutorial service")
public class TutorialController {

    private EmployeeService employeeService = new EmployeeService();


    public void init() {

        employeeService.addEmployee(Employee.builder()
                .employeeId(1)
                .email("john@doe.com")
                .firstName("John")
                .lastName("Doe")
                .phone("555-1212")
                .build());

        employeeService.addEmployee(Employee.builder()
                .employeeId(2)
                .email("jenny@doe.com")
                .firstName("Jenny")
                .lastName("Doe")
                .phone("867-5309")
                .build());

        employeeService.addEmployee(Employee.builder()
                .employeeId(3)
                .email("clark@doe.com")
                .firstName("Clark")
                .lastName("Kent")
                .phone("555-1213")
                .build());

    }


    @ApiOperation(value = "Create Employee ", response = ResponseEntity.class)
    @RequestMapping(value = "/api/tutorial/1.0/employees", method = RequestMethod.POST)
    public ResponseEntity createEmployee(@RequestBody Employee employee) {
        log.info("Receive Request to add employee {}", employee);
        if (employeeService.addEmployee(employee)) {
            return new ResponseEntity(null, HttpStatus.OK);
        } else {
            return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
        }
    }


    @ApiOperation(value = "Get Employee ", response = ResponseEntity.class)
    @RequestMapping(value = "/api/tutorial/1.0/employees/{id}", method = RequestMethod.GET)
    public ResponseEntity getEmployee(@PathVariable("id") String idString) {

        try {
            int id = Integer.parseInt(idString);
            log.info("Received Request for employee {}", id);
            Employee employee = employeeService.getEmployee(id)
                    .orElseThrow(() -> new NoSuchElementException("Employee not found."));
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } catch (NumberFormatException | NoSuchElementException nfe) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }


    @ApiOperation(value = "Get All Employees ", response = ResponseEntity.class)
    @RequestMapping(value = "/api/tutorial/1.0/employees", method = RequestMethod.GET)
    public ResponseEntity getAllEmployees() {
        log.info("Receive Request to Get All Employees");
        Collection<Employee> employees = employeeService.loadAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }


    @ApiOperation(value = "Update Employee ", response = ResponseEntity.class)
    @RequestMapping(value = "/api/tutorial/1.0/employees/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateEmployee(@PathVariable("id") String idString, @RequestBody Employee employee) {

        try {
            int id = Integer.parseInt(idString);
            log.info("Received Request to update employee {}", id);

            if (employeeService.updateEmployee(id, employee)) {
                return new ResponseEntity(null, HttpStatus.OK);
            } else {
                return new ResponseEntity(null, HttpStatus.NOT_FOUND);
            }
        } catch (NumberFormatException | NoSuchElementException nfe) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "Patch Employee ", response = ResponseEntity.class)
    @RequestMapping(value = "/api/tutorial/1.0/employees/{id}", method = RequestMethod.PATCH)
    public ResponseEntity patchEmployee(@PathVariable("id") String idString, @RequestBody Employee employee) {

        try {
            int id = Integer.parseInt(idString);
            log.info("Received Request to patch employee {}", id);

            if (employeeService.patchEmployee(id, employee)) {
                return new ResponseEntity(null, HttpStatus.OK);
            } else {
                return new ResponseEntity(null, HttpStatus.NOT_FOUND);
            }
        } catch (NumberFormatException | NoSuchElementException nfe) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }

    }

    @ApiOperation(value = "Delete Employee ", response = ResponseEntity.class)
    @RequestMapping(value = "/api/tutorial/1.0/employees/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteEmployee(@PathVariable("id") String idString) {
        try {
            int id = Integer.parseInt(idString);
            log.info("Received Request to delete employee {}", id);
            if (employeeService.deleteEmployee(id)) {
                return new ResponseEntity<>(null, HttpStatus.OK);
            }
        } catch (NumberFormatException | NoSuchElementException nfe) {
            // Fall through to not found
        }
        return new ResponseEntity(null, HttpStatus.NOT_FOUND);

    }

}
