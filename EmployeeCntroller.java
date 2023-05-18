package com.example.demo.EmployeesCntroller;

import com.example.demo.AipResponse.AipResponse;
import com.example.demo.Employees.Employee;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeCntroller {
    ArrayList<Employee> employees = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList get() {
        return employees;
    }

    @PostMapping("/add")
    public ResponseEntity addEmployees(@Valid @RequestBody Employee employee, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new AipResponse(message));
        }
        employees.add(employee);
        return ResponseEntity.status(200).body(new AipResponse("user added"));
    }

    @PutMapping("/update/{index}")
    public ResponseEntity updateEmployees(@Valid @RequestBody Employee employee, int index, Errors errors) {
        if (errors.hasErrors()) {

            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new AipResponse(message));

        }
        employees.set(index, employee);
        return ResponseEntity.status(200).body(new AipResponse("update it !"));
    }

    @DeleteMapping("/delete/{index}")
    public ResponseEntity deleteEmployees(@PathVariable int index) {
        employees.remove(index);
        return ResponseEntity.status(200).body(new AipResponse("user delete it "));
    }

    @PutMapping("/applay/{index}")
    public ResponseEntity applyAnnual(@Valid @PathVariable Employee employee, int index, Errors errors) {
        if (errors.hasErrors()) {

            String message = errors.getFieldError().getDefaultMessage();
            if (employees.get(index).getAnnualLeave() == 0 & employees.get(index).isOnleave() != false)
                return ResponseEntity.status(400).body(new AipResponse(message));
        }
        employees.set(index, employee).setAnnualLeave(index-1) ;
        employees.set(index, employee.setOnleave() =true);
        return ResponseEntity.status(200).body(new AipResponse("the added"));
    }



}
