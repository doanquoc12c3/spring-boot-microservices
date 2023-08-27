package com.doanquoc.departmentservice.service.DepartmentServiceImpl;

import com.doanquoc.departmentservice.dto.DepartmentDto;
import com.doanquoc.departmentservice.entity.Department;
import com.doanquoc.departmentservice.repository.DepartmentRepository;
import com.doanquoc.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

//    public DepartmentServiceImpl(DepartmentRepository departmentRepository){
//         this.departmentRepository = departmentRepository;
//    } => replaced by AllArgsContructor
    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        // convert deparment dto to department jpa entity
        Department department = new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()
        );

        Department savedDepartment = departmentRepository.save(department);

        DepartmentDto savedDepartmentDto = new DepartmentDto(
                savedDepartment.getId(),
                savedDepartment.getDepartmentName(),
                savedDepartment.getDepartmentDescription(),
                savedDepartment.getDepartmentCode()
        );
        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String code) {
        Department department = departmentRepository.findByDepartmentCode(code);
        DepartmentDto departmentDto = new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode()
        );

        return departmentDto ;
    }
}
