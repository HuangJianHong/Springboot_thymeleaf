package com.example.demo.controller;

import com.example.demo.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/student")
public class StudentController {

    @RequestMapping("show")
    public String show(Model model) throws Exception {
        model.addAttribute("str", "hello spring boot thymeleaf");
        Student student = new Student();
        student.setId(100);
        student.setName("张三");
        model.addAttribute("stu", student);

        java.util.List<Student> students = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Student stu = new Student();
            stu.setId(i);
            stu.setName("stu" + i);
            students.add(stu);
        }
        model.addAttribute("students", students);
//        if (100/0==0){
//        }
        if (true){
            throw  new Exception();   //自定义抛出异常
        }

        return "student";
    }

}
