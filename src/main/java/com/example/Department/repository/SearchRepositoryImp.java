package com.example.Department.repository;
import java.util.ArrayList;
import java.util.Arrays;

import com.example.Department.entity.Department;
import com.mongodb.client.MongoClient;
import org.bson.Document;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.List;
import com.mongodb.client.AggregateIterable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

@Component
public class SearchRepositoryImp implements SearchRepository{
    @Autowired
    MongoClient mongoClient;
    @Autowired
    MongoConverter mongoConverter;
    @Override
    public List<Department> findAllByText(String s) {
        List<Department> list = new ArrayList<>();
        MongoDatabase database = mongoClient.getDatabase("Department-service");
        MongoCollection<Document> collection = database.getCollection("department");

        AggregateIterable<Document> result =
                collection.aggregate(Arrays.asList(
                new Document("$search", new Document("index", "default")
                        .append("text", new Document("query", s).append("path", Arrays.asList("departmentName", "departmentType","departmentSubjects")))),
                new Document("$sort",new Document("_id", 1L)),
                new Document("$limit", 5L)));
        result.forEach(n -> list.add(mongoConverter.read(Department.class,n)));
        return list;
    }

}
