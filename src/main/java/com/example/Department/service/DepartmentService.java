package com.example.Department.service;

import com.example.Department.entity.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    List<Department> getAllDeatils();

    Department addDepartment(Department department);

    Optional<Department> getById(int id);

    String deleteDepartmentById(int id);
}
