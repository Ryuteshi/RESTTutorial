package com.egoebelbecker.resttutorial.model;

import java.io.Serializable;
import lombok.Data;

@Data
public class Employee implements Serializable {
    private int employeeId;
    private String FirstName;
    private String LastName;
    private String Email;
    private String Phone;
}
