package com.nit.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

//This is sub-document..This is not separate collection.

@Getter
@Setter
public class Department {

    @Field(name = "department_name")
    private String departmentName;

    private String location;

}
