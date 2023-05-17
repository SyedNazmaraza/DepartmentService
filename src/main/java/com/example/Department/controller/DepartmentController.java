package com.example.Department.controller;

import com.example.Department.entity.Department;
import com.example.Department.repository.SearchRepository;
import com.example.Department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("department")
public class DepartmentController {
    @Autowired
    private DepartmentService service;

    @Autowired
    private SearchRepository searchRepository;


    @GetMapping("/")
    public List<Department> getAll(){
        return service.getAllDeatils();
    }

//    @GetMapping("/{text}")
//    public List<Department> findAllByText(@PathVariable("text") String text){
//        return searchRepository.findAllByText(text);
//    }

    @GetMapping("/{id}")
    public Optional<Department> getById(@PathVariable("id") int id){
        return service.getById(id);
    }

    @PostMapping("/")
    public Department addDepartment(@RequestBody Department department){
        return service.addDepartment(department);
    }

    @DeleteMapping("/{id}")
    public String deleteDepartment(@PathVariable("id") int id){
        return service.deleteDepartmentById(id);
    }

}
