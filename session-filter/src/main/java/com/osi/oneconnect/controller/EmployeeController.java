package com.osi.oneconnect.controller;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.osi.oneconnect.dto.EmailDTO;
import com.osi.oneconnect.model.Employee;
import com.osi.oneconnect.service.impl.SendEmailNotificationImpl;
import com.osi.oneconnect.service.impl.TestService;

@RestController
@CrossOrigin(value = "*")
public class EmployeeController{

    @Autowired
    private TestService employeeService;
    
    @Autowired
    private SendEmailNotificationImpl sendEmailNotificationImpl;

    @PostMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees(@RequestParam("file") MultipartFile file) throws Exception {
        List<Employee> employees = employeeService.getEmployees(file);
        if (employees.isEmpty()) {
        	
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}
