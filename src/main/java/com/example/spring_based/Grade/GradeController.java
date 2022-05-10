package com.example.spring_based.Grade;

import com.example.spring_based.Student.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "api/v1/grades")
@RestController
public class GradeController {
    @Autowired
    public GradeServices services;

    @RequestMapping(method = RequestMethod.GET)
    public Page<GradeEntity> findAll(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit){
        return services.findAll(page,limit);
    }
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<GradeEntity> save(@RequestBody GradeEntity grade){
        return ResponseEntity.ok(services.save(grade));
    }
}
