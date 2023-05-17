package com.example.Department.repository;

import com.example.Department.entity.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;



public interface DepartmentRepository extends MongoRepository<Department,Integer> {



}
