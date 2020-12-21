package com.example.demo.Service;

import com.example.demo.Model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentService extends CrudRepository<Student, Long> {

}
