package com.nit.service;

import com.nit.entity.Student;

import java.util.List;

public interface StudentService {

    //create Student
    Student createStudent(Student student);

    //Get Student By Id
    Student getStudentById(String id);

    //Get All Documents for the Collection
    List<Student> getAllStudents();

    //Update Document
    Student updateStudent(Student student);

    //Delete Document
    String deleteStudent(String id);

    //Get All Documents By Field
    List<Student> getAllStudentsByName(String name);

    //Get ALl Documents By Name and Mail Field using AND operator
    List<Student> getAllStudentsByNameAndMail(String name, String email);

    //Get ALl Documents By Name and Mail Field using OR operator
    List<Student> getAllStudentsByNameOrMail(String name, String email);

    //With Pagination
    List<Student> getAllStudentsWithPagination(int pageNo, int pageSize);

    //Sorting Documents
    List<Student> getAllStudentsWithSorting();

    //Get All Documents by sub document field
    List<Student> getAllStudentsByDepartmentName(String deptName);

    //Get Documents By Array Value
    List<Student> getAllStudentsBySubjectName(String subName);

    //Using Like Query
    List<Student> getAllStudentsByEmailWithLike(String email);

    //Starts With Query
    List<Student> getAllStudentsByNameStartsWith(String name);

}
