package com.nit.service.impl;

import com.nit.entity.Student;
import com.nit.repository.StudentRepository;
import com.nit.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student) {
        //student - this object we are getting from the Controller which comes in the Request Payload for http POST method.
        log.info("Saving Student..{}", student.toString());
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(String id) {
        //Optional.get() method will return the Object which is holding.
        return studentRepository.findById(id).get();
    }

    @Override
    public List<Student> getAllStudents() {
        log.info("Retriving All the Students from Collection..");
        return studentRepository.findAll();
    }

    @Override
    public Student updateStudent(Student student) {
        log.debug("Updating the Document for Collection: {}", student );
        return studentRepository.save(student);
    }

    @Override
    public String deleteStudent(String id) {
        studentRepository.deleteById(id);
        return "Student has been deleted.";
    }

    @Override
    public List<Student> getAllStudentsByName(String name) {
        log.info("Retriving All the Documents from Student Collection By Name Field : {}", name);
        return studentRepository.findByName(name);
    }

    @Override
    public List<Student> getAllStudentsByNameAndMail(String name, String email) {
        return studentRepository.findByEmailAndName(email, name);
    }

    @Override
    public List<Student> getAllStudentsByNameOrMail(String name, String email) {
        return studentRepository.findByNameOrEmail(name, email);
    }

    @Override
    public List<Student> getAllStudentsWithPagination(int pageNo, int pageSize) {
        //Internall spring data mongoDB will do calcualtion.
        //Skip = (Page No -1) * Page Size
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        // findAll(pageable) this returns Page of Student. Now convert to List<Student>
        return studentRepository.findAll(pageable).getContent();
    }

    @Override
    public List<Student> getAllStudentsWithSorting() {
        //based on which field you want to apply sort.
        Sort sort = Sort.by(Sort.Direction.ASC, "name");

        //If you want to sort based on multiple fields in Ascending order
        //Sort sort = Sort.by(Sort.Direction.ASC, "name", "email");

        return studentRepository.findAll(sort);
    }

    @Override
    public List<Student> getAllStudentsByDepartmentName(String deptName) {
        return studentRepository.findByDepartmentDepartmentName(deptName);
    }

    @Override
    public List<Student> getAllStudentsBySubjectName(String subName) {
        return studentRepository.findBySubjectsSubjectName(subName);
    }

    @Override
    public List<Student> getAllStudentsByEmailWithLike(String email) {
        return studentRepository.findByEmailIsLike(email);
    }

    @Override
    public List<Student> getAllStudentsByNameStartsWith(String name) {
        return studentRepository.findByNameStartsWith(name);
    }
}
