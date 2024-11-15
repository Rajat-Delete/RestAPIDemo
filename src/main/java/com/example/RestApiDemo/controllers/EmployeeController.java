package com.example.RestApiDemo.controllers;

import com.example.RestApiDemo.dto.EmployeeDTO;
import com.example.RestApiDemo.services.EmployeeService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

//    @GetMapping("/userDetails/{employeeId}")
//    public EmployeeDTO getEmployeeDetails(@PathVariable (value = "employeeId") Long employeeId){
//        return new EmployeeDTO(employeeId, "Rajat Sharma", LocalDate.of(2019,11,18),false);
//    }

    @GetMapping
    public String getEmployeeData(@PathParam("sortBy") String sortBy){
        return "Hey we are sorting by "+ sortBy;
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable(name = "employeeId") Long employeeId){
        return ResponseEntity.ok(employeeService.getEmployeeById(employeeId));
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> createNewEmployee(@RequestBody EmployeeDTO employeeDTO){
        return ResponseEntity.ok(employeeService.createEmployeeDetails(employeeDTO));
    }
}
