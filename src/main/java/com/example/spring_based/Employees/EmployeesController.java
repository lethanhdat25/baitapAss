package com.example.spring_based.Employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/employees")
public class EmployeesController {
    @Autowired
    public EmployeesService employeesService;
    @RequestMapping(method = RequestMethod.GET)
    public List<EmployeesEntity> findAll(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit){
        return employeesService.findAll();
    }
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<EmployeesEntity> save(@RequestBody EmployeesEntity employeesEntity){
        return ResponseEntity.ok(employeesService.save(employeesEntity));
    }
}
