package com.example.RestApiDemo.controllers;

import com.example.RestApiDemo.dto.EmployeeDTO;
import com.example.RestApiDemo.services.EmployeeService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable(name = "employeeId") Long employeeId){
        return ResponseEntity.ok(employeeService.getEmployeeById(employeeId));
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> createNewEmployee(@RequestBody EmployeeDTO employeeDTO){
        return ResponseEntity.ok(employeeService.createEmployeeDetails(employeeDTO));
    }

    @GetMapping()
    public ResponseEntity<List<EmployeeDTO>> getAllEmployee(){
        return ResponseEntity.ok().body(employeeService.getAllEmployees());
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity deleteEmployeeById(@PathVariable(value = "employeeId") Long employeeId){
        employeeService.deleteEmployeeById(employeeId);
        return ResponseEntity.ok("");
    }
}
