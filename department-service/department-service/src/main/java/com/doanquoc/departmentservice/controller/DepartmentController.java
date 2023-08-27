package com.doanquoc.departmentservice.controller;

import com.doanquoc.departmentservice.dto.DepartmentDto;
import com.doanquoc.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {
    private DepartmentService departmentService;
    // build save department rest api


    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto saveDepartment = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(saveDepartment, HttpStatus.CREATED);
    }

    @GetMapping("{code}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("code") String departmentCode){
        DepartmentDto departmentDto = departmentService.getDepartmentByCode(departmentCode);
        return new ResponseEntity<>(departmentDto, HttpStatus.OK);
    }


}
