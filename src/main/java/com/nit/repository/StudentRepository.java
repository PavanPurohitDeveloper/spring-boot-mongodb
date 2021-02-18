package com.nit.repository;

import com.nit.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

    //This is the method proxy provided by the spring data. This will get ALl the Documents By Field name
    //Native mongoDB query ..
    List<Student> findByName(String name);

    //AND operator with multiple Fiields..spring data mongoDB query
    List<Student> findByEmailAndName(String email, String name);

    //OR operator with multiple Fiields
    List<Student> findByNameOrEmail(String name, String email);

    //Get All Documents by sub document field
    List<Student> findByDepartmentDepartmentName(String deptName);

    //Get All Documents By Subject Name.
    List<Student> findBySubjectsSubjectName(String subName);

    //Like Query ..spring data mongoDB query
    List<Student> findByEmailIsLike(String email);

    //Starts With Query
    List<Student> findByNameStartsWith(String name);

}
