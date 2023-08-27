package com.doanquoc.employeeservice.controller;

import com.doanquoc.employeeservice.dto.APIResponseDto;
import com.doanquoc.employeeservice.dto.EmployeeDto;
import com.doanquoc.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/employees")
public class EmployeeController {
    EmployeeService employeeService;
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto createdEmployeeDto = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(createdEmployeeDto, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<APIResponseDto> getEmployeeById(@PathVariable(name="id") Long employeeId){
        APIResponseDto apiResponseDto = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(apiResponseDto,HttpStatus.OK);
    }

}
