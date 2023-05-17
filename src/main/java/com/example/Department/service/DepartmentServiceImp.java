package com.example.Department.service;

import com.example.Department.entity.Department;
import com.example.Department.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImp implements DepartmentService{
    @Autowired
    private DepartmentRepository repository;


    @Override
    public List<Department> getAllDeatils() {
        return repository.findAll();
    }

    @Override
    public Department addDepartment(Department department) {
        return repository.save(department);
    }

    @Override
    public Optional<Department> getById(int id) {
        return repository.findById(id);
    }

    @Override
    public String deleteDepartmentById(int id) {

        if(repository.existsById(id)){
            repository.deleteById(id);
            return "Deleted";

        }
        return "NotDeleted";

    }
}
