package com.example.spring_based.Student;

import com.example.spring_based.Grade.GradeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServices {

    @Autowired
    private StudentRepositories repositories;
    Page<StudentEntity> findAll(int page, int limit){
        return repositories.findAll(PageRequest.of(page,limit));
    }
    Optional<StudentEntity> findById(int id){
        return repositories.findById(id);
    }
    void delete(int id){ repositories.deleteById(id);}
    StudentEntity save(StudentEntity student){return repositories.save(student);}

}
