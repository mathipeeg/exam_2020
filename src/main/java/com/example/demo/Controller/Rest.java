package com.example.demo.Controller;

import com.example.demo.Model.*;
import com.example.demo.Service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class Rest {
    private StudentService studentService;
    private SupervisorService supervisorService;

    public Rest(StudentService studentService, SupervisorService supervisorService){
        this.studentService = studentService;
        this.supervisorService = supervisorService;
    }

    @PostMapping("/api/get")
    public ResponseEntity<Response> getAll(){
        Response response = new Response();
        List<Supervisor> supeList = new ArrayList<>();
        for (Student student : studentService.findAll()) { supeList.add(student.getSupervisor()); }

        createResponse(response, (List<Student>) studentService.findAll(), supeList);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/api/add-student")
    public ResponseEntity<Response> addStudent(@RequestBody Student student){
        studentService.save(student);

        Response response = new Response();
        createResponse(response, Arrays.asList(student), Arrays.asList(student.getSupervisor()));

        return ResponseEntity.ok(response);
    }

    public void createResponse(Response response, List<Student> studentList, List<Supervisor> supervisorList){
        response.setResult(studentList);
        response.setSupervisor(supervisorList);
        response.setSupervisorsList((List<Supervisor>)supervisorService.findAll());
    }

    @PostMapping("/api/update-student")
    public ResponseEntity<Response> updateStudent(@RequestBody Student student){
        studentService.save(student);

        return getAll();
    }

    @PostMapping("/api/delete-student")
    public void deleteStudent(@RequestBody Student student){
        studentService.deleteById(student.getId());
    }
}
