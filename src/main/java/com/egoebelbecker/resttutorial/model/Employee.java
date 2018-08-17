package com.egoebelbecker.resttutorial.model;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Employee implements Serializable {
    private int employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
