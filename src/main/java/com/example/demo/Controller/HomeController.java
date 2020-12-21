package com.example.demo.Controller;

import com.example.demo.Service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private StudentService studentService;
    private SupervisorService supervisorService;

    public HomeController(StudentService studentService, SupervisorService supervisorService){
        this.studentService = studentService;
        this.supervisorService = supervisorService;
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("students", studentService.findAll());
        model.addAttribute("supervisors", supervisorService.findAll());
        return "index";
    }
}
