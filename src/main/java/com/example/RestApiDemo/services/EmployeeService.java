package com.example.RestApiDemo.services;

import com.example.RestApiDemo.controllers.EmployeeController;
import com.example.RestApiDemo.dto.EmployeeDTO;
import com.example.RestApiDemo.entities.EmployeeEntity;
import com.example.RestApiDemo.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    EmployeeRepository employeeRepository;
    ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public EmployeeDTO getEmployeeById(Long Id){
          EmployeeEntity employeeEntity =  employeeRepository.getReferenceById(Id);
          return modelMapper.map(employeeEntity,EmployeeDTO.class);
    }

    public EmployeeDTO createEmployeeDetails(EmployeeDTO employeeDTO){
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        return modelMapper.map(employeeRepository.save(employeeEntity), EmployeeDTO.class);
    }
}