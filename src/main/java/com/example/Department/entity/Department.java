package com.example.Department.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection  = "department")
public class Department {
    @Id

    private int departmentId;
    private String departmentName;
    private String departmentType;
    private String[] departmentSubjects;

}
