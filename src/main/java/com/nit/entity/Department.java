package com.nit.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

//This is sub-document..This is not separate collection.

@Getter
@Setter
@Document(collection = "department")
public class Department {

    @Id
    private String id; //this will be unique identifier for each document inside department collection

    @Field(name = "department_name")
    private String departmentName;

    private String location;

}
