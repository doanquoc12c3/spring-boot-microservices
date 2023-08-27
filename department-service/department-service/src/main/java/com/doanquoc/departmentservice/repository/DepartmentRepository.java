package com.doanquoc.departmentservice.repository;

import com.doanquoc.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long>  {
    Department findByDepartmentCode(String deparmentCode);
}
