package com.example.Department.repository;

import com.example.Department.entity.Department;
import java.util.List;

public interface SearchRepository {


    List<Department> findAllByText(String s);
}
