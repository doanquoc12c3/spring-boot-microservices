package com.doanquoc.departmentservice.service;

import com.doanquoc.departmentservice.dto.DepartmentDto;

public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentByCode(String code);

}
