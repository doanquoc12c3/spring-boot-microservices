package com.doanquoc.employeeservice.service;

import com.doanquoc.employeeservice.dto.APIResponseDto;
import com.doanquoc.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    APIResponseDto getEmployeeById(Long id);
}
