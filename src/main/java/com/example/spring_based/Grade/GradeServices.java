package com.example.spring_based.Grade;

import com.example.spring_based.Employees.EmployeesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradeServices {
    @Autowired
    public GradeRepositories repositories;
    Page<GradeEntity> findAll(int page, int limit){
        return repositories.findAll(PageRequest.of(page,limit));
    }
    Optional<GradeEntity> findById(int id){ return repositories.findById(id);}

    void delete(int id){ repositories.deleteById(id);}
    GradeEntity save(GradeEntity grade){return repositories.save(grade);}

}
