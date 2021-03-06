package com.nit.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

//This is sub-document..This is not separate collection.
@Getter
@Setter
public class Subject {

    @Field(name = "subject_name")
    private String subjectName;

    @Field(name = "marks_obtained")
    private int marksObtained;
}
