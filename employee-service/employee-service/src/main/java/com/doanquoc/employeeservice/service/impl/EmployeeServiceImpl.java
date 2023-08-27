package com.doanquoc.employeeservice.service.impl;

import com.doanquoc.employeeservice.dto.APIResponseDto;
import com.doanquoc.employeeservice.dto.DepartmentDto;
import com.doanquoc.employeeservice.dto.EmployeeDto;
import com.doanquoc.employeeservice.entity.Employee;
import com.doanquoc.employeeservice.repository.EmployeeRepository;
import com.doanquoc.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

//    private RestTemplate restTemplate;

    private WebClient webClient;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode()
        );

        Employee createdEmployee = employeeRepository.save(employee);
        EmployeeDto createdEmployeeDto = new EmployeeDto(
                createdEmployee.getId(),
                createdEmployee.getFirstName(),
                createdEmployee.getLastName(),
                createdEmployee.getEmail(),
                createdEmployee.getDepartmentCode()
        );
        return createdEmployeeDto;
    }

    @Override
    public APIResponseDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).get();

//        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/" + employee.getDepartmentCode(), DepartmentDto.class);
        DepartmentDto departmentDto = webClient.get()
                . uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();

        EmployeeDto employeeDto = new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode()
        );

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);
        return apiResponseDto;
    }
}
