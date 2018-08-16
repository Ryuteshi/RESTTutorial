package com.egoebelbecker.resttutorial.controller;

import com.egoebelbecker.resttutorial.model.Employee;
import com.egoebelbecker.resttutorial.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@Slf4j
@RestController
@Api(value="resttutorial", description="REST Tutorial service")
public class TutorialController {

    private EmployeeService employeeService = new EmployeeService();

    @ApiOperation(value = "Get All Employees ",response = ResponseEntity.class)
    @RequestMapping(value = "/api/tutorial/1.0/employees", method = RequestMethod.GET)
    public ResponseEntity getAllEmployees(){
        log.info("Receive Request to Get All Employees");
        Collection<Employee> employees = employeeService.loadAllEmployees().;
        return new ResponseEntity(employees, HttpStatus.OK);
    }

    @ApiOperation(value = "Get Employee ",response = ResponseEntity.class)
    @RequestMapping(value = "/api/refdata/1.0/subscribers", method = RequestMethod.GET)
    public ResponseEntity getAllSubscribers(){
        log.info("Receive Request to Get All Subscribers");
        List<Subscriber> Employees = employeeService.loadAllSubscribers();
        return new ResponseEntity(Employees, HttpStatus.OK);
    }

    @ApiOperation(value = "Get All CompIds ",response = ResponseEntity.class)
    @RequestMapping(value = "/api/refdata/1.0/compids", method = RequestMethod.GET)
    public ResponseEntity getAllCompIds(){
        log.info("Receive Request to Get All CompIds");
        List<String> compIds = compIdService.findAllCompIds();
        return new ResponseEntity(compIds, HttpStatus.OK);
    }

    @SuppressWarnings("unused")
    @ApiOperation(value = "Kubernetes Live Check", response = ResponseEntity.class)
    @RequestMapping(value = "/api/refdata/1.0/status", method = RequestMethod.GET)
    public ResponseEntity<String> statusCheck() {

        return new ResponseEntity<>("", HttpStatus.OK);

    }



}
