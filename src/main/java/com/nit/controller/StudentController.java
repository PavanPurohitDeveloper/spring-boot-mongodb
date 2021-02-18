package com.nit.controller;

import com.nit.entity.Student;
import com.nit.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)  // Or @PostMapping("/create")
    public Student createStudent(@RequestBody Student student){
        log.debug("Creating a Student: {}", student);
        return studentService.createStudent(student);
    }

    @GetMapping("/getById/{id}")
    public Student getStudentById(@PathVariable String id){
        return studentService.getStudentById(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Student> getAllStudents(){
        log.debug("Retrieving all the Documents For the Collection from mongoDB..");
        return studentService.getAllStudents();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update")  //Or @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student){
        log.debug("Updating the Document for Collection: {}", student );
        return studentService.updateStudent(student);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}") //Or DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable String id){
        log.debug("Deleting the Document for Student Collection for StudentId: {}", id );
        return studentService.deleteStudent(id);
    }

    //Get All Documents By Field
    @GetMapping(value = "/studentsByName/{name}")
    public List<Student> getAllStudentsByName(@PathVariable String name){
        log.debug("Retrieving all the Documents For the Collection from mongoDB..");
        return studentService.getAllStudentsByName(name);
    }

    //Get All Documents By Multiple Fields using AND operator
    @GetMapping(value = "/studentsByNameAndMail")
    public List<Student> getAllStudentsByNameAndMail(@RequestParam String name, @RequestParam String email){
        log.debug("Retrieving all the Documents For the Collection from mongoDB..");
        return studentService.getAllStudentsByNameAndMail(name, email);
    }

    //Get All Documents By Multiple Fields using OR operator
    @GetMapping(value = "/studentsByNameOrMail")
    public List<Student> getAllStudentsByNameOrMail(@RequestParam String name, @RequestParam String email){
        log.debug("Retrieving all the Documents For the Collection from mongoDB..");
        return studentService.getAllStudentsByNameOrMail(name, email);
    }

    @GetMapping("/allWithPagination")
    public List<Student> getAllStudentsWithPagination(@RequestParam int pageNo, @RequestParam int pageSize){
        return studentService.getAllStudentsWithPagination(pageNo,pageSize );
    }

    //Sorting Documents
    @GetMapping("/allWithSorting")
    public List<Student> getAllStudentsWithSorting(){
        return studentService.getAllStudentsWithSorting();
    }

    //Get Documents by value of Sub Document field. Get the students by DepartmentName
    @GetMapping("/byDepartmentName")
    public List<Student> getAllStudentsByDepartmentName(@RequestParam String deptName){
        return studentService.getAllStudentsByDepartmentName(deptName);
    }

    //Get All the Documents or Students by Subject Name..Get Documents By Array Value
    @GetMapping("/bySubjectName")
    public List<Student> getAllStudentsBySubjectName(@RequestParam String subName){
        return studentService.getAllStudentsBySubjectName(subName);
    }

    //Using Like Query
    @GetMapping("/emailLike")
    public List<Student> getAllStudentsByEmailWithLike(@RequestParam String email){
        return studentService.getAllStudentsByEmailWithLike(email);
    }

    //Starts With Query
    @GetMapping("/nameStartsWith")
    public List<Student> getAllStudentsByNameStartsWith(@RequestParam String name){
        return studentService.getAllStudentsByNameStartsWith(name);
    }


}
