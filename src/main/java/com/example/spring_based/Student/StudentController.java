package com.example.spring_based.Student;

import com.example.spring_based.Grade.GradeEntity;
import com.example.spring_based.Student_Grade.StudentGradeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {
    @Autowired
    private StudentServices services;
    @RequestMapping(method = RequestMethod.GET)
    public Page<StudentEntity> findAll(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit){
        return services.findAll(page,limit);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<StudentEntity> save(@RequestBody StudentEntity student){
        System.out.println(student);
        return ResponseEntity.ok(services.save(student));
    }
}
